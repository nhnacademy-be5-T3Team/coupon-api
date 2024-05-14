package com.t3t.couponapi.coupon.repository.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.t3t.couponapi.coupon.model.entity.BookCoupon;
import com.t3t.couponapi.coupon.model.response.BookCouponResponse;
import com.t3t.couponapi.coupon.repository.BookCouponRepositoryCustom;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.t3t.couponapi.coupon.model.entity.QBookCoupon.bookCoupon;

@RequiredArgsConstructor
public class BookCouponRepositoryImpl implements BookCouponRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public List<BookCouponResponse> getAllBookCoupons() {
        return null;
    }

    @Override
    public Optional<BookCoupon> getBookCoupon() {
        return Optional.ofNullable(jpaQueryFactory.select(Projections.fields(BookCoupon.class,
                bookCoupon.couponId,
                bookCoupon.couponType,
                bookCoupon.couponExpireDate,
                bookCoupon.isUsed,
                bookCoupon.bookId,
                bookCoupon.policies))
                .from(bookCoupon)
                .where(bookCoupon.isUsed.eq(false))
                .fetchFirst());
    }
}
