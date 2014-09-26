package pl.com.bottega.docflow.application;

import pl.com.bottega.docflow.domain.*;
import pl.com.bottega.docflow.infrastructure.repo.FakeDocumentRepository;
import pl.com.bottega.docflow.infrastructure.repo.FakeUserRepository;

import java.util.List;
import java.util.UUID;

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
	
	public void verifyDocument(UUID verifierId, DocumentNumber documentNumber){
        Document document = documentRepo.load(documentNumber);
        User verifier = userRepo.load(verifierId);
        ChainValidatorFactory chainValidatorFactory = new ChainValidatorFactory();
        Validator validator = chainValidatorFactory.create();

        List<Problem> problems = document.verify(verifier, validator);
        if (!problems.isEmpty()) {
            // DO STH WITH PROBLEMS
        }
    }
	
	public void publishDocument(DocumentNumber documentNumber){
		Document document = documentRepo.load(documentNumber);

        ChainValidatorFactory chainValidatorFactory = new ChainValidatorFactory();
        Validator validator = chainValidatorFactory.create();


        DocumentDescriptor documentDescriptor = document.generateDescriptor();
        CostCalculator calculator = costCalculatorFactory.create(documentDescriptor);

        List<Problem> problems = document.publish(calculator, validator);
        if (!problems.isEmpty()) {
            // DO STH WITH PROBLEMS
        }
    }
}
