package com.t3t.couponapi.coupon.controller;

import com.t3t.couponapi.coupon.model.response.BaseResponse;
import com.t3t.couponapi.coupon.model.response.BookIdResponse;
import com.t3t.couponapi.coupon.model.response.CategoryIdResponse;
import com.t3t.couponapi.coupon.model.response.CouponDetailResponse;
import com.t3t.couponapi.coupon.service.BookCouponService;
import com.t3t.couponapi.coupon.service.CategoryCouponService;
import com.t3t.couponapi.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class CouponController {
    private final BookCouponService bookCouponService;
    private final CategoryCouponService categoryCouponService;
    private final CouponService couponService;


    @GetMapping("/coupon/books")
    public ResponseEntity<List<BookIdResponse>> getAllBooks(){
        List<BookIdResponse> booksID = bookCouponService.findAllBookId();
        return ResponseEntity.ok().body(booksID);
    }

    @GetMapping("/coupon/categories")
    public ResponseEntity<List<CategoryIdResponse>> getAllCategories(){
        List<CategoryIdResponse> categoriesId = categoryCouponService.findAllCategoryId();
        return ResponseEntity.ok().body(categoriesId);
    }

    @GetMapping("/details/{couponId}")
    public ResponseEntity<BaseResponse<CouponDetailResponse>> getCouponDetails(@PathVariable("couponId") String id){
        return ResponseEntity.ok().body(new BaseResponse<CouponDetailResponse>().data(couponService.findCouponDetails(id)));
    }


}