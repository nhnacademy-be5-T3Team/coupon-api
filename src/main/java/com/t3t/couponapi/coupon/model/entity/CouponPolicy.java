package com.t3t.couponapi.coupon.model.entity;

import com.t3t.couponapi.coupon.model.request.CouponPolicyRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity@Table(name = "coupon_policies")
public class CouponPolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_policy_id")
    private Integer couponPolicyId;
    @Column(name = "discount_rate")
    private BigDecimal discountRate;
    @Column(name = "discount_fee")
    private BigDecimal discountFee;
    @Column(name = "minimum_price")
    private BigDecimal minimumPrice;
    @Column(name = "maximum_discount_price")
    private BigDecimal maximumDiscountPrice;

    public void updateCouponPolicy(CouponPolicyRequest request){
        this.discountRate = request.getDiscountRate();
        this.discountFee = request.getDiscountFee();
        this.minimumPrice = request.getMinimumPrice();
        this.maximumDiscountPrice = request.getMaximumDiscountPrice();
    }
}
