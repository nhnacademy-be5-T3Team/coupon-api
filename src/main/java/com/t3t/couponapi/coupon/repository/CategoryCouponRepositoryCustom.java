package com.t3t.couponapi.coupon.repository;

import com.t3t.couponapi.coupon.model.entity.CategoryCoupon;

import java.util.Optional;

public interface CategoryCouponRepositoryCustom {
    Optional<CategoryCoupon> getCategoryCoupon();

}
