package com.t3t.couponapi.coupon.service;

import com.t3t.couponapi.coupon.adapter.BookAdapter;
import com.t3t.couponapi.coupon.exception.CouponNotExistExceptions;
import com.t3t.couponapi.coupon.exception.CouponNotSavedExceptions;
import com.t3t.couponapi.coupon.exception.CouponPolicyNotExistException;
import com.t3t.couponapi.coupon.model.entity.BookCoupon;
import com.t3t.couponapi.coupon.model.entity.CouponPolicy;
import com.t3t.couponapi.coupon.model.request.BookCouponRequest;
import com.t3t.couponapi.coupon.model.request.CouponRequest;
import com.t3t.couponapi.coupon.model.response.BookIdResponse;
import com.t3t.couponapi.coupon.model.response.CouponResponse;
import com.t3t.couponapi.coupon.repository.BookCouponRepository;
import com.t3t.couponapi.coupon.repository.CouponPolicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class BookCouponService {
    private final BookAdapter bookAdapter;
    private final BookCouponRepository bookCouponRepository;
    private final CouponPolicyRepository couponPolicyRepository;

    public List<BookIdResponse> findAllBookId(){
        return bookAdapter.findBooksId();
    }

    public BookIdResponse getBookId(Long id){
        return bookAdapter.getBookId(id);
    }

    public String createBookCoupon(CouponRequest request, Long id){
        CouponPolicy couponPolicy = couponPolicyRepository.findById(request.getCouponPolicyId()).orElseThrow(() -> new CouponPolicyNotExistException("Coupon Policy Not Exist"));

        BookCoupon bookCoupon = BookCoupon.builder()
                .couponId(UUID.randomUUID().toString())
                .couponType(request.getCouponType())
                .couponExpireDate(request.getCouponExpireDate())
                .isUsed(false)
                .policies(couponPolicy)
                .bookId(getBookId(id).getBookId())
                .build();

        BookCoupon newBookCoupon = bookCouponRepository.save(bookCoupon);
        if(!bookCouponRepository.existsById(newBookCoupon.getCouponId())){
            throw new CouponNotSavedExceptions("Book Coupon Not Saved");
        }
        return "BookCoupon Created";
    }

    public String deleteBookCoupon(BookCouponRequest request){
        BookCoupon bookCoupon = bookCouponRepository.findById(request.getCouponId()).orElseThrow(() -> new CouponNotExistExceptions("Book Coupon Not Exists"));
        bookCoupon.deleteCoupon(true);
        return "Book Coupon deleted";
    }

    public CouponResponse getBookCoupon(){
        BookCoupon bookCoupon = bookCouponRepository.getBookCoupon().orElseThrow(() -> new CouponNotExistExceptions("Book Coupon not Exists"));
        bookCoupon.deleteCoupon(true);
        return CouponResponse.builder().couponId(bookCoupon.getCouponId()).build();
    }
}
