package com.t3t.couponapi.coupon.service;

import com.t3t.couponapi.coupon.model.response.CouponDetailResponse;
import com.t3t.couponapi.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;

    public CouponDetailResponse findCouponDetails(String id){
        return couponRepository.getCouponDetails(id);
    }
}
