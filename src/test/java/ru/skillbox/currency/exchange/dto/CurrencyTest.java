package ru.skillbox.currency.exchange.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CurrencyTest {

    @Test
    @DisplayName("Проверка геттеров")
    void fieldsMatch(){

        CurrencyDto dto = new CurrencyDto(1L,"name",2L,3d,4L,"code");

        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getName()).isEqualTo("name");
        assertThat(dto.getNominal()).isEqualTo(2L);
        assertThat(dto.getValue()).isEqualTo(3d);
        assertThat(dto.getIsoNumCode()).isEqualTo(4L);
        assertThat(dto.getIsoCharCode()).isEqualTo("cde");

    }
}
