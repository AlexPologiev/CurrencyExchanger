package ru.skillbox.currency.exchange.mapper;

import java.util.List;

public interface XmlParser {
    List<XmlValute> convertToEntity(String xml);
}
