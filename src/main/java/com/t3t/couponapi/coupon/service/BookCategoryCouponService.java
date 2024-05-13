package com.t3t.couponapi.coupon.service;

import com.t3t.couponapi.coupon.adapter.CategoryAdapter;
import com.t3t.couponapi.coupon.model.response.CategoryIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookCategoryCouponService {
    private final CategoryAdapter categoryAdapter;

    public List<CategoryIdResponse> findAllCategoryId(){
        return categoryAdapter.findCategoriesId();
    }
}
