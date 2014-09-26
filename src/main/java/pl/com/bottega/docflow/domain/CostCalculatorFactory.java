package pl.com.bottega.docflow.domain;

//@Component
public class CostCalculatorFactory {
    public CostCalculator create(DocumentDescriptor documentDescriptor) {

        CostCalculator calc = createBase();

        if (documentDescriptor.getType() == DocumentType.MANUAL) {
            calc = new CostCalculatorPercent(calc, 30);
        }
        return calc;
    }

    private CostCalculator createBase() {
        return new CostCalculatorPrinterXYZ();
    }
}
