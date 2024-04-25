package com.t3t.couponapi.property;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Profile("!local")
@Getter
@Component
public class SecretKeyProperties {
    @Value("${t3t.secretKeyManager.secrets.databaseServerIpAddress.keyId}")
    private String databaseIpAddressKeyId;
    @Value("${t3t.secretKeyManager.secrets.databaseServerPort.keyId}")
    private String databasePortKeyId;
    @Value("${t3t.secretKeyManager.secrets.databaseServerUsername.keyId}")
    private String databaseNameKeyId;
    @Value("${t3t.secretKeyManager.secrets.databaseName.keyId}")
    private String databaseUsernameKeyId;
    @Value("${t3t.secretKeyManager.secrets.databaseServerPassword.keyId}")
    private String databasePasswordKeyId;
}
