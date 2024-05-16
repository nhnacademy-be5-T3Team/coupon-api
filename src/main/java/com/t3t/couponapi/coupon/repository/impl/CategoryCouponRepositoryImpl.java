package com.t3t.couponapi.coupon.repository.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.t3t.couponapi.coupon.model.entity.CategoryCoupon;
import com.t3t.couponapi.coupon.repository.CategoryCouponRepositoryCustom;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.t3t.couponapi.coupon.model.entity.QCategoryCoupon.categoryCoupon;

@RequiredArgsConstructor
public class CategoryCouponRepositoryImpl implements CategoryCouponRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public Optional<CategoryCoupon> getCategoryCoupon() {
        return Optional.ofNullable(jpaQueryFactory.select(Projections.fields(CategoryCoupon.class,
                        categoryCoupon.couponId,
                        categoryCoupon.couponType,
                        categoryCoupon.couponExpireDate,
                        categoryCoupon.isUsed,
                        categoryCoupon.categoryId,
                        categoryCoupon.policies))
                .from(categoryCoupon)
                .where(categoryCoupon.isUsed.eq(false))
                .fetchFirst());
    }
}
