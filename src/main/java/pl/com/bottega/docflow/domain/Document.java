package pl.com.bottega.docflow.domain;

import java.util.Date;
import java.util.List;

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
	private Date expireDate;

	private Money publishCost;
	
	public Document(DocumentType type, DocumentNumber number, Date createDate, DocumentStatus status, User author,
                    Date expireDate){
		this.type = type;
		this.number = number;
		this.createDate = createDate;
		this.status = status;
        this.author = author;
        this.expireDate = expireDate;
    }
	
	public List<Problem> verify(User verifier, Validator validator){
        List<Problem> problems = validator.validate(this, DocumentStatus.VERIFIED);
        if (problems.isEmpty()) {
            status = DocumentStatus.VERIFIED;
        }
        return problems;
    }
	
	public List<Problem> publish(CostCalculator costCalculator, Validator validator){
        List<Problem> problems = validator.validate(this, DocumentStatus.PUBLISHED);
        if (!problems.isEmpty()) {
            status = DocumentStatus.PUBLISHED;
            publishCost = costCalculator.calculate(type);
        }
        return problems;
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

    public User getAuthor() {
        return author;
    }

    public DocumentType getType() {
        return type;
    }

    public DocumentStatus getStatus() {
        return status;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
