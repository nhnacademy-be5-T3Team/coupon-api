package com.t3t.couponapi.coupon.repository;

import com.t3t.couponapi.coupon.model.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, String> {
}
