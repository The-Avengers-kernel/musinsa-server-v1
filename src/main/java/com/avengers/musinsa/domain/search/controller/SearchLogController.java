package com.avengers.musinsa.domain.search.controller;

import com.avengers.musinsa.domain.search.Dto.SearchLogResponseDTO;
import com.avengers.musinsa.domain.search.Dto.SearchLogRequestDTO;
import com.avengers.musinsa.domain.search.Service.SearchLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/search")
public class SearchLogController {

    //서비스 계층에 일을 시킨다, 주입
    private final SearchLogService searchLogService;

    // /api/v1/logs/search-keyword url 요청을 받아서,
    //logid로 응답을 넘겨준다
    @PostMapping("/search-logs")
    public SearchLogResponseDTO saveSearchLog(@RequestBody SearchLogRequestDTO request){

        //Service에 저장 요청하고 바로 return
        return searchLogService.saveSearchLogs(request);
    }






}
