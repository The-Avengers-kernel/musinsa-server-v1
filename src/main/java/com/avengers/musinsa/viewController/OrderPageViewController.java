package com.avengers.musinsa.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderPageViewController {

    @GetMapping("/page")
    public String orderPage() {
        return "order/orderPage.jsp";
    }
}