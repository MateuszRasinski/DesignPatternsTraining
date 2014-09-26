package pl.com.bottega.docflow.domain;

public abstract class BaseCostCalculator implements CostCalculator {
    protected CostCalculator costCalculator;

    public BaseCostCalculator(CostCalculator calc) {
        costCalculator = calc;
    }

    @Override
    public Money calculate(DocumentType documentType) {
        return costCalculator.calculate(documentType);
    }
}
