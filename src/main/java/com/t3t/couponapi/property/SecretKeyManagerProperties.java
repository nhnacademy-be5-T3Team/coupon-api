package com.t3t.couponapi.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;

@Getter
@Setter
@Profile("!local")
@ConfigurationProperties(prefix = "t3t.secret-key-manager")
public class SecretKeyManagerProperties {
    private String appKey;
    private String password;
    private String certKeyType;
    private String certKeyPath;
    @Value("${t3t.secretKeyManager.certKeyPath}")
    private Resource certKey;
}