package com.t3t.couponapi.coupon.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BookCouponResponse {
    @NotBlank
    private String couponId;
    @NotNull
    private Integer couponPolicyId;
    @NotBlank
    private String couponType;
    @NotNull
    private LocalDate couponExpireDate;
    @NotNull
    private Boolean couponUsed;
    @NotNull
    private Long bookId;
}
