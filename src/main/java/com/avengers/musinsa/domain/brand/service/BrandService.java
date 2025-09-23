package com.avengers.musinsa.domain.brand.service;

import com.avengers.musinsa.domain.brand.dto.BrandDto;
import com.avengers.musinsa.domain.brand.dto.response.BrandLikeResponse;
import com.avengers.musinsa.domain.brand.dto.response.BrandResponse;

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

    //브랜드 최초 좋아요 하기(레코드 추가)
    BrandLikeResponse addBrandLikedByUser(Long userId, Long brandId);

    List<BrandResponse> findByBrandName(String brandName);

    //이미 좋아요한 브랜드 좋아요 하기/취소하기(patch)
    BrandLikeResponse switchBrandLike(Long userId, Long brandId);
}