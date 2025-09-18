package com.avengers.musinsa.domain.product.dto;

import com.avengers.musinsa.domain.product.entity.ProductImage;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ProductResponseDto {
    private  Long productId;
    private  String productName;
    private  int productLikeCnt;
    private  int price;
    private int brandDiscount;
    private int finalprice;

    private  Long brandId;
    private  String brandName;
    private  int brandLikeCnt;

    private List<ProductImage> productImageList = new ArrayList<>();

}
