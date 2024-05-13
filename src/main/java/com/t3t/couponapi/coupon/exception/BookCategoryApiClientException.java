package com.t3t.couponapi.coupon.exception;

public class BookCategoryApiClientException extends RuntimeException{
    private static final String DEFAULT_MESSAGE = "카테고리 조회 API 호출에 실패하였습니다.";
    public BookCategoryApiClientException(){
        super(DEFAULT_MESSAGE);
    }
    public BookCategoryApiClientException(String message) {
        super(message);
    }
}
