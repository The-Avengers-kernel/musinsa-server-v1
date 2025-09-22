package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.brand.dto.BrandDto;
import com.avengers.musinsa.domain.brand.dto.response.BrandResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandMapper {
    List<BrandDto> selectRecentVisitedBrands(Long userId);

    List<BrandResponse> getBrandList();

    List<BrandResponse> findBrandsByEnglishFirstLetter(char brandFirstLetter);
    List<BrandResponse> findBrandsByKoreanFirstLetter(char brandFirstLetter);

    List<BrandResponse> getBrandsByCategoryId(Long brandCategoryId);
}
