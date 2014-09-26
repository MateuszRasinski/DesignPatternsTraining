package pl.com.bottega.docflow.domain;

import java.math.BigDecimal;

public class CostCalculatorPercent extends BaseCostCalculator {
    private int percent;

    public CostCalculatorPercent(CostCalculator costCalculator, int percent){
        super(costCalculator);
        this.costCalculator = costCalculator;
        this.percent = percent;
    }

	public Money calculate(DocumentType documentType) {
        Money money = costCalculator.calculate(documentType);
        BigDecimal value = money.getValue();
        return new Money(value.multiply(new BigDecimal(percent)), money.getCurrency());
	}

}
