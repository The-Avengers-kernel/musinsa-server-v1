package com.avengers.musinsa.domain.brand.repository;

import com.avengers.musinsa.domain.brand.dto.response.BrandLikeResponse;
import com.avengers.musinsa.domain.brand.dto.response.BrandResponse;
import com.avengers.musinsa.domain.brand.dto.BrandDto;
import com.avengers.musinsa.mapper.BrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BrandRepository {
    private final BrandMapper brandMapper;

    public List<BrandResponse> getBrandList() {
        return brandMapper.getBrandList();
    }

    public List<BrandDto> selectRecentVisitedBrands(Long userId){
        return this.brandMapper.selectRecentVisitedBrands(userId);
    }

    public void insertUserBrandLike(Long userId, Long brandId) {
        brandMapper.insertUserBrandLike(userId,brandId);
    }

    public BrandLikeResponse findIsLikedBrand(Long userId, Long brandId) {
        return brandMapper.findIsLikeBrand(userId, brandId);
    }
  
    public List<BrandResponse> getBrandsByCategoryId(Long brandCategoryId) {
        return this.brandMapper.getBrandsByCategoryId(brandCategoryId);
    }
}
