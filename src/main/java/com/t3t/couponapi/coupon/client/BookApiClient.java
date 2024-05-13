package com.t3t.couponapi.coupon.client;


import com.t3t.couponapi.coupon.model.response.BaseResponse;
import com.t3t.couponapi.coupon.model.response.BookIdResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "bookApiClient", url = "${t3t.feignClient.url}")
public interface BookApiClient {
    @GetMapping(value = "/t3t/bookstore/book/coupons")
    ResponseEntity<BaseResponse<List<BookIdResponse>>> getBooksId();
}