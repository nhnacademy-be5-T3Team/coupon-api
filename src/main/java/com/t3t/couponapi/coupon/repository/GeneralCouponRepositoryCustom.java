package com.t3t.couponapi.coupon.repository;

import com.t3t.couponapi.coupon.model.entity.GeneralCoupon;

import java.util.Optional;

public interface GeneralCouponRepositoryCustom {
    Optional<GeneralCoupon> getGeneralCoupon();
}
