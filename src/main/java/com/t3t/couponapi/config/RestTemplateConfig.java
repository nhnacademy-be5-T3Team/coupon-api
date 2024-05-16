package com.t3t.couponapi.config;

import com.t3t.couponapi.property.SecretKeyManagerProperties;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.time.Duration;


@Configuration
public class RestTemplateConfig {

    @Bean
    @Profile("!local")
    public RestTemplate sslRestTemplate(SecretKeyManagerProperties secretKeyManagerProperties)
            throws KeyStoreException, IOException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException, CertificateException {

        KeyStore keyStore = KeyStore.getInstance(secretKeyManagerProperties.getCertKeyType());

        keyStore.load(secretKeyManagerProperties.getCertKey().getInputStream(),
                secretKeyManagerProperties.getPassword().toCharArray());

        RestTemplate sslRestTemplate = new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofSeconds(5))
                .setConnectTimeout(Duration.ofSeconds(5))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();

        sslRestTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(HttpClients.custom()
                .setSSLSocketFactory(new SSLConnectionSocketFactory(SSLContextBuilder.create()
                        .loadKeyMaterial(keyStore, secretKeyManagerProperties.getPassword().toCharArray()).build())).build()));

        return sslRestTemplate;
    }
}
