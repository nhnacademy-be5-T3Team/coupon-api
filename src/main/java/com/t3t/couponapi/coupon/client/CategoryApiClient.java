package com.t3t.couponapi.coupon.client;

import com.t3t.couponapi.coupon.model.response.BaseResponse;
import com.t3t.couponapi.coupon.model.response.CategoryIdResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "bookCategoryApiClient", url = "${t3t.feignClient.url}")
public interface CategoryApiClient {
    @GetMapping(value = "/t3t/bookstore/category/coupons")
    ResponseEntity<BaseResponse<List<CategoryIdResponse>>> getCategoriesId();
}
