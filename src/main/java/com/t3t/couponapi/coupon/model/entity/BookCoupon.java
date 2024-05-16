package com.t3t.couponapi.coupon.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@Entity@Table(name = "book_coupons")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class BookCoupon extends Coupon {
    @Column(name = "book_id")
    private long bookId;
    public BookCoupon(long bookId){
        this.bookId = bookId;
    }
}
