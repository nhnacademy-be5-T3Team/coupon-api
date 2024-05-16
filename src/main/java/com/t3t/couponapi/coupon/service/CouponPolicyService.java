package com.t3t.couponapi.coupon.service;

import com.t3t.couponapi.coupon.exception.CouponPolicyNotExistException;
import com.t3t.couponapi.coupon.exception.CouponPolicyNotSavedException;
import com.t3t.couponapi.coupon.model.entity.CouponPolicy;
import com.t3t.couponapi.coupon.model.request.CouponPolicyRequest;
import com.t3t.couponapi.coupon.model.response.PolicyResponse;
import com.t3t.couponapi.coupon.repository.CouponPolicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CouponPolicyService {
    private final CouponPolicyRepository couponPolicyRepository;

    public List<PolicyResponse> getAllPolicy(){
        List<PolicyResponse> responses = couponPolicyRepository.getAllPolicies();

        if(responses.isEmpty()){
            throw new CouponPolicyNotExistException();
        }

        return responses;
    }

    public void savePolicy(CouponPolicyRequest couponPolicyRequest){
        CouponPolicy couponPolicy = CouponPolicy.builder()
                .discountFee(couponPolicyRequest.getDiscountFee())
                .discountRate(couponPolicyRequest.getDiscountRate())
                .minimumPrice(couponPolicyRequest.getMinimumPrice())
                .maximumDiscountPrice(couponPolicyRequest.getMaximumDiscountPrice())
                .build();
        CouponPolicy newCouponPolicy = couponPolicyRepository.save(couponPolicy);

        if(!couponPolicyRepository.existsById(newCouponPolicy.getCouponPolicyId())) {
            throw new CouponPolicyNotSavedException();
        }
    }

    @Transactional
    public void updatePolicy(CouponPolicyRequest couponPolicyRequest, Integer couponPolicyId){

        CouponPolicy couponPolicy = couponPolicyRepository
                .findById(couponPolicyId)
                .orElseThrow(CouponPolicyNotExistException::new);

        couponPolicy.updateCouponPolicy(couponPolicyRequest);
    }

    @Transactional(readOnly = true)
    public CouponPolicy getPolicy(Integer couponPolicyId){
        Optional<CouponPolicy> couponPolicy = couponPolicyRepository.findById(couponPolicyId);
        if(couponPolicy.isEmpty()){
            throw new CouponPolicyNotExistException();
        }
        return couponPolicy.get();
    }

}