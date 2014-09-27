package pl.com.bottega.docflow.domain;

import java.util.Date;
import java.util.UUID;

public class DocumentAssembler {
    private User author = new User(new UUID(1L, 1L));
    private DocumentStatus status = DocumentStatus.DRAFT;
    private Date createdDate = new Date();
    private DocumentType type = DocumentType.MANUAL;
    private DocumentNumber number = new NumberGeneratorISO().generate();
    private Date expiryDate = new Date();

    public DocumentAssembler createdBy(User author) {
        this.author = author;
        return this;
    }

    public DocumentAssembler published() {
        status = DocumentStatus.PUBLISHED;
        createdDate = new Date(new Date().getTime() + 3600);
        return this;
    }

    public Document build() {
        return new Document(type, number, createdDate, status, author, expiryDate);
    }
}