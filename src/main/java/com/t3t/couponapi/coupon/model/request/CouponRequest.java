package com.t3t.couponapi.coupon.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CouponRequest {
    private Integer couponPolicyId;
    private String couponType;
    private LocalDate couponExpireDate;
}
