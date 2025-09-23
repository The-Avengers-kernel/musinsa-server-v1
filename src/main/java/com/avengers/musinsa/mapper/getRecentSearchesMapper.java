package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.search.response.SearchKeywordResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface getRecentSearchesMapper {

    List<SearchKeywordResponseDTO> getRecentSearches(@Param("user_id") Long userId);


}
