package com.avengers.musinsa.domain.product.controller;

import com.avengers.musinsa.domain.product.dto.ProductListDTO;
import com.avengers.musinsa.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/product")
@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    public String getProductList(Model model){

        List<ProductListDTO> productListDTOS = productService.getProuctList();

        return "product/product";
    }
}
