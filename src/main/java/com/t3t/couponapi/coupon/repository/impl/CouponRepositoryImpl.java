package com.t3t.couponapi.coupon.repository.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.t3t.couponapi.coupon.model.response.CouponDetailResponse;
import com.t3t.couponapi.coupon.repository.CouponRepositoryCustom;
import lombok.RequiredArgsConstructor;

import static com.t3t.couponapi.coupon.model.entity.QCoupon.coupon;
import static com.t3t.couponapi.coupon.model.entity.QCouponPolicy.couponPolicy;

@RequiredArgsConstructor
public class CouponRepositoryImpl implements CouponRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public CouponDetailResponse getCouponDetails(String id) {
        return jpaQueryFactory.select(Projections.fields(CouponDetailResponse.class,
                        couponPolicy.discountRate,
                        couponPolicy.discountFee,
                        coupon.couponExpireDate,
                        coupon.couponType))
                .from(coupon)
                .join(coupon.policies, couponPolicy)
                .where(coupon.couponId.eq(id))
                .fetchFirst();
    }
}
