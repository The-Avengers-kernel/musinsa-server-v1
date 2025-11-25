import http from "k6/http";
import {check, sleep} from "k6";

const BASE_URL = __ENV.BASE_URL || "http://localhost:8080";
const CATEGORY_ID = __ENV.CATEGORY_ID || "101";
const TOKEN = __ENV.TOKEN || "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Im5hdmVyIFVGUkVTeVpGQTlnY3lOWHN3OXhLU1h6aFlncXhWeHdxM19rM0FfUWJMb1UiLCJyb2xlIjoiUk9MRV9VU0VSIiwiaWF0IjoxNzYwNjEzODE2LCJleHAiOjE3NjA3MDAyMTZ9.Mw9DehrzaZ5xyCY6a6B4L_NJGSs84LIDLjfLcsLm_0U"; // 예: k6 run -e TOKEN=eyJ... 로 전달

export const options = {
    vus: 100,            // 동시 가상 유저 수 (Virtual Users)
    duration: "30s",    // 테스트 지속 시간
    thresholds: {
        http_req_failed: ["rate<0.01"],   // 실패율 1% 미만
        http_req_duration: ["p(95)<500"], // 95%가 500ms 미만
    },
};

export default function () {
    const url = `${BASE_URL}/api/v1/products/category/${CATEGORY_ID}`;

    const headers = {
        "Accept": "application/json",
        "Cookie": `Authorization=${TOKEN}`, // ← 쿠키로 전송
    };

    const res = http.get(url, {headers});

    check(res, {
        "status is 200": (r) => r.status === 200,
    });

    // 처음 몇 회만 상태 로그 확인
    if (__ITER < 3) {
        console.log(`GET ${url} -> ${res.status}`);
    }

    sleep(1); // 각 유저가 요청 후 1초 대기
}
