package ru.skillbox.currency.exchange.mapper;

import org.mapstruct.Mapper;
import ru.skillbox.currency.exchange.dto.ShortCurrencyDto;
import ru.skillbox.currency.exchange.entity.Currency;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShortCurrencyMapper {

    List<ShortCurrencyDto> mapToList(List<Currency> list);

    ShortCurrencyDto convertToDto(Currency currency);

}
