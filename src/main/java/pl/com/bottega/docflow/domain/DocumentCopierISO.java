package pl.com.bottega.docflow.domain;

import java.util.Calendar;
import java.util.Date;

public class DocumentCopierISO extends AbstractDocumentCopier {
    private NumberGenerator numberGenerator;
    private int monthsForDateToExpire = 12;

    public DocumentCopierISO(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    protected DocumentNumber getNumber() {
        return numberGenerator.generate();
    }

    @Override
    protected Date getExpireDate(Document document) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(document.getCreateDate());
        calendar.add(Calendar.MONTH, monthsForDateToExpire);
        return calendar.getTime();
    }
}
