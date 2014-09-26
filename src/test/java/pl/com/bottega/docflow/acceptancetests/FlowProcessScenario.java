package pl.com.bottega.docflow.acceptancetests;

import java.util.UUID;

import org.junit.Test;

import pl.com.bottega.docflow.application.FlowProcess;
import pl.com.bottega.docflow.domain.DocumentNumber;
import pl.com.bottega.docflow.domain.DocumentType;

public class FlowProcessScenario {
	
	private FlowProcess flowProcess = new FlowProcess();

	@Test
	public void standardProcess(){
		UUID creator = UUID.randomUUID();
		UUID verifier = UUID.randomUUID();
		DocumentType documentType = DocumentType.PROCEDURE;
		
		DocumentNumber documentNumber = flowProcess.createDocument(creator, documentType, "procedure 1");
		flowProcess.verifyDocument(verifier, documentNumber);
		flowProcess.publishDocument(documentNumber);
	}
}
