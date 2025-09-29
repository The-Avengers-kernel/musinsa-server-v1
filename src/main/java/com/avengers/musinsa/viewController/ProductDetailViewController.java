package com.avengers.musinsa.viewController;

import com.avengers.musinsa.domain.product.dto.response.ProductDetailResponse;
import com.avengers.musinsa.domain.product.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductDetailViewController {
    private final ProductServiceImpl productService;

    @GetMapping("/{productId}")
    public String geetProductDetail(@PathVariable Long productId, Model model) {
        //model.addAttribute("productId", productId);
        return "product/productDetailPage";
    }
}
