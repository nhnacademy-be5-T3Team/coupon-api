package com.t3t.couponapi.coupon.client;

import com.t3t.couponapi.coupon.model.response.BaseResponse;
import com.t3t.couponapi.coupon.model.response.CategoryIdResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "bookCategoryApiClient", url = "${t3t.feignClient.url}")
public interface CategoryApiClient {
    @GetMapping(value = "/t3t/bookstore/categories/coupon")
    ResponseEntity<BaseResponse<List<CategoryIdResponse>>> getCategoriesId();

    @GetMapping(value = "/t3t/bookstore/categories/{categoryId}/coupon/")
    ResponseEntity<BaseResponse<CategoryIdResponse>> getCategoryId(@PathVariable("categoryId") Integer categoryId);
}
