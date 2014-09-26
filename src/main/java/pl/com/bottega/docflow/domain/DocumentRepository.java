package pl.com.bottega.docflow.domain;

import java.util.UUID;

public interface DocumentRepository {

	void save(Document document);

	Document load(DocumentNumber number);
	
	Document load(UUID id);
}
