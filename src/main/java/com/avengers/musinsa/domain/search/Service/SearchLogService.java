package com.avengers.musinsa.domain.search.Service;

import com.avengers.musinsa.domain.brand.dto.response.BrandResponse;
import com.avengers.musinsa.domain.search.Dto.SearchLogRequestDTO;
import com.avengers.musinsa.domain.search.Dto.SearchLogResponseDTO;

public interface SearchLogService {


    // 검색 로그 저장
    SearchLogResponseDTO saveSearchLog(SearchLogRequestDTO requestDTO);


    // 검색 로그 저장
    void saveSearchKeywordLog(String keyword,Long userId);

    void saveSearchBrandLog(BrandResponse brandResponse, Long userId);
}
