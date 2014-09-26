package pl.com.bottega.docflow.domain;

public class DocumentNumber {

	private String number;
	
	public DocumentNumber(String number){
		this.number = number;
	}
	
	@Override
	public String toString() {
		return number;
	}
}
