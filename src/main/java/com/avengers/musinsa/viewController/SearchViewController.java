package com.avengers.musinsa.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/search", "/main/search"})
public class SearchViewController {

    @GetMapping({"", "/"})
    public String searchEntry(@RequestParam(value = "fragment", required = false) Boolean fragment,
                              Model model) {
        if (Boolean.TRUE.equals(fragment)) {
            model.addAttribute("forceFragment", true);
            return "search/recentSearches";
        }
        return "redirect:/?openSearchOverlay=true";
    }

    @GetMapping({"/overlay", "/recent/view"})
    public String searchOverlay(Model model) {
        model.addAttribute("forceFragment", true);
        return "search/recentSearches";
    }
}
