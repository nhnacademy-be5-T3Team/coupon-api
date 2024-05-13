package com.t3t.couponapi.coupon.exception;

public class BookApiClientException extends RuntimeException{
    private static final String DEFAULT_MESSAGE = "책 조회 API 호출에 실패하였습니다.";
    public BookApiClientException(){
        super(DEFAULT_MESSAGE);
    }
    public BookApiClientException(String message) {
        super(message);
    }
}

