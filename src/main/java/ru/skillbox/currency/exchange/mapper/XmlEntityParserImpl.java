package ru.skillbox.currency.exchange.mapper;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.List;

@Component
public class XmlEntityParserImpl implements XmlParser {

    @Override
    public List<XmlValute> convertToEntity(String xml) {
        StringReader reader = new StringReader(xml.replaceAll(",", "."));
        JAXBContext context;
        XmlValuteCurs xmlValuteCurs;
        try {
            context = JAXBContext.newInstance(XmlValuteCurs.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            xmlValuteCurs = (XmlValuteCurs) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return xmlValuteCurs.getValutes();
    }
}
