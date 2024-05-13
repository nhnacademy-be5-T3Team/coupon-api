package com.t3t.couponapi.coupon.repository.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.t3t.couponapi.coupon.model.response.PolicyResponse;
import com.t3t.couponapi.coupon.repository.CouponPolicyRepositoryCustom;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.t3t.couponapi.coupon.model.entity.QCouponPolicy.couponPolicy;

@RequiredArgsConstructor
public class CouponPolicyRepositoryImpl implements CouponPolicyRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<PolicyResponse> getAllPolicies() {
        return jpaQueryFactory
                .select(Projections.fields(PolicyResponse.class,
                        couponPolicy.couponPolicyId,
                        couponPolicy.discountFee,
                        couponPolicy.discountRate,
                        couponPolicy.maximumDiscountPrice,
                        couponPolicy.minimumPrice))
                .from(couponPolicy)
                .fetch();
    }
}
