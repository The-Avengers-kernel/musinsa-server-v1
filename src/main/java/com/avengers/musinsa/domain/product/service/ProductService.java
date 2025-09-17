package com.avengers.musinsa.domain.product.service;


import com.avengers.musinsa.domain.product.controller.ProductController;
import com.avengers.musinsa.domain.product.converter.ProductConverter;
import com.avengers.musinsa.domain.product.dto.ProductListDTO;
import com.avengers.musinsa.domain.product.respository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<ProductListDTO> getProuctList() {


        List<ProductListDTO> productListDTOS = ProductConverter.toProductListDto();
        return productListDTOS;
    }

}
