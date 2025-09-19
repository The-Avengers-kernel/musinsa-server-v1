package com.avengers.musinsa.domain.order.controller;


import com.avengers.musinsa.domain.order.dto.OrderProductDTO;
import com.avengers.musinsa.domain.order.dto.UserInfoDTO;
import com.avengers.musinsa.domain.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderService orderService;

    //주문화면 접속??
    @GetMapping("/orders")
    public String orders(){
       return "order";
    }

    //주문자 기본정보 조회
    @GetMapping("/orders/user-info/{userId}")
    public ResponseEntity<UserInfoDTO> getUserInfo(@PathVariable Long userId){
        UserInfoDTO userInfo = orderService.getUserInfo(userId);

        return ResponseEntity.ok(userInfo);
    }

    //배송지 목록 조회






    //주문 상품 리스트(상품이미지, 사이즈, 개수, 금액)

    @GetMapping("/orders/product/{productId}")
    public ResponseEntity<List<OrderProductDTO>> getOrderProducts(@PathVariable Long productId,
                                                                  @RequestParam Integer quantity, Model model){

        //List<OrderProductDTO> orderProducts = orderService.getOrderProducts(productId,);
        return ResponseEntity.ok(orderService.getOrderProducts(productId, quantity));
    }







    //상품별 할인금액 계산




    //주문하기





}
