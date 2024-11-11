package ru.skillbox.currency.exchange;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.skillbox.currency.exchange.client.BankClient;

@Slf4j
@Data
@Component
public class Run implements CommandLineRunner {

    private final BankClient bankClient;

    @Override
    public void run(String... args) throws Exception {
        log.info(bankClient.getCursInfo());
    }
}
