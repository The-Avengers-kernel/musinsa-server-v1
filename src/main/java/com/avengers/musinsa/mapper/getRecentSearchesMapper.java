package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.search.Response.RecentSearchesResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface getRecentSearchesMapper {

    List<RecentSearchesResponseDto> getRecentSearches(Long userId);

}
