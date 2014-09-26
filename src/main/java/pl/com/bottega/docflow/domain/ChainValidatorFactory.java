package pl.com.bottega.docflow.domain;

import java.util.ArrayList;
import java.util.List;

public class ChainValidatorFactory {

    public ChainValidatorFactory() {}

    public ChainValidator create() {
        List<Criterion> criterions = loadCriterions();
        return new ChainValidator(criterions);
    }

    //load from system settings depending on used quality system
    private ArrayList<Criterion> loadCriterions() {
        return new ArrayList<Criterion>();
    }
}
