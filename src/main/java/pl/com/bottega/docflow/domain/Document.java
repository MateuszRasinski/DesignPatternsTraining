package pl.com.bottega.docflow.domain;

import java.util.Date;

//@Entity
public class Document {

	//@Embeded
	private DocumentNumber number;
	
	private DocumentStatus status;
	
	private DocumentType type;
	
	//@ManyToOne
	private User author;
	
	private String phisicalPath;
	
	private Date createDate;
	
	private Money publishCost;
	
	public Document(DocumentType type, DocumentNumber number, Date createDate, DocumentStatus status){
		this.type = type;
		this.number = number;
		this.createDate = createDate;
		this.status = status;
	}
	
	public void verify(User verifier, Validator validator){
		validator.validate(this, DocumentStatus.VERIFIED);
	}
	
	public void publish(CostCalculator costCalculator){
		if (status != DocumentStatus.VERIFIED)
			throw new IllegalStateException("Invalid status");
		status = DocumentStatus.PUBLISHED;
		publishCost = costCalculator.calculate(type);
	}
	
	public void archive(){
		//TODO
	}

	public DocumentNumber getNumber() {
		return number;
	}


    public DocumentDescriptor generateDescriptor() {
        return new DocumentDescriptor(type, number, status);
    }
}
