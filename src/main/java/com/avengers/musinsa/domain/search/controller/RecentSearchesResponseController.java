package com.avengers.musinsa.domain.search.controller;

import com.avengers.musinsa.domain.search.Response.RecentSearchesResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/search")
public class RecentSearchesResponseController {
    @GetMapping("/recent")
    public RecentSearchesResponseDto getRecentSearchesResponseDto() {

    }

}
