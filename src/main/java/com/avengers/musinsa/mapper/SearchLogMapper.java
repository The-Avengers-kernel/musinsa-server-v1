package com.avengers.musinsa.mapper;

import com.avengers.musinsa.domain.search.dto.SearchSaveDto;
import com.avengers.musinsa.domain.search.entity.SearchLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SearchLogMapper {

    //검색 로그 저장 - 자동생성된 ID를 엔티티에 설정
    void insertSearchLog(SearchLog searchLog);

    void insertSearchBrandLog(SearchSaveDto.searchBrandLogSaveDto searchBrandLogSaveDto);

    void insertSearchKeywordLog(SearchSaveDto.searchKeywordLogSaveDto keywordLogSaveDto);
}
