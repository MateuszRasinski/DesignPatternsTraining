package pl.com.bottega.docflow.application;

import pl.com.bottega.docflow.domain.CostCalculator;
import pl.com.bottega.docflow.domain.CostCalculatorPercent;
import pl.com.bottega.docflow.domain.DocumentType;
import pl.com.bottega.docflow.domain.NumberGenerator;
import pl.com.bottega.docflow.domain.NumberGeneratorISO;

public class SystemSettings {
	public static DocumentType getDefaultDocumentType(){
		return DocumentType.PROCEDURE;
	}
	
	public static NumberGenerator getDefaultNumberGenerator(){
		return new NumberGeneratorISO();
	}
	
	public static CostCalculator getDefaultPrintoutCostCalculator(){
		return new CostCalculatorPercent();
	}
	
}
