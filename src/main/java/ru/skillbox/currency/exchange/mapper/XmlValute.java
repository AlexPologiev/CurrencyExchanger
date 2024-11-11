package ru.skillbox.currency.exchange.mapper;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Valute")
public class XmlValute {
    private Integer numCode;
    private String charCode;
    private Integer nominal;
    private String name;
    private Double value;

    @XmlElement(name = "CharCode")
    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public Integer getNominal() {
        return nominal;
    }


    @XmlElement(name = "Nominal")
    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "Name")
    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    @XmlElement(name = "Value")
    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getNumCode() {
        return numCode;
    }

    @XmlElement(name = "NumCode")
    public void setNumCode(Integer numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }


}
