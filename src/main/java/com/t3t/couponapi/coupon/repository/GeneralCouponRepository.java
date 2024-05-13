package com.t3t.couponapi.coupon.repository;

import com.t3t.couponapi.coupon.model.entity.GeneralCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralCouponRepository extends JpaRepository<GeneralCoupon, String> {
}
