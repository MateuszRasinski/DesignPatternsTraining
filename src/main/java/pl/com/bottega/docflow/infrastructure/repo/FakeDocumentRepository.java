package pl.com.bottega.docflow.infrastructure.repo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import pl.com.bottega.docflow.domain.Document;
import pl.com.bottega.docflow.domain.DocumentNumber;
import pl.com.bottega.docflow.domain.DocumentRepository;

//@Repository
public class FakeDocumentRepository implements DocumentRepository {

	private static Map<DocumentNumber, Document> fakeDatatbase = new HashMap<DocumentNumber, Document>();
	
	public void save(Document document) {
		fakeDatatbase.put(document.getNumber(), document);
	}

	public Document load(DocumentNumber number) {
		return fakeDatatbase.get(number);
	}

	public Document load(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
