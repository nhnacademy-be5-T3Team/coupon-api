package com.t3t.couponapi.coupon.controller;

import com.t3t.couponapi.coupon.model.entity.CouponPolicy;
import com.t3t.couponapi.coupon.model.request.CouponPolicyRequest;
import com.t3t.couponapi.coupon.model.response.BaseResponse;
import com.t3t.couponapi.coupon.model.response.PolicyResponse;
import com.t3t.couponapi.coupon.service.CouponPolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CouponPolicyController {
    private final CouponPolicyService couponPolicyService;

    @GetMapping("/coupon/policy")
    public ResponseEntity<BaseResponse<List<PolicyResponse>>> getAllPolicies(){
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<List<PolicyResponse>>().data(couponPolicyService.getAllPolicy()));
    }

    @GetMapping("/coupon/policy/{policyId}")
    public ResponseEntity<BaseResponse<PolicyResponse>> getPolicy(@PathVariable("policyId") Integer policyId){
        CouponPolicy policy = couponPolicyService.getPolicy(policyId);
        PolicyResponse response = PolicyResponse
                .builder()
                .couponPolicyId(policy.getCouponPolicyId())
                .discountFee(policy.getDiscountFee())
                .discountRate(policy.getDiscountRate())
                .minimumPrice(policy.getMinimumPrice())
                .maximumDiscountPrice(policy.getMaximumDiscountPrice())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<PolicyResponse>().data(response));
    }

    @PostMapping("/coupon/policy")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse<Void>> savePolicy(@RequestBody @Valid CouponPolicyRequest couponPolicyRequest){
        couponPolicyService.savePolicy(couponPolicyRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<Void>().message("Coupon has saved"));
    }

    @PutMapping("/coupon/policy/{policyId}")
    public ResponseEntity<BaseResponse<Void>> changeCouponPolicy(@PathVariable("policyId") int policyId,
                                                 @RequestBody @Valid CouponPolicyRequest couponPolicyRequest){
        couponPolicyService.updatePolicy(couponPolicyRequest, policyId);
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<Void>().message("쿠폰 정책이 수정되었습니다"));
    }
}