package com.t3t.couponapi.coupon.controller;

import com.t3t.couponapi.coupon.model.request.CouponIdRequest;
import com.t3t.couponapi.coupon.model.request.CouponRequest;
import com.t3t.couponapi.coupon.model.response.BaseResponse;
import com.t3t.couponapi.coupon.model.response.CouponResponse;
import com.t3t.couponapi.coupon.service.BookCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookCouponController {
    private final BookCouponService bookCouponService;

    @PostMapping("/coupon/book/{bookId}")
    public ResponseEntity<BaseResponse<Void>> createBookCoupon(@PathVariable("bookId") Long bookId,
                                                               @RequestBody CouponRequest couponRequest){

        return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResponse<Void>().message(bookCouponService.createBookCoupon(couponRequest, bookId)));
    }

    @PutMapping("/coupon/book")
    public ResponseEntity<BaseResponse<Void>> deleteBookCoupon(@RequestBody CouponIdRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResponse<Void>().message(bookCouponService.deleteBookCoupon(request)));
    }

    @GetMapping("/coupon/book")
    public ResponseEntity<BaseResponse<CouponResponse>> getBookCoupon(){
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<CouponResponse>().data(bookCouponService.getBookCoupon()));
    }
}