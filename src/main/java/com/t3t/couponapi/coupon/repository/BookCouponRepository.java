package com.t3t.couponapi.coupon.repository;

import com.t3t.couponapi.coupon.model.entity.BookCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCouponRepository extends JpaRepository<BookCoupon, String>, BookCouponRepositoryCustom {
}
