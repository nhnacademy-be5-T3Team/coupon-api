package com.t3t.couponapi.coupon.repository;

import com.t3t.couponapi.coupon.model.response.PolicyResponse;

import java.util.List;

public interface CouponPolicyRepositoryCustom {
    List<PolicyResponse> getAllPolicies();
}
