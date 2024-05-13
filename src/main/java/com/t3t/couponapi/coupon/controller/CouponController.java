package com.t3t.couponapi.coupon.controller;

import com.t3t.couponapi.coupon.model.response.BaseResponse;
import com.t3t.couponapi.coupon.model.response.BookCouponResponse;
import com.t3t.couponapi.coupon.model.response.BookIdResponse;
import com.t3t.couponapi.coupon.model.response.CategoryIdResponse;
import com.t3t.couponapi.coupon.service.BookCategoryCouponService;
import com.t3t.couponapi.coupon.service.BookCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class CouponController {
    private final BookCouponService bookCouponService;
    private final BookCategoryCouponService categoryCouponService;


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

    @GetMapping("/coupon/books")
    public ResponseEntity<BaseResponse<List<BookCouponResponse>>> getAllBookCoupons(){
//        List<BookCouponResponse> bookCouponList = bookCouponService.findAllBooks();
//        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<List<BookIdResponse>>().data(bookCouponList));
        return null;
    }

//    @GetMapping("/coupon/categoroies")

//    @GetMapping("/coupon/general")

}