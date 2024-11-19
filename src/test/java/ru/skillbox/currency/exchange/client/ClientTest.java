package ru.skillbox.currency.exchange.client;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ClientTest {

    @Test
    void whenNotConnectedThrowIOExceptions(){
        HttpGet httpGet = new HttpGet("TEST-NET-1");
        HttpClient httpClient = HttpClientBuilder.create()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();

        assertThatThrownBy(() ->httpClient.execute(httpGet))
                .isInstanceOf(IOException.class);

    }
}
