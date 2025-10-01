package com.avengers.musinsa;

import com.avengers.musinsa.domain.order.dto.request.OrderPageRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderPageControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testOrderPageRequest() throws Exception {
        // JavaScript에서 보내는 것과 동일한 데이터 구조
        OrderPageRequest request = new OrderPageRequest();
        request.setType("DIRECT_PURCHASE");
        request.setCartItemIds(null);
        request.setProductId(1L);
        request.setQuantity(1);
        request.setProductVariantId(1L);
        request.setOptionName("testOption");

        String jsonRequest = objectMapper.writeValueAsString(request);
        System.out.println("Request JSON: " + jsonRequest);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Cookie", "Authorization=test-token");

        HttpEntity<String> entity = new HttpEntity<>(jsonRequest, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
            "http://localhost:" + port + "/orders/orders-page",
            entity,
            String.class
        );

        System.out.println("Response Status: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody());
    }

    @Test
    public void testOrderPageRequestWithoutCookie() throws Exception {
        OrderPageRequest request = new OrderPageRequest();
        request.setType("DIRECT_PURCHASE");
        request.setCartItemIds(null);
        request.setProductId(1L);
        request.setQuantity(1);
        request.setProductVariantId(1L);
        request.setOptionName("testOption");

        String jsonRequest = objectMapper.writeValueAsString(request);
        System.out.println("Request JSON without cookie: " + jsonRequest);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(jsonRequest, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
            "http://localhost:" + port + "/orders/orders-page",
            entity,
            String.class
        );

        System.out.println("Response Status (no cookie): " + response.getStatusCode());
        System.out.println("Response Body (no cookie): " + response.getBody());
    }

    @Test
    public void testOrderPageRequestValidation() throws Exception {
        // 빈 요청 테스트
        OrderPageRequest request = new OrderPageRequest();

        String jsonRequest = objectMapper.writeValueAsString(request);
        System.out.println("Empty request JSON: " + jsonRequest);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Cookie", "Authorization=test-token");

        HttpEntity<String> entity = new HttpEntity<>(jsonRequest, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
            "http://localhost:" + port + "/orders/orders-page",
            entity,
            String.class
        );

        System.out.println("Response Status (empty): " + response.getStatusCode());
        System.out.println("Response Body (empty): " + response.getBody());
    }
}