package ru.skillbox.currency.exchange.client;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class BankClient {
    private final HttpGet httpGet;
    private final HttpClient httpClient;
    private final String url;

    public BankClient(@Value("${client.url}") String url) {
        this.url = url;
        this.httpGet = new HttpGet(url);
        this.httpClient = HttpClientBuilder.create()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
    }

    public String getCursInfo() throws IOException {
        log.info("Trying to connect to " + url);
        try {
            return EntityUtils.toString(httpClient.execute(httpGet).getEntity());
        } catch (IOException e) {
            log.info("Error while connecting to API", e);
            throw e;
        }
    }

}
