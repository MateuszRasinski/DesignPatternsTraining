package pl.com.bottega.docflow.domain;

import java.util.Date;

public abstract class AbstractDocumentCopier implements DocumentCopier {
    @Override
    public Document copy(Document document) {
        DocumentNumber number = getNumber();
        Date createDate = new Date();
        Date expireDate = getExpireDate(document);
        DocumentType type = document.getType();
        DocumentStatus status = DocumentStatus.DRAFT;
        User author = document.getAuthor();
        return new Document(type, number, createDate, status, author, expireDate);
    }

    protected abstract DocumentNumber getNumber();
    protected abstract Date getExpireDate(Document document);
}
