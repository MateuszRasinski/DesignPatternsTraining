package pl.com.bottega.docflow.domain;

public interface Criterion {
    boolean isApplicable(DocumentStatus requestedStatus);
    Problem check(Document document);
}
