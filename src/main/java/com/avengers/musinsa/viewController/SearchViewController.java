package com.avengers.musinsa.viewController;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/search", "/main/search"}) // 두 개의 엔트리 경로를 동일한 핸들러에 매핑
public class SearchViewController {


    @GetMapping(value = {"", "/"}, params = "!keyword")
    public String searchEntry(Model model) {
        model.addAttribute("forceFragment", true);
        return "search/recentSearches";
    }


    //검색창 팝업 띄우는 뷰 컨트롤러
    @GetMapping({"/overlay", "/recent/view"})
    public String searchOverlay(Model model) {
        model.addAttribute("forceFragment", true);
        return "search/recentSearches";
    }
}
