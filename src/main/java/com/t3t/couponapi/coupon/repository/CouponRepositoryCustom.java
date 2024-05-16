package com.t3t.couponapi.coupon.repository;

import com.t3t.couponapi.coupon.model.response.CouponDetailResponse;

public interface CouponRepositoryCustom {
    CouponDetailResponse getCouponDetails(String id);
}
