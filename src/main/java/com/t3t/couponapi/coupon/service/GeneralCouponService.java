package com.t3t.couponapi.coupon.service;

import com.t3t.couponapi.coupon.exception.CouponNotExistExceptions;
import com.t3t.couponapi.coupon.exception.CouponNotSavedExceptions;
import com.t3t.couponapi.coupon.exception.CouponPolicyNotExistException;
import com.t3t.couponapi.coupon.model.entity.CouponPolicy;
import com.t3t.couponapi.coupon.model.entity.GeneralCoupon;
import com.t3t.couponapi.coupon.model.request.CouponIdRequest;
import com.t3t.couponapi.coupon.model.request.CouponRequest;
import com.t3t.couponapi.coupon.model.response.CouponResponse;
import com.t3t.couponapi.coupon.repository.CouponPolicyRepository;
import com.t3t.couponapi.coupon.repository.GeneralCouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class GeneralCouponService {
    private final GeneralCouponRepository generalCouponRepository;
    private final CouponPolicyRepository couponPolicyRepository;

    public void createGeneralCoupon(CouponRequest request){
        CouponPolicy couponPolicy = couponPolicyRepository.findById(request.getCouponPolicyId()).orElseThrow(()-> new CouponPolicyNotExistException("Coupon Policy Not Exists")        );
        GeneralCoupon generalCoupon = GeneralCoupon.builder()
                .couponId(UUID.randomUUID().toString().replace("-",""))
                .policies(couponPolicy)
                .couponType(request.getCouponType())
                .couponExpireDate(request.getCouponExpireDate())
                .isUsed(false)
                .build();

        GeneralCoupon newCoupon = generalCouponRepository.save(generalCoupon);

        if(!generalCouponRepository.existsById(newCoupon.getCouponId())){
            throw new CouponNotSavedExceptions("Coupon not saved!");
        }
    }

    public String deleteGeneralCouponByAdmin(CouponIdRequest request){
        GeneralCoupon coupon = generalCouponRepository.findById(request.getCouponId()).orElseThrow(() -> new CouponNotExistExceptions("Coupon Not Exists"));
        coupon.deleteCoupon(true);
        return "Delete Succeed";
    }

    public CouponResponse getGeneralCoupon() {
        GeneralCoupon coupon = generalCouponRepository.getGeneralCoupon().orElseThrow(() -> new CouponNotExistExceptions("Coupon Not Exists"));
        coupon.deleteCoupon(true);
        return CouponResponse.builder()
                        .couponId(coupon.getCouponId())
                        .build();
    }
}
