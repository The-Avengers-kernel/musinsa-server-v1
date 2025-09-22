package com.avengers.musinsa.domain.brand.service;

import com.avengers.musinsa.domain.brand.dto.BrandDto;
import com.avengers.musinsa.domain.brand.dto.response.BrandLikeResponse;
import com.avengers.musinsa.domain.brand.dto.response.BrandResponse;
import com.avengers.musinsa.domain.brand.entity.Brand;

import java.util.List;

public interface BrandService {

    //카테고리 - 브랜드 목록 전체 조회
    List<BrandResponse> getBrandList();
    //카테고리 - 카테고리 별로 브랜드 목록 조회
    List<BrandResponse> getBrandsByCategoryId(Long brandCategoryId);

    //최근 방문한 브랜드 조회
    List<BrandDto> getRecentVisitBrands(Long userId);

    //카테고리 - 초성(ㄱ, A)로 브랜드 조회
    List<BrandResponse> getCategoryBrandsByFirstLetter(char brandFirstLetter);
    BrandLikeResponse addBrandLikedByUser(Long userId, Long brandId);


    // 이름으로 브랜드 찾기
    BrandResponse findByBrandName(String brandName);
}
