package pl.com.bottega.docflow.domain;

public class NumberGeneratorISO implements NumberGenerator{

	public DocumentNumber generate() {
		return new DocumentNumber("ISO1");
	}

}
