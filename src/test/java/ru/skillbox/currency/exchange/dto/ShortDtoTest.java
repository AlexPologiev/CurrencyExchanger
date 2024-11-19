package ru.skillbox.currency.exchange.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ShortDtoTest {

    @Test
    void fieldsMatch(){

        ShortCurrencyDto dto = new ShortCurrencyDto("Rub", 1d);

        assertThat(dto.getName()).isEqualTo("Rub");
        assertThat(dto.getValue()).isEqualTo(1d);
    }

}
