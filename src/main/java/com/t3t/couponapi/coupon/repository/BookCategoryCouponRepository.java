package com.t3t.couponapi.coupon.repository;

import com.t3t.couponapi.coupon.model.entity.BookCategoryCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryCouponRepository extends JpaRepository<BookCategoryCoupon, String> {
}
