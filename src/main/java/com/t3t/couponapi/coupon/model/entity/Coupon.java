package com.t3t.couponapi.coupon.model.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@Getter@SuperBuilder
@Entity@Table(name = "coupons")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon {
    @Id
    @Column(name = "coupon_id")
    private String couponId;

    @Column(name = "coupon_type")
    private String couponType;

    @Column(name = "coupon_expire_date")
    private LocalDate couponExpireDate;

    @JoinColumn(name = "coupon_policy_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CouponPolicies policies;

    public Coupon(String couponId, String couponType, LocalDate couponExpireDate, CouponPolicies policies){
        this.couponId = couponId;
        this.couponType = couponType;
        this.couponExpireDate = couponExpireDate;
        this.policies = policies;
    }
}
