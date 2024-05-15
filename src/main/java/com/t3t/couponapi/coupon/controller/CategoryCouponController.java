package com.t3t.couponapi.coupon.controller;

import com.t3t.couponapi.coupon.model.request.CouponIdRequest;
import com.t3t.couponapi.coupon.model.request.CouponRequest;
import com.t3t.couponapi.coupon.model.response.BaseResponse;
import com.t3t.couponapi.coupon.model.response.CouponResponse;
import com.t3t.couponapi.coupon.service.CategoryCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CategoryCouponController {
    private final CategoryCouponService categoryCouponService;

    @PostMapping("/coupons/category/{categoryId}")
    public ResponseEntity<BaseResponse<String>> createCategoryCoupon(@RequestBody CouponRequest request,
                                                                     @PathVariable("categoryId") Integer categoryId){
        return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResponse<String>().data(categoryCouponService.saveCategoryCoupon(request, categoryId)));

    }

    @PutMapping("/coupons/category")
    public ResponseEntity<BaseResponse<Void>> deleteCategoryCoupon(@RequestBody CouponIdRequest request){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new BaseResponse<Void>().message(categoryCouponService.deleteCategoryCouponByAdmin(request)));
    }

    @GetMapping("/coupons/category")
    public ResponseEntity<BaseResponse<CouponResponse>> getCategoryCoupon(){
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<CouponResponse>().data(categoryCouponService.getCategoryCoupon()));
    }
}
