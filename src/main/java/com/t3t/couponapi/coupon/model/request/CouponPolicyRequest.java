package com.t3t.couponapi.coupon.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponPolicyRequest {
    @NotNull
    private BigDecimal discountRate;
    @NotNull
    private BigDecimal discountFee;
    @NotNull
    private BigDecimal minimumPrice;
    @NotNull
    private BigDecimal maximumDiscountPrice;
}
