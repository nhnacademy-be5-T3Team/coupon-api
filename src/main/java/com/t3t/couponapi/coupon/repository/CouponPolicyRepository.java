package com.t3t.couponapi.coupon.repository;

import com.t3t.couponapi.coupon.model.entity.CouponPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponPolicyRepository extends JpaRepository<CouponPolicy, Integer> , CouponPolicyRepositoryCustom {
}
