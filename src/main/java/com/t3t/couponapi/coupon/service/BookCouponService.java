package com.t3t.couponapi.coupon.service;

import com.t3t.couponapi.coupon.adapter.BookAdapter;
import com.t3t.couponapi.coupon.model.response.BookCouponResponse;
import com.t3t.couponapi.coupon.model.response.BookIdResponse;
import com.t3t.couponapi.coupon.repository.BookCouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookCouponService {
    private final BookAdapter bookAdapter;
    private final BookCouponRepository bookCouponRepository;

    public List<BookIdResponse> findAllBookId(){
        return bookAdapter.findBooksId();
    }

    public List<BookCouponResponse> findAllBookCoupons(){
//        List<BookCouponResponse> bookCouponResponseList = bookCouponRepository.getAllBookCoupons();
        return null;
    }
}
