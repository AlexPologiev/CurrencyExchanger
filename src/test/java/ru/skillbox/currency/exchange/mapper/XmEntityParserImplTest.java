package ru.skillbox.currency.exchange.mapper;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class XmEntityParserImplTest {

    @Test
    void convertXmlToEntity() {

        XmlEntityParserImpl parser = new XmlEntityParserImpl();

        String xmlTest = "<ValCurs Date=\"20.11.2024\" name=\"Foreign Currency Market\">\n" +
                "<Valute ID=\"R01010\">\n" +
                "<NumCode>036</NumCode>\n" +
                "<CharCode>AUD</CharCode>\n" +
                "<Nominal>1</Nominal>\n" +
                "<Name>Австралийский доллар</Name>\n" +
                "<Value>65,1026</Value>\n" +
                "<VunitRate>65,1026</VunitRate>\n" +
                "</Valute>\n" +
                "</ValCurs>";
        List<XmlValute> list = parser.convertToEntity(xmlTest);
        XmlValute valute = list.get(0);
        assertNotNull(valute);
        assertThat(valute.getValue()).isEqualTo(65.126d);
    }
}
