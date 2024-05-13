package com.t3t.couponapi.coupon.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyResponse {
    private Integer couponPolicyId;
    private BigDecimal discountRate;
    private BigDecimal discountFee;
    private BigDecimal minimumPrice;
    private BigDecimal maximumDiscountPrice;

}
