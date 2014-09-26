package pl.com.bottega.docflow.application;

import java.util.UUID;
import pl.com.bottega.docflow.domain.CostCalculator;
import pl.com.bottega.docflow.domain.CostCalculatorFactory;
import pl.com.bottega.docflow.domain.Document;
import pl.com.bottega.docflow.domain.DocumentDescriptor;
import pl.com.bottega.docflow.domain.DocumentFactory;
import pl.com.bottega.docflow.domain.DocumentNumber;
import pl.com.bottega.docflow.domain.DocumentRepository;
import pl.com.bottega.docflow.domain.DocumentType;
import pl.com.bottega.docflow.domain.User;
import pl.com.bottega.docflow.domain.UserRepository;
import pl.com.bottega.docflow.infrastructure.repo.FakeDocumentRepository;
import pl.com.bottega.docflow.infrastructure.repo.FakeUserRepository;

//@Service
//@Transactional
public class FlowProcess {
	
	//@Inject
	private DocumentRepository documentRepo = new FakeDocumentRepository();
	
	//@Inject
	private UserRepository userRepo = new FakeUserRepository();
    private CostCalculatorFactory costCalculatorFactory;


    public DocumentNumber createDocument(UUID creatorId, DocumentType type, String title){
		DocumentFactory documentFactory = new DocumentFactory(SystemSettings.getDefaultNumberGenerator());
		
		User creator = userRepo.load(creatorId);
		Document document = documentFactory.create(SystemSettings.getDefaultDocumentType(), "Ala ma kota", creator);
		documentRepo.save(document);
		return document.getNumber();
	}
	
	public void verifyDocument(UUID verifier, DocumentNumber documentNumber){
		
	}
	
	public void publishDocument(DocumentNumber documentNumber){
		Document document = documentRepo.load(documentNumber);
        DocumentDescriptor documentDescriptor = document.generateDescriptor();

        CostCalculator calculator = costCalculatorFactory.create(documentDescriptor);
        document.publish(calculator);
	}
}
