// ./scripts/k6/smoke_rps.js
import http from "k6/http";
import {check, sleep} from "k6";

// ====== 환경 변수 ======
const BASE_URL = __ENV.BASE_URL || "http://localhost:8080";
const CATEGORY_ID = __ENV.CATEGORY_ID || "101";
const GENDER = __ENV.GENDER || "male";
const TOKEN =
    __ENV.TOKEN ||
    "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Im5hdmVyIFVGUkVTeVpGQTlnY3lOWHN3OXhLU1h6aFlncXhWeHdxM19rM0FfUWJMb1UiLCJyb2xlIjoiUk9MRV9VU0VSIiwiaWF0IjoxNzYwOTI5NTQ0LCJleHAiOjE3NjEwMTU5NDR9.EUSxOSOt3S2-s_S6KcJecQT9WdTr118KhCHnHD_DY3s"
// ====== 시나리오 옵션 (Smoke Test) ======
export const options = {
    scenarios: {
        smoke: {
            executor: "constant-arrival-rate",
            rate: 5,              // 초당 5건 요청
            timeUnit: "1s",
            duration: "30s",      // 30초만 수행
            preAllocatedVUs: 5,   // 최소 VU
            maxVUs: 10,           // 최대 VU
        },
    },
    thresholds: {
        http_req_failed: ["rate<0.05"],   // 실패율 5% 미만
        http_req_duration: ["p(95)<1000"], // 95% 요청이 1초 이내
    },
    discardResponseBodies: true,
};

// ====== 테스트 본문 ======
export default function () {
    const url = `${BASE_URL}/api/v1/products/recommendations/${GENDER}`;
    const headers = {
        Accept: "application/json",
        ...(TOKEN ? {Cookie: `Authorization=${TOKEN}`} : {}),
    };

    const res = http.get(url, {headers});

    check(res, {"status is 200": (r) => r.status === 200});

    sleep(1); // smoke test에서는 약간의 간격을 둠
}
