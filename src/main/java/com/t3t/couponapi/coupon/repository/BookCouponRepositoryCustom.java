package com.t3t.couponapi.coupon.repository;

import com.t3t.couponapi.coupon.model.response.BookCouponResponse;

import java.util.List;

public interface BookCouponRepositoryCustom {
    List<BookCouponResponse> getAllBookCoupons();
}
