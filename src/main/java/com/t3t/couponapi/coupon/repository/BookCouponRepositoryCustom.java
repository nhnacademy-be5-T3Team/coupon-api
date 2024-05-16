package com.t3t.couponapi.coupon.repository;

import com.t3t.couponapi.coupon.model.entity.BookCoupon;
import com.t3t.couponapi.coupon.model.response.BookCouponResponse;

import java.util.List;
import java.util.Optional;

public interface BookCouponRepositoryCustom {
    List<BookCouponResponse> getAllBookCoupons();
    Optional<BookCoupon> getBookCoupon();
}
