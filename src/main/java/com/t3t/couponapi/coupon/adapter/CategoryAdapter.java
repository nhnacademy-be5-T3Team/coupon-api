package com.t3t.couponapi.coupon.adapter;

import com.t3t.couponapi.coupon.client.CategoryApiClient;
import com.t3t.couponapi.coupon.exception.BookCategoryApiClientException;
import com.t3t.couponapi.coupon.model.response.BaseResponse;
import com.t3t.couponapi.coupon.model.response.CategoryIdResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoryAdapter {
    private final CategoryApiClient categoryApiClient;

    public List<CategoryIdResponse> findCategoriesId(){
        try{
            return Optional.ofNullable(categoryApiClient.getCategoriesId().getBody())
                    .map(BaseResponse::getData)
                    .orElseThrow(BookCategoryApiClientException::new);
        }catch(FeignException e){
            throw new BookCategoryApiClientException();
        }
    }

    public CategoryIdResponse getCategory(Integer id){
        try{
            return Optional.ofNullable(categoryApiClient.getCategoryId(id).getBody())
                    .map(BaseResponse::getData)
                    .orElseThrow(BookCategoryApiClientException::new);
        }catch (FeignException e){
            throw new BookCategoryApiClientException();
        }
    }
}
