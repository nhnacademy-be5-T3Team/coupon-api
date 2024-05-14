package com.t3t.couponapi.coupon.controller;

import com.t3t.couponapi.coupon.model.request.CouponIdRequest;
import com.t3t.couponapi.coupon.model.request.CouponRequest;
import com.t3t.couponapi.coupon.model.response.BaseResponse;
import com.t3t.couponapi.coupon.model.response.CouponResponse;
import com.t3t.couponapi.coupon.service.GeneralCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class GeneralCouponController {
    private final GeneralCouponService generalCouponService;

    @PostMapping("/coupons/general")
    public ResponseEntity<BaseResponse<Void>> createGeneralCoupon(@RequestBody CouponRequest request){
        generalCouponService.createGeneralCoupon(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResponse<Void>().message("General Coupon Created"));
    }

    @PutMapping("/coupons/general")
    public ResponseEntity<BaseResponse<Void>> deleteGeneralCoupon(@RequestBody CouponIdRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<Void>().message(generalCouponService.deleteGeneralCouponByAdmin(request)));
    }

    @GetMapping("/coupons/general")
    public ResponseEntity<BaseResponse<CouponResponse>> getCoupon(){
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<CouponResponse>().data(generalCouponService.getGeneralCoupon()));
    }
}
