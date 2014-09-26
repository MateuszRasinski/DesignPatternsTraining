package pl.com.bottega.docflow.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class Money {
	private BigDecimal value;
	private Currency currency;
	
	public Money(BigDecimal value, Currency currency){
		this.value = value;
		this.currency = currency;
	}
}
