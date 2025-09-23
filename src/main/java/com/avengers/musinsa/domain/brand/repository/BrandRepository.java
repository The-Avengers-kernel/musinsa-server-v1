package com.avengers.musinsa.domain.brand.repository;

import com.avengers.musinsa.domain.brand.dto.BrandDto;
import com.avengers.musinsa.domain.brand.dto.response.BrandLikeResponse;
import com.avengers.musinsa.domain.brand.dto.response.BrandResponse;
import com.avengers.musinsa.domain.brand.entity.Brand;

import java.util.List;

public interface BrandRepository {
    List<BrandResponse> getBrandList();

    List<BrandDto> selectRecentVisitedBrands(Long userId);

    List<BrandResponse> findBrandsByEnglishFirstLetter(char brandFirstLetter);

    List<BrandResponse> findBrandsByKoreanFirstLetter(char brandFirstLetter);

    void insertUserBrandLike(Long userId, Long brandId);

    BrandLikeResponse findIsLikedBrand(Long userId, Long brandId);

    List<BrandResponse> getBrandsByCategoryId(Long brandCategoryId);

    void updateBrandLikeCnt(Long brandId);

    List<BrandResponse> findByBrandName(String brandName);

}
