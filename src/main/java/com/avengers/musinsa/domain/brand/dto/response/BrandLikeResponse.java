package com.avengers.musinsa.domain.brand.dto.response;

import com.avengers.musinsa.domain.brand.service.BrandService;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BrandLikeResponse {
    private Long brandId;
    private Long userId;
    private boolean liked;

}
