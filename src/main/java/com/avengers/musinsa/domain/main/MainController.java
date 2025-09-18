package com.avengers.musinsa.domain.main;

import com.avengers.musinsa.domain.user.auth.jwt.TokenProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final TokenProviderService tokenProviderService;
    @GetMapping("/")
    public String getMainHompage(@CookieValue(value = "Authorization", required = false) String authorizationHeader) {

        if (authorizationHeader != null && !authorizationHeader.isEmpty()) {
            Long userId = tokenProviderService.getUserIdFromToken(authorizationHeader);
            System.out.println("userId = " + userId);
        }else{
            System.out.println("헤더 없음");
        }
        return "main/main";
    }
}
