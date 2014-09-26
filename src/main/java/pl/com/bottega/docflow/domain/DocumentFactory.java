package pl.com.bottega.docflow.domain;

import java.util.Date;

public class DocumentFactory {
	private NumberGenerator nrGenerator;
	
	public DocumentFactory(NumberGenerator nrGenerator){
		nrGenerator = new NumberGeneratorISO();
	}
	
	//1. co jest potrzebne na wejsciu
	public Document create(DocumentType type, String title, User creator){
		//2.walidacja
		
		//3. wartosci poczatkowe
		DocumentNumber nr = nrGenerator.generate();
		Document doc = new Document(type, nr, new Date(), DocumentStatus.DRAFT, creator, new Date());
		
		return doc;
	}
}
