package com.avengers.musinsa.domain.brand.service;

import com.avengers.musinsa.domain.brand.dto.response.BrandLikeResponse;
import com.avengers.musinsa.domain.brand.dto.response.BrandResponse;
import com.avengers.musinsa.domain.brand.dto.BrandDto;
import com.avengers.musinsa.domain.brand.repository.BrandRepositoryImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepositoryImpl brandRepositoryImpl;

    //카테고리 - 브랜드 목록 전체 조회
    @Override
    public List<BrandResponse> getBrandList() {
        return brandRepositoryImpl.getBrandList();
    }

    //카테고리 - 카테고리 별로 브랜드 목록 조회
    @Override
    public List<BrandResponse> getBrandsByCategoryId(Long brandCategoryId) {
        return brandRepositoryImpl.getBrandsByCategoryId(brandCategoryId);
    }

    //최근 방문한 브랜드 조회
    @Override
    public List<BrandDto> getRecentVisitBrands(Long userId) {
        //null 검증
        if(userId == null) {
            throw new IllegalArgumentException("userId is null");
        }

        return brandRepositoryImpl.selectRecentVisitedBrands(userId);
    }

    //카테고리 - 초성(ㄱ, A)로 브랜드 조회
    @Override
    public List<BrandResponse> getCategoryBrandsByFirstLetter(char brandFirstLetter){
        //(A~Z): 영어 초성일 때
        if((brandFirstLetter >= 'A' && brandFirstLetter <= 'Z') || (brandFirstLetter >= 'a' && brandFirstLetter <= 'z')) {
            return brandRepositoryImpl.findBrandsByEnglishFirstLetter(brandFirstLetter);
        }
        //(ㄱ~ㅎ): 한글 초성일 때
        else{
            return brandRepositoryImpl.findBrandsByKoreanFirstLetter(brandFirstLetter);
        }
    }
    @Override
    public BrandLikeResponse addBrandLikedByUser(Long userId, Long brandId) {
        //user_brand_like 테이블에 레코드 추가
        brandRepositoryImpl.insertUserBrandLike(userId, brandId);
        brandRepositoryImpl.updateBrandLikeCnt(brandId);
        //레코드 추가 후 회원과 브랜드의 현재 좋아요 상태를 반환
        return brandRepositoryImpl.findIsLikedBrand(userId, brandId);
    }

    // 브랜드 이름 찾기
    // 한글이면 그대로 검색, 영어면 대문자로 변환해서 검색
    @Override
    public List<BrandResponse> findByBrandName(String brandName) {
        String searchKeyword = normalizeSearchKeyword(brandName);
        return brandRepositoryImpl.findByBrandName(searchKeyword);
    }
    private String normalizeSearchKeyword(String keyword) {
        return keyword.matches(".*[a-zA-Z].*") ? keyword.toUpperCase() : keyword;
    }


}
