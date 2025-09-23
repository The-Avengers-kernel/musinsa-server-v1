package com.avengers.musinsa.domain.product.dto.response;

import com.avengers.musinsa.domain.product.entity.ProductImage;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ProductDetailResponse {
    private Long productId;
    private String productName;
    private int productLikeCnt;
    private int price;
    private int brandDiscount;
    private int finalprice;

    private Long brandId;
    private String brandName;
    private int brandLikeCnt;

    private List<ProductImage> productImageList = new ArrayList<>();

    private Long sizeDetailImageId;
    private String productSizeDetailImageURL;

    //레코드가 없을 때 NULL 확인을 위해 Integer로 선언
    private Integer userProductLike;
    private Integer userBrandLike;

}
