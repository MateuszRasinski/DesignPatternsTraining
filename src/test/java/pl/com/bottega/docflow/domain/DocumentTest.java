package pl.com.bottega.docflow.domain;

import org.junit.Test;

public class DocumentTest {

    @Test
    public void shouldNotPublishPublishedDocument() throws Exception {
        givenDocument().published().build();
    }

    private DocumentAssembler givenDocument() {
        return new DocumentAssembler();
    }


}