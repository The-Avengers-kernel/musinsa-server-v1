package com.avengers.musinsa.viewController;

import com.avengers.musinsa.domain.order.controller.OrderPageController;
import com.avengers.musinsa.domain.order.dto.request.OrderPageRequest;
import com.avengers.musinsa.domain.order.dto.response.OrderPageResponse;
import com.avengers.musinsa.domain.order.dto.response.PriceInfoDto;
import com.avengers.musinsa.domain.order.service.OrderPageService;
import com.avengers.musinsa.domain.user.auth.jwt.TokenProviderService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderPageViewController {

    private final TokenProviderService tokenProviderService;
    private final OrderPageService orderPageService;

    @PostMapping("/orders-page")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> processOrder(
            @RequestBody OrderPageRequest request,
            @CookieValue(value = "Authorization") String authorization,
            HttpSession session) {

        try {
            Long userId = tokenProviderService.getUserIdFromToken(authorization);
            OrderPageResponse response = orderPageService.getOrderPageInfo(userId, request);

            // 세션에 데이터 저장
            session.setAttribute("orderData", response);

            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("redirectUrl", "/orders/order-page");

            return ResponseEntity.ok(result);

        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "주문 처리 중 오류가 발생했습니다.");
            return ResponseEntity.badRequest().body(result);
        }
    }
    @GetMapping("/order-page")
    public String showOrderPage(HttpSession session, Model model) {

        OrderPageResponse response = (OrderPageResponse) session.getAttribute("orderData");

        if (response == null) {
            return "redirect:/cart";
        }

        BuyerRecipientInfoAdapter buyerRecipientInfoAdapter = new BuyerRecipientInfoAdapter(response);
        List<ProductAdapter> orderProductAdapters = response.getProducts().stream()
                .map(ProductAdapter::new)
                .toList();

        System.out.println(response.getMileageInfo().getTotalMileage());

        model.addAttribute("buyerRecipientInfoAdapter", buyerRecipientInfoAdapter);
        model.addAttribute("orderProductAdapters", orderProductAdapters);

        return "order/orderPage";
    }



    public static class BuyerRecipientInfoAdapter{
        private final OrderPageResponse product;

        public BuyerRecipientInfoAdapter(OrderPageResponse product) {
            this.product = product;
        }

        //구매자 정보 가져오기
        public String getBuyerName(){return product.getBuyerInfo().getName();}
        public String getBuyerPhone(){return product.getBuyerInfo().getPhone();}
        public String getBuyerEmail(){return product.getBuyerInfo().getEmail();}

        // 수령자 정보 가져오기
        public String getRecipientName(){return product.getBuyerInfo().getDefaultAddress().getRecipientName();}
        public String getRecipientPhone(){return product.getBuyerInfo().getDefaultAddress().getRecipientPhone();}
        public String getRecipientPostCode(){return product.getBuyerInfo().getDefaultAddress().getPostCode();}
        public String getRecipientAddress(){return product.getBuyerInfo().getDefaultAddress().getAddress();}
        public String getRecipientDetailAddress(){return product.getBuyerInfo().getDefaultAddress().getDetailAddress();}

        //적립금 가져오기
        public Integer getMileage(){return product.getMileageInfo().getTotalMileage();}
    }


    public static class ProductAdapter{
        private final OrderPageResponse.OrderProductInfo productInfo;

        public ProductAdapter(OrderPageResponse.OrderProductInfo productInfo) {
            this.productInfo = productInfo;
        }

        //구매 상품 가져오기
        public Long getBrandId(){return productInfo.getBrandId();}
        public String getBrandName(){return productInfo.getBrandName();}
        public String getBrandImage(){return productInfo.getBrandImage();}
        public Long getProductId(){return productInfo.getProductId();}
        public String getProductName(){return productInfo.getProductName();}
        public String getProductImage(){return productInfo.getProductImage();}
        public Integer getFinalPrice(){return productInfo.getFinalPrice();}
        public String getOptionName(){return productInfo.getOptionName();}
        public Integer getQuantity(){return productInfo.getQuantity();}
        public Integer getTotalPrice(){return productInfo.getTotalPrice();}
        public Integer getDiscountRate(){return productInfo.getDiscountRate();}
        public Integer getOriginalPrice(){return productInfo.getOriginalPrice();}
    }
}

