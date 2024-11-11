package ru.skillbox.currency.exchange.mapper;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ValCurs")
public class XmlValuteCurs {
    private List<XmlValute> valutes;

    public List<XmlValute> getValutes() {
        return valutes;
    }

    @XmlElement(name = "Valute")
    public void setValutes(List<XmlValute> valutes) {
        this.valutes = valutes;
    }
}
