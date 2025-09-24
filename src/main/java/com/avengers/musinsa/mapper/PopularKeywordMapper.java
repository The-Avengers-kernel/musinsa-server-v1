package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.search.dto.ResultDTO;

import java.util.List;

public interface PopularKeywordMapper {
    List<ResultDTO> selectTrendingKeywords();
}
