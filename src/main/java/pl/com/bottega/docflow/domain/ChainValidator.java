package pl.com.bottega.docflow.domain;

import java.util.ArrayList;
import java.util.List;

public class ChainValidator implements Validator {
    private List<Criterion> criterions;

    @Override
    public List<Problem> validate(Document document, DocumentStatus requestedStatus) {
        List<Problem> problems = new ArrayList<>();

        for (Criterion criterion : criterions) {
            if (criterion.isApplicable(requestedStatus)) {
                problems.add(criterion.check(document));
            }
        }

        return problems;
    }
}
