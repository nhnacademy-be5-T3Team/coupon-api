package com.t3t.couponapi.coupon.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.JOINED)
@Entity@Table(name = "book_category_coupons")
public class BookCategoryCoupon extends Coupon{
    @Column(name = "category_id")
    private int categoryId;

    public BookCategoryCoupon(int categoryId){
        this.categoryId = categoryId;
    }
}
