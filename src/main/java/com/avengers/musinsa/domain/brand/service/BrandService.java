package com.avengers.musinsa.domain.brand.service;

import com.avengers.musinsa.domain.brand.dto.response.BrandLikeResponse;
import com.avengers.musinsa.domain.brand.dto.response.BrandResponse;
import com.avengers.musinsa.domain.brand.dto.BrandDto;
import com.avengers.musinsa.domain.brand.repository.BrandRepository;
import jakarta.transaction.Transactional;
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

    //카테고리 - 초성(ㄱ, A)로 브랜드 조회
    public List<BrandResponse> getCategoryBrandsByFirstLetter(char brandFirstLetter){
        //(A~Z): 영어 초성일 때
        if((brandFirstLetter >= 'A' && brandFirstLetter <= 'Z') || (brandFirstLetter >= 'a' && brandFirstLetter <= 'z')) {
            return brandRepository.findBrandsByEnglishFirstLetter(brandFirstLetter);
        }
        //(ㄱ~ㅎ): 한글 초성일 때
        else{
            return brandRepository.findBrandsByKoreanFirstLetter(brandFirstLetter);
        }
    }
    //최초로 브랜드 좋아요 하기
    public BrandLikeResponse addBrandLikedByUser(Long userId, Long brandId) {
        //user_brand_like 테이블에 레코드 추가
        brandRepository.insertUserBrandLike(userId, brandId);
        //브랜드 테이블의 좋아요 수 +1
        brandRepository.plusBrandLikeCnt(brandId);
        //레코드 추가 후 현재 좋아요 상태를 반환
        return brandRepository.getIsLikedBrand(userId, brandId);
    }

    //이미 좋아요 한 브랜드 좋아요 상태 바꾸기
    @Transactional
    // → 두 작업을 하나의 트랜잭션으로 묶어 데이터 정합성을 보장
    public BrandLikeResponse switchBrandLike(Long userId, Long brandId) {
        //liked 컬럼을 0 ↔ 1
        brandRepository.switchBrandLike(userId,brandId);
        //브랜드 테이블의 좋아요 수를 동기화
        brandRepository.updateBrandLikeCnt(brandId);
        //좋아요상태 변경 후 현재 좋아요 상태를 반환
        return brandRepository.getIsLikedBrand(userId, brandId);
    }
}
