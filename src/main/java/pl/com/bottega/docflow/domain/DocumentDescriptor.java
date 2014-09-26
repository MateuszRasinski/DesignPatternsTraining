package pl.com.bottega.docflow.domain;

//@Entity
public class DocumentDescriptor {

	//@Embeded
	private DocumentNumber number;

	private DocumentStatus status;

	private DocumentType type;

	public DocumentDescriptor(DocumentType type, DocumentNumber number, DocumentStatus status){
		this.type = type;
		this.number = number;
		this.status = status;
	}


    public DocumentStatus getStatus() {
        return status;
    }


    public DocumentType getType() {
        return type;
    }
}
