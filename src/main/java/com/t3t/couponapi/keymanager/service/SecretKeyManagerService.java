package com.t3t.couponapi.keymanager.service;

import com.t3t.couponapi.keymanager.SecretKeyManagerApiRequestFailedException;
import com.t3t.couponapi.keymanager.model.response.SecretKeyManagerResponse;
import com.t3t.couponapi.property.SecretKeyManagerProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Profile("!local")
@Slf4j
@Service
@RequiredArgsConstructor
public class SecretKeyManagerService {
    @Qualifier("sslRestTemplate")
    private final RestTemplate sslRestTemplate;
    private final SecretKeyManagerProperties secretKeyManagerProperties;

    private static final ParameterizedTypeReference<SecretKeyManagerResponse> secretKeyManagerResponseTypeReference
            = new ParameterizedTypeReference<SecretKeyManagerResponse>() {
    };

    public String getSecretValue(String keyId) {

        HttpEntity<SecretKeyManagerResponse> response =
                sslRestTemplate.exchange("https://api-keymanager.nhncloudservice.com/keymanager/v1.0/appkey/{appKey}/secrets/{keyId}",
                        HttpMethod.GET, null, secretKeyManagerResponseTypeReference,
                        secretKeyManagerProperties.getAppKey(), keyId);

        SecretKeyManagerResponse responseBody = response.getBody();

        if (responseBody == null) {
            throw new SecretKeyManagerApiRequestFailedException("Response body is null.");
        }

        if (responseBody.getHeader() == null || responseBody.getBody() == null || !responseBody.getHeader().getIsSuccessful().equals("true") || responseBody.getBody().getSecret() == null) {
            log.error("Secret Key Manager API response: {}", responseBody);
            throw new SecretKeyManagerApiRequestFailedException(String.format("Fail to request Secret Key Manager API (Key ID: %s)", keyId));
        }

        return responseBody.getBody().getSecret();
    }
}
