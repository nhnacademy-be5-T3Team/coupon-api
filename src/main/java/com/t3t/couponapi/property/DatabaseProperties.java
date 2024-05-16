package com.t3t.couponapi.property;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatabaseProperties {
    private String databaseUrl;
    private String driverClassName;
    private String username;
    private String password;
}
