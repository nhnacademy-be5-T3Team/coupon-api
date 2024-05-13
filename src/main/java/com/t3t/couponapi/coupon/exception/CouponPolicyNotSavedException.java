package com.t3t.couponapi.coupon.exception;

public class CouponPolicyNotSavedException extends RuntimeException{
    private static final String DEFAULT_MESSAGE = "이미 존재하는 정책 번호 입니다.";
    public CouponPolicyNotSavedException(){
        super(DEFAULT_MESSAGE);
    }
    public CouponPolicyNotSavedException(String message) {
        super(message);
    }
}
