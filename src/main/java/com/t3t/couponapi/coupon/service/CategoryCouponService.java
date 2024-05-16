package com.t3t.couponapi.coupon.service;

import com.t3t.couponapi.coupon.adapter.CategoryAdapter;
import com.t3t.couponapi.coupon.exception.CouponNotExistExceptions;
import com.t3t.couponapi.coupon.exception.CouponNotSavedExceptions;
import com.t3t.couponapi.coupon.exception.CouponPolicyNotExistException;
import com.t3t.couponapi.coupon.model.entity.CategoryCoupon;
import com.t3t.couponapi.coupon.model.entity.CouponPolicy;
import com.t3t.couponapi.coupon.model.request.CouponIdRequest;
import com.t3t.couponapi.coupon.model.request.CouponRequest;
import com.t3t.couponapi.coupon.model.response.CategoryIdResponse;
import com.t3t.couponapi.coupon.model.response.CouponResponse;
import com.t3t.couponapi.coupon.repository.CategoryCouponRepository;
import com.t3t.couponapi.coupon.repository.CouponPolicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryCouponService {
    private final CategoryAdapter categoryAdapter;
    private final CouponPolicyRepository couponPolicyRepository;
    private final CategoryCouponRepository categoryCouponRepository;

    public List<CategoryIdResponse> findAllCategoryId(){
        return categoryAdapter.findCategoriesId();
    }

    public CategoryIdResponse findCategoryId(Integer id){
        return categoryAdapter.getCategory(id);
    }

    public String saveCategoryCoupon(CouponRequest request, Integer id){
        CategoryIdResponse categoryId = findCategoryId(id);
        CouponPolicy couponPolicy = couponPolicyRepository.findById(request.getCouponPolicyId()).orElseThrow(CouponPolicyNotExistException::new);
        CategoryCoupon categoryCoupon = CategoryCoupon.builder()
                .couponId(UUID.randomUUID().toString().replace("-",""))
                .policies(couponPolicy)
                .couponType(request.getCouponType())
                .couponExpireDate(request.getCouponExpireDate())
                .isUsed(false)
                .categoryId(categoryId.getCategoryId())
                .build();

        CategoryCoupon newCategoryCoupon = categoryCouponRepository.save(categoryCoupon);
        if(!categoryCouponRepository.existsById(newCategoryCoupon.getCouponId())){
            throw new CouponNotSavedExceptions("Category Coupon Not saved");
        }
        return "CategoryCouponSaved";
    }

    public String deleteCategoryCouponByAdmin(CouponIdRequest request){
        CategoryCoupon categoryCoupon = categoryCouponRepository.findById(request.getCouponId()).orElseThrow(() -> new CouponNotExistExceptions("CategoryCoupon Not Exists"));
        categoryCoupon.deleteCoupon(true);
        return "Category Coupon Deleted";
    }

    public CouponResponse getCategoryCoupon(){
        CategoryCoupon categoryCoupon = categoryCouponRepository.getCategoryCoupon().orElseThrow(()-> new CouponNotExistExceptions("CategoryCoupon Not Exists"));
        categoryCoupon.deleteCoupon(true);
        return CouponResponse.builder().couponId(categoryCoupon.getCouponId()).build();
    }
}
