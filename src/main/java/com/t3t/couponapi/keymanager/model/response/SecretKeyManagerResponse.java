package com.t3t.couponapi.keymanager.model.response;

import lombok.Getter;

@Getter
public class SecretKeyManagerResponse {
    private SecretKeyManagerResponseHeaderPartDto header;
    private SecretKeyManagerResponseBodyPartDto body;

    @Getter
    public static class SecretKeyManagerResponseHeaderPartDto {
        private int resultCode;
        private String resultMessage;
        private String isSuccessful;
    }

    @Getter
    public static class SecretKeyManagerResponseBodyPartDto {
        private String secret;
    }
}
