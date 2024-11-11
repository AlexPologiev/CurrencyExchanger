package ru.skillbox.currency.exchange.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.skillbox.currency.exchange.entity.Currency;

import java.util.List;

@Mapper(componentModel = "spring")
public interface XmlValuteCurrencyMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isoNumCode", source = "numCode")
    @Mapping(target = "isoCharCode", source = "charCode")
    Currency map(XmlValute valute);
    List<Currency> mapToList (List<XmlValute> list);
}
