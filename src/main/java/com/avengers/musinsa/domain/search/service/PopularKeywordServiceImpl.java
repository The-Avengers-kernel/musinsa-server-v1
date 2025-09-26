package com.avengers.musinsa.domain.search.service;

import com.avengers.musinsa.domain.search.dto.PopularKeywordResponseDTO;
import com.avengers.musinsa.domain.search.dto.ResultDTO;
import com.avengers.musinsa.domain.search.repository.PopularKeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PopularKeywordServiceImpl implements PopularKeywordService {
    private final PopularKeywordRepository popularKeywordRepository;

    @Override
    public PopularKeywordResponseDTO getTrendingKeywords(){
        List<ResultDTO> trendingKeywords = popularKeywordRepository.findTrendingKeywords();

        return PopularKeywordResponseDTO.builder()
                .basedOnTime(LocalDateTime.now().toString())
                .message("인기 검색어 조회 성공")
                .success(true)
                .results(trendingKeywords)
                .build();
    }
}

