package com.avengers.musinsa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/cart")
    public String cartPage(Model model) {
        model.addAttribute("userId", 1L);
        return "user/cart";
    }

}
