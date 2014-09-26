package pl.com.bottega.docflow.domain;

public interface CostCalculator {
	public Money calculate(DocumentType documentType);
}
