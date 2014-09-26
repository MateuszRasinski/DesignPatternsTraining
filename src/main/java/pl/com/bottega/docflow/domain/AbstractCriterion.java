package pl.com.bottega.docflow.domain;

import java.util.List;

public abstract class AbstractCriterion implements Criterion {
    private List<DocumentStatus> documentStatuses;

    protected AbstractCriterion(List<DocumentStatus> documentStatuses) {
        this.documentStatuses = documentStatuses;
    }

    @Override
    public boolean isApplicable(DocumentStatus requestedStatus) {
        return documentStatuses.contains(documentStatuses);
    }
}
