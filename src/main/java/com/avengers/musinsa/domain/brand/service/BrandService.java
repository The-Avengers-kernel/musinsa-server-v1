package com.avengers.musinsa.domain.brand.service;

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

    public List<BrandResponse> getBrandList() {
        return brandRepository.getBrandList();
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
}
