package com.avengers.musinsa.viewController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ShippingAddressViewController {

    @GetMapping("/shipping-address-popup")
    public String shippingAddressPopup(){
        System.out.println("배송지팝업 호출 확인");
        return "shipments/shippingAddressList";
    }

}
