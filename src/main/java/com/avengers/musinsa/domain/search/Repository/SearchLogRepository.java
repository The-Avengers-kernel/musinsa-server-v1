package com.avengers.musinsa.domain.search.Repository;

import com.avengers.musinsa.domain.search.Dto.SearchLogRequestDTO;
import com.avengers.musinsa.domain.search.Entity.SearchLog;
import com.avengers.musinsa.mapper.SearchLogMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class SearchLogRepository {

    //SearchLogMapper 주입
    private final SearchLogMapper searchLogMapper;

    // 검색 로그 저장 후 생성된 logId 반환
    public Long save(SearchLog searchLog) {
        searchLogMapper.insertSearchLog(searchLog); // 검색 로그 저장
        return searchLog.getSearchLogId(); // 엔티티의 logId 반환
    }


}
