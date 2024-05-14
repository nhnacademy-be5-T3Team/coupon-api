package com.t3t.couponapi.coupon.repository.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.t3t.couponapi.coupon.model.entity.GeneralCoupon;
import com.t3t.couponapi.coupon.repository.GeneralCouponRepositoryCustom;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.t3t.couponapi.coupon.model.entity.QGeneralCoupon.generalCoupon;

@RequiredArgsConstructor
public class GeneralCouponRepositoryImpl implements GeneralCouponRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public Optional<GeneralCoupon> getGeneralCoupon() {
        return Optional.ofNullable(jpaQueryFactory.select(Projections.fields(GeneralCoupon.class,
                        generalCoupon.couponId,
                        generalCoupon.couponType,
                        generalCoupon.couponExpireDate,
                        generalCoupon.isUsed,
                        generalCoupon.policies))
                .from(generalCoupon)
                .where(generalCoupon.isUsed.eq(false))
                .fetchFirst());
    }
}
