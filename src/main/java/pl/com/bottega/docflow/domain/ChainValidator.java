package pl.com.bottega.docflow.domain;

import java.util.ArrayList;
import java.util.List;

public class ChainValidator implements Validator {
    private List<Criterion> criterions;

    public ChainValidator(List<Criterion> criterions) {
        this.criterions = criterions;
    }

    @Override
    public List<Problem> validate(Document document, DocumentStatus requestedStatus) {
        List<Problem> problems = new ArrayList<Problem>();

        for (Criterion criterion : criterions) {
            if (criterion.isApplicable(requestedStatus)) {
                Problem problem = criterion.check(document);
                if (problem == null) {
                    continue;
                }
                if (problem.isCritical()) {
                    throw new RuntimeException();
                }
                problems.add(problem);
            }
        }

        return problems;
    }
}
