package com.t3t.couponapi.coupon.adapter;

import com.t3t.couponapi.coupon.client.BookApiClient;
import com.t3t.couponapi.coupon.exception.BookApiClientException;
import com.t3t.couponapi.coupon.model.response.BaseResponse;
import com.t3t.couponapi.coupon.model.response.BookIdResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookAdapter {
    private final BookApiClient bookApiClient;

    public List<BookIdResponse> findBooksId(){
        try{
            return Optional.ofNullable(bookApiClient.getBooksId().getBody())
                    .map(BaseResponse::getData)
                    .orElseThrow(BookApiClientException::new);
        }catch(FeignException e){
            throw new BookApiClientException();
        }
    }

    public BookIdResponse getBook(Long id){
        try{
            return Optional.ofNullable(bookApiClient.getBookId(id).getBody())
                    .map(BaseResponse::getData)
                    .orElseThrow(BookApiClientException::new);
        }catch(FeignException e){
            throw new BookApiClientException();
        }
    }
}
