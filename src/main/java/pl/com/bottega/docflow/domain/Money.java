package pl.com.bottega.docflow.domain;

import java.math.BigDecimal;
import java.util.Currency;

public class Money {
	private BigDecimal value;
	private Currency currency;

    public Money(String value) {
        this.value = new BigDecimal(value);
        this.currency = Currency.getInstance("PLN");
    }

	public Money(BigDecimal value, Currency currency){
		this.value = value;
		this.currency = currency;
	}

    public Money(String value, String currency) {
        this(new BigDecimal(value), Currency.getInstance(currency));
    }

    public Money add(Money money) {
        if (!currency.equals(money.getCurrency())) {
            throw new IllegalArgumentException();
        }
        BigDecimal added = value.add(money.getValue());
        return new Money(added, currency);
    }

    public Money multiply(long x) {
        BigDecimal multiplied = new BigDecimal(x).multiply(value);
        return new Money(multiplied, currency);
    }

    public Money multiply(BigDecimal x) {
        BigDecimal multiplied = x.multiply(value);
        return new Money(multiplied, currency);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;

        Money money = (Money) o;

        if (!currency.equals(money.currency)) return false;
        if (value.compareTo(money.value) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + currency.hashCode();
        return result;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                ", currency=" + currency +
                '}';
    }
}
