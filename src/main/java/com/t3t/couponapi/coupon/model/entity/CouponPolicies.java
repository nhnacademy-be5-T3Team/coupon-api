package com.t3t.couponapi.coupon.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity@Table(name = "coupon_policies")
public class CouponPolicies {
    @Id
    @Column(name = "coupon_policy_id")
    private int couponPolicyId;
    @Column(name = "discount_rate")
    private float discountRate;
    @Column(name = "discount_fee")
    private float discountFee;
    @Column(name = "minimum_price")
    private float minimumPrice;
    @Column(name = "maximun_discount_price")
    private float maximumDiscountPrice;
}
