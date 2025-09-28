package com.avengers.musinsa.viewController;

import com.avengers.musinsa.domain.user.auth.oauth2.dto.CustomOAuth2User;
import com.avengers.musinsa.domain.user.dto.MyPageDto;
import com.avengers.musinsa.domain.user.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageViewController {

    private final MyPageService myPageService;

    @GetMapping
    public String myPage(Authentication authentication, Model model) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        Object principal = authentication.getPrincipal();
        if (!(principal instanceof CustomOAuth2User)) {
            return "redirect:/login";
        }

        CustomOAuth2User userDetails = (CustomOAuth2User) principal;
        MyPageDto profile = myPageService.findUserProfileByUserName(userDetails.getUsername());

        if (profile == null) {
            return "redirect:/login";
        }

        String displayName = profile.getUsername();
        if (profile.getName() != null && !profile.getName().isBlank()) {
            displayName = profile.getName();
        }

        Integer userMileage = profile.getUserMileage() != null ? profile.getUserMileage() : 0;

        model.addAttribute("profile", profile);
        model.addAttribute("displayName", displayName);
        model.addAttribute("userMileage", userMileage);

        return "mypage/mypage";
    }

}

