package com.avengers.musinsa.domain.brand.service;

import com.avengers.musinsa.domain.brand.dto.response.BrandLikeResponse;
import com.avengers.musinsa.domain.brand.dto.response.BrandResponse;
import com.avengers.musinsa.domain.brand.dto.BrandDto;
import com.avengers.musinsa.domain.brand.repository.BrandRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;

    //카테고리 - 브랜드 목록 전체 조회
    public List<BrandResponse> getBrandList() {
        return brandRepository.getBrandList();
    }

    //카테고리 - 카테고리 별로 브랜드 목록 조회
    public List<BrandResponse> getBrandsByCategoryId(Long brandCategoryId) {
        return brandRepository.getBrandsByCategoryId(brandCategoryId);
    }

    //최근 방문한 브랜드 조회
    public List<BrandDto> getRecentVisitBrands(Long userId) {
        //null 검증
        if(userId == null) {
            throw new IllegalArgumentException("userId is null");
        }

        return brandRepository.selectRecentVisitedBrands(userId);
    }

    public BrandLikeResponse addBrandLikedByUser(Long userId, Long brandId) {
        //user_brand_like 테이블에 레코드 추가
        brandRepository.insertUserBrandLike(userId, brandId);
        brandRepository.updateBrandLikeCnt(brandId);
        //레코드 추가 후 회원과 브랜드의 현재 좋아요 상태를 반환
        return brandRepository.findIsLikedBrand(userId, brandId);
    }

}
