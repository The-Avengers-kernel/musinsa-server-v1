import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
    vus: 1000,        // Virtual Users (가상 사용자 수)
    duration: '5m', // 테스트 지속 시간

    thresholds: {
        http_req_duration: ['p(95)<5000'],  // 95%가 5초 이내
        http_req_failed: ['rate<0.1'],      // 에러율 10% 미만
    },
};

export default function() {
    const payload = JSON.stringify({
        userId: null,
        addressId: null,
        couponId: null,
        shipping: {
            recipientName: "홍길동",
            recipientPhone: "010-1234-5678",
            recipientAddress: "서울시 강남구 테헤란로 123",
            shippingDirectRequest: "문 앞에 놓아주세요",
            postalCode: "12345"
        },
        payment: {
            totalAmount: 50000,
            discountAmount: 0,
            userOfReward: 0,
            deliveryFee: 3000,
            paymentMethodId: 1
        },
        product: [{
            productId: 59999,
            variantId: null,
            options:{},
            finalPrice: 50000,
            quantity: 1,
            optionName: "Red / S",
            discountRate: 0,
            productDiscountAmount: 0,
        }]
    });

    const response = http.post(
        'http://localhost:8080/orders/completion-order',
        payload,
        {
            headers: {
                'Content-Type': 'application/json',
                'Cookie': 'Authorization=eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Im5hdmVyIGRzZjJpUnR6UkZOTHBuS05DQXEtRVk4SzJjOHhZZUYxcl9ZOC01MUVGTVUiLCJyb2xlIjoiUk9MRV9VU0VSIiwiaWF0IjoxNzU5NTUyODY2LCJleHAiOjE3NTk2MzkyNjZ9.3G7_bVBuXdt1lHLR6-5w8Ssvas0VQo-6rOwdBcebZSk; JSESSIONID=CE1BB3C60F9CFD0C1A87F1AC229B67C3'
            }
        }
    );

    check(response, {
        '✅ 상태 코드 200': (r) => r.status === 200,
        '✅ 응답 시간 < 5초': (r) => r.timings.duration < 5000,
    });

    sleep(1);  // 요청 간 1초 대기
}