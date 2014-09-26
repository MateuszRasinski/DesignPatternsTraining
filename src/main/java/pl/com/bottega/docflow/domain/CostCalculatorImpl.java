package pl.com.bottega.docflow.domain;

import java.math.BigDecimal;
import java.util.Currency;

public class CostCalculatorImpl implements CostCalculator{

	public Money calculate(DocumentType documentType) {
		return new Money(BigDecimal.ONE, Currency.getInstance("PLN"));
	}

}
