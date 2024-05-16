package com.t3t.couponapi.coupon.repository;

import com.t3t.couponapi.coupon.model.entity.CategoryCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryCouponRepository extends JpaRepository<CategoryCoupon, String>, CategoryCouponRepositoryCustom{
}
