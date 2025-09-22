package com.avengers.musinsa.domain.search.Service;

import com.avengers.musinsa.domain.search.Dto.SearchLogResponseDTO;
import com.avengers.musinsa.domain.search.Dto.SearchLogRequestDTO;
import com.avengers.musinsa.domain.search.Entity.SearchLog;
import com.avengers.musinsa.domain.search.Repository.SearchLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchLogService {
    private final SearchLogRepository searchLogRepository; // 검색 로그 저장소 주입

    // 검색 로그 저장
    public SearchLogResponseDTO saveSearchLogs(SearchLogRequestDTO requestDTO) {
        try {
            // DTO를 엔티티로 변환
            SearchLog searchLog = SearchLog.builder()
                    .searchText(requestDTO.getSearchText())    // 검색어 설정
                    .userId(requestDTO.getUserId())            // 사용자 ID 설정
                    .searchCount(requestDTO.getSearchCount())
                    .build();

            // 저장소를 통해 저장하고 생성된 ID 반환
            Long logId = searchLogRepository.save(searchLog);

            // 성공 응답 반환 - JSON -> success : success
            return SearchLogResponseDTO.builder()
                    .logId(logId)
                    .success(true)
                    .build();

        } catch (Exception e) {
            // 에러 발생 시 실패 응답 반환 - JSON -> success : fail
            return SearchLogResponseDTO.builder()
                    .logId(null)
                    .success(false)
                    .build();
        }
    }
}
