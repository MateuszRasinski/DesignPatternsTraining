package pl.com.bottega.docflow.domain;

import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.Assert.assertEquals;

public class MoneyTest {
    @Test
    public void shouldBeEqualsWhenDifferentPrecision() throws Exception {
        assertEquals(new Money("1.0"),
                    new Money("1.00"));
    }

    @Test
    public void shouldAddWhenSameCurrency() throws Exception {
        Money m1 = new Money("2", "PLN");
        Money m2 = new Money("3", "PLN");
        Money expected = new Money("5", "PLN");

        Money sum = m1.add(m2);

        assertEquals(expected, sum);
    }

    @Test
    public void shouldMultiply() throws Exception {
        Money m1 = new Money("1.33");
        BigDecimal x = new BigDecimal("3.1");
        Money expected = new Money("4.123");

        Money multiplication = m1.multiply(x);

        assertEquals(expected, multiplication);
    }
}