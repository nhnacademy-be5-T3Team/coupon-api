package com.t3t.couponapi.keymanager;

public class SecretKeyManagerApiRequestFailedException extends RuntimeException{
    public SecretKeyManagerApiRequestFailedException(String message) {
        super(message);
    }
}
