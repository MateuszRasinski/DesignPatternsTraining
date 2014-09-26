package pl.com.bottega.docflow.domain;

import java.util.List;

public class CriterionAuthorRequired extends AbstractCriterion {
    protected CriterionAuthorRequired(List<DocumentStatus> documentStatuses) {
        super(documentStatuses);
    }

    @Override
    public Problem check(Document document) {
        if (document.getAuthor() != null) {
            return new Problem("Author required!", false);
        }
        return null;
    }
}
