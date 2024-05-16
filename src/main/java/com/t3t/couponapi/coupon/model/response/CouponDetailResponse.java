package com.t3t.couponapi.coupon.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponDetailResponse {
    public BigDecimal discountRate;
    public BigDecimal discountFee;
    public LocalDate couponExpireDate;
    public String couponType;
}
