package ru.skillbox.currency.exchange.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.skillbox.currency.exchange.client.BankClient;
import ru.skillbox.currency.exchange.entity.Currency;
import ru.skillbox.currency.exchange.mapper.XmlParser;
import ru.skillbox.currency.exchange.mapper.XmlValute;
import ru.skillbox.currency.exchange.mapper.XmlValuteCurrencyMapper;
import ru.skillbox.currency.exchange.repository.CurrencyRepository;

import java.util.List;

@Slf4j
@Data
@Component
@EnableScheduling
public class UpdateCurrencyService {
    private final BankClient bankClient;
    private final XmlParser xmlParser;
    private final XmlValuteCurrencyMapper mapper;
    private final CurrencyRepository repository;

    @Scheduled(cron = "${currency.update.rate.cron}")
    public void updateCurrency() {
        String xmlString;
        try {
            xmlString = bankClient.getCursInfo();
            List<Currency> listCurrency = convertXmlToCurrency(xmlString);
            update(listCurrency);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    private List<Currency> convertXmlToCurrency(String xml) {
        List<XmlValute> list = xmlParser.convertToEntity(xml);
        return mapper.mapToList(list);
    }

    private void update(List<Currency> list) {
        for (Currency currency : list) {
            Long isoNumCode = currency.getIsoNumCode();
            Currency currencyDb = repository.findByIsoNumCode(isoNumCode);
            if (currencyDb == null) {
                repository.save(currency);
            } else {
                currencyDb.setName(currency.getName());
                currencyDb.setValue(currency.getValue());
                currencyDb.setNominal(currency.getNominal());
                currencyDb.setIsoCharCode(currency.getIsoCharCode());
                repository.save(currencyDb);
            }

        }

    }

}
