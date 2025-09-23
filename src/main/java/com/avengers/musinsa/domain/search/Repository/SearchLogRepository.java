package com.avengers.musinsa.domain.search.Repository;

import com.avengers.musinsa.domain.search.Dto.SearchSaveDto;
import com.avengers.musinsa.domain.search.Entity.SearchLog;

public interface SearchLogRepository {
    Long save(SearchLog searchLog);

    Long saveSearchBrandLog(SearchSaveDto.searchBrandLogSaveDto brandLogSaveDto);

    Long saveSearchKeywordLog(SearchSaveDto.searchKeywordLogSaveDto brandLogSaveDto);
}
