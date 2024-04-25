package com.t3t.couponapi.config;

import com.t3t.couponapi.keymanager.service.SecretKeyManagerService;
import com.t3t.couponapi.property.DatabaseProperties;
import com.t3t.couponapi.property.SecretKeyProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
@Slf4j
public class DatabasePropertiesConfig {

    private String databaseUrl;
    private String driverClassName;
    private String username;
    private String password;

    @Bean
    @Profile({"prod", "dev", "test"})
    public DatabaseProperties dataSourceProperties(SecretKeyManagerService secretKeyManagerService,
                                                   SecretKeyProperties secretKeyProperties,
                                                   Environment environment) {

        String activeProfile = environment.getActiveProfiles()[0];
        String activeProfileSuffix = activeProfile.equals("prod") ? "" : "_" + activeProfile;

        return DatabaseProperties.builder()
                .databaseUrl(String.format("jdbc:mysql://%s:%s/%s%s",
                        secretKeyManagerService.getSecretValue(secretKeyProperties.getDatabaseIpAddressKeyId()),
                        secretKeyManagerService.getSecretValue(secretKeyProperties.getDatabasePortKeyId()),
                        secretKeyManagerService.getSecretValue(secretKeyProperties.getDatabaseNameKeyId()),
                        activeProfileSuffix))
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .username(secretKeyManagerService.getSecretValue(secretKeyProperties.getDatabaseUsernameKeyId()))
                .password(secretKeyManagerService.getSecretValue(secretKeyProperties.getDatabasePasswordKeyId()))
                .build();
    }

    @Bean
    @Profile("local")
    public DatabaseProperties localDataSourceProperties(
            @Value("${t3t.datasource.url}") String databaseUrl,
            @Value("${t3t.datasource.driverClassName}") String driverClassName,
            @Value("${t3t.datasource.username}") String userName,
            @Value("${t3t.datasource.password}") String password) {

        return DatabaseProperties.builder()
                .databaseUrl(databaseUrl)
                .driverClassName(driverClassName)
                .username(userName)
                .password(password)
                .build();
    }
}
