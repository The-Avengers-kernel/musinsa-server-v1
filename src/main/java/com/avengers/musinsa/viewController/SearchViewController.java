package com.avengers.musinsa.viewController;

import com.avengers.musinsa.domain.search.service.RecentSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchViewController {

    private final RecentSearchService recentSearchService;

    @GetMapping("/recent/view")
    public String recentSearchPage(){
        return "seachr/recentSearches";
    }
}
