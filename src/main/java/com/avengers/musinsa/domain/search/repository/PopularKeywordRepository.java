package com.avengers.musinsa.domain.search.repository;

import com.avengers.musinsa.domain.search.dto.ResultDTO;
import com.avengers.musinsa.mapper.PopularKeywordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PopularKeywordRepository {
   //private final getRecentSearchesMapper getRecentSearchesMapper;
    private final PopularKeywordMapper popularKeywordMapper;

    public List<ResultDTO> findTrendingKeywords() {
        return popularKeywordMapper.selectTrendingKeywords();
    }

}

