package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.brand.dto.BrandDto;
import com.avengers.musinsa.domain.brand.dto.response.BrandLikeResponse;
import com.avengers.musinsa.domain.brand.dto.response.BrandResponse;
import com.avengers.musinsa.domain.brand.entity.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrandMapper {
    List<BrandDto> selectRecentVisitedBrands(Long userId);

    List<BrandResponse> getBrandList();

    List<BrandResponse> findBrandsByEnglishFirstLetter(char brandFirstLetter);
  
    List<BrandResponse> findBrandsByKoreanFirstLetter(char brandFirstLetter);

    void insertUserBrandLike(@Param("userId") Long userId, @Param("brandId") Long brandId);

    BrandLikeResponse getIsLikeBrand(Long userId, Long brandId);
  
    List<BrandResponse> getBrandsByCategoryId(Long brandCategoryId);

    void plusBrandLikeCnt(Long brandId);

    void updateBrandLikeCnt(Long brandId);

    List<BrandResponse> findByBrandName(@Param("brandName")String brandName);

    BrandLikeResponse findIsLikeBrand(Long userId, Long brandId);
}
