package com.avengers.musinsa.domain.brand.repository;

import com.avengers.musinsa.domain.brand.dto.response.BrandLikeResponse;
import com.avengers.musinsa.domain.brand.dto.response.BrandResponse;
import com.avengers.musinsa.domain.brand.dto.BrandDto;
import com.avengers.musinsa.domain.brand.entity.Brand;
import com.avengers.musinsa.mapper.BrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BrandRepositoryImpl implements BrandRepository {
    private final BrandMapper brandMapper;

    @Override
    public List<BrandResponse> getBrandList() {
        return brandMapper.getBrandList();
    }

    @Override
    public List<BrandDto> selectRecentVisitedBrands(Long userId){
        return this.brandMapper.selectRecentVisitedBrands(userId);
    }

    @Override
    public List<BrandResponse> findBrandsByEnglishFirstLetter(char brandFirstLetter) {
        return this.brandMapper.findBrandsByEnglishFirstLetter(brandFirstLetter);
    }

    @Override
    public List<BrandResponse> findBrandsByKoreanFirstLetter(char brandFirstLetter) {
        return this.brandMapper.findBrandsByKoreanFirstLetter(brandFirstLetter);
    }

    @Override
    public void insertUserBrandLike(Long userId, Long brandId) {
        brandMapper.insertUserBrandLike(userId,brandId);
    }

    @Override
    public BrandLikeResponse findIsLikedBrand(Long userId, Long brandId) {
        return brandMapper.findIsLikeBrand(userId, brandId);
    }

    public void updateBrandLikeCnt(Long brandId) {
        brandMapper.updateBrandLikeCnt(brandId);
    }

    @Override
    public List<BrandResponse> findByBrandName(String brandName) {
        return this.brandMapper.findByBrandName(brandName);
    }

    @Override
    public BrandLikeResponse getIsLikedBrand(Long userId, Long brandId) {
        return brandMapper.getIsLikeBrand(userId, brandId);
    }

    @Override
    public List<BrandResponse> getBrandsByCategoryId(Long brandCategoryId) {
        return this.brandMapper.getBrandsByCategoryId(brandCategoryId);
    }
    @Override
    public void plusBrandLikeCnt(Long brandId) {
        brandMapper.plusBrandLikeCnt(brandId);
    }

}
