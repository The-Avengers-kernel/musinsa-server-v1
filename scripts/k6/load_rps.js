import http from "k6/http";
import {check} from "k6";

// ====== 환경 변수 ======
const BASE_URL = __ENV.BASE_URL || "http://localhost:8080";
const CATEGORY_ID = __ENV.CATEGORY_ID || "101";
const GENDER = __ENV.GENDER || "male";
const TOKEN = __ENV.TOKEN || "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Im5hdmVyIFVGUkVTeVpGQTlnY3lOWHN3OXhLU1h6aFlncXhWeHdxM19rM0FfUWJMb1UiLCJyb2xlIjoiUk9MRV9VU0VSIiwiaWF0IjoxNzYwOTI5NTQ0LCJleHAiOjE3NjEwMTU5NDR9.EUSxOSOt3S2-s_S6KcJecQT9WdTr118KhCHnHD_DY3s";
const TARGET_RPS = Number(__ENV.TARGET_RPS || 200);   // 예: 100 RPS(초당 요청량)
const DURATION = __ENV.DURATION || "3m";          // 예: 3분
const P95_MS = Number(__ENV.P95_MS || 800);       // 95퍼센타일 목표
const FAIL_RATE = Number(__ENV.FAIL_RATE || 0.01);   // 실패율 목표(1%)

// ====== 시나리오 옵션 (Load Test) ======
export const options = {
    scenarios: {
        load: {
            executor: "constant-arrival-rate",
            rate: TARGET_RPS,          // 초당 요청 수 고정
            timeUnit: "1s",
            duration: DURATION,
            preAllocatedVUs: Math.max(30, Math.ceil(TARGET_RPS * 0.25)),
            maxVUs: Math.max(200, TARGET_RPS * 2),
            gracefulStop: "10s",
        },
    },
    thresholds: {
        http_req_failed: [`rate<${FAIL_RATE}`],         // 실패율 < FAIL_RATE
        http_req_duration: [`p(95)<${P95_MS}`],         // p95 < P95_MS(ms)
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

    check(res, {
        "status 200": (r) => r.status === 200,
    });
}
