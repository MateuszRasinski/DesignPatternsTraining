package pl.com.bottega.docflow.domain;

import java.util.List;

public interface Validator {
    List<Problem> validate(Document document, DocumentStatus requestedStatus);
}
