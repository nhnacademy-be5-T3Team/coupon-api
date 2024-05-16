package com.t3t.couponapi.coupon.exception;

public class CouponPolicyNotExistException extends RuntimeException{
    private static final String DEFAULT_MESSAGE = "쿠폰 정책 조회에 실패하였습니다.";
    public CouponPolicyNotExistException(){
        super(DEFAULT_MESSAGE);
    }
    public CouponPolicyNotExistException(String message) {
        super(message);
    }
}
