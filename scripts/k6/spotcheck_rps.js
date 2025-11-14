// ./scripts/k6/spotcheck_rps.js
import http from "k6/http";
import {check} from "k6";

const BASE_URL = __ENV.BASE_URL || "http://localhost:8080";
const GENDER = __ENV.GENDER || "male";
const TOKEN = __ENV.TOKEN || "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Im5hdmVyIFVGUkVTeVpGQTlnY3lOWHN3OXhLU1h6aFlncXhWeHdxM19rM0FfUWJMb1UiLCJyb2xlIjoiUk9MRV9VU0VSIiwiaWF0IjoxNzYwOTQzMjQ5LCJleHAiOjE3NjEwMjk2NDl9.sPCvpvBt_QGCBCE939Nuh53Dq9GDOsXWVEJ_tyQip4o";
const TARGET_RPS = Number(__ENV.TARGET_RPS || 70); // 비교하고 싶은 RPS
const DURATION = __ENV.DURATION || "3m";
const EXPECTED_P95_S = Number(__ENV.EXPECTED_P95_S || 6);
const P95_MS = Number(__ENV.P95_MS || 800);
const FAIL_RATE = Number(__ENV.FAIL_RATE || 0.01);

export const options = {
    scenarios: {
        spot: {
            /* 초당 요청 도착률 고정(RPS)유지.
            * 서버가 느려지면 동시성(VU)을 늘려서라도 RPS 맞추려고 함*/
            executor: "constant-arrival-rate",
            /* 원하는 요청 도착률(초당)*/
            rate: TARGET_RPS,
            timeUnit: "1s",
            duration: DURATION,
            /*arrival-rate 실행기는 동시성 상한이 필요.
            계산식은 “RPS × 예상 p95(초)”가 대략 동시성. 여기서 여유 배수(1.2~2배)를 줬음.*/
            preAllocatedVUs: Math.max(20, Math.ceil(TARGET_RPS * EXPECTED_P95_S * 1.2)),
            maxVUs: Math.max(50, Math.ceil(TARGET_RPS * EXPECTED_P95_S * 2)),
            gracefulStop: "10s",
        },
    },
    /*http_req_failed 오류율, http_req_duration p95 지연시간을 테스트 성공 기준으로 사용.*/
    thresholds: {
        http_req_failed: [`rate<${FAIL_RATE}`],
        http_req_duration: [`p(95)<${P95_MS}`],
    },
    /*본문은 버리고 헤더+상태만 확인 → 메모리/네트워크 절약.*/
    discardResponseBodies: true,
};

export default function () {
    const url = `${BASE_URL}/api/v1/products/recommendations/${GENDER}`;
    const headers = {
        Accept: "application/json",
        ...(TOKEN ? {Cookie: `Authorization=${TOKEN}`} : {}),
    };

    const res = http.get(url, {headers});

    check(res, {"status 200": (r) => r.status === 200});
}

// 실행 예시
// k6 run ./scripts/k6/spotcheck_rps.js \
//  -e BASE_URL="http://localhost:8080" \
//  -e PATH="/api/v1/products/recommendations/male" \
//  -e TOKEN="...JWT..." \
//  -e TARGET_RPS=70 -e DURATION=5m -e EXPECTED_P95_S=6 \
//  --summary-export=spot_before.json
//
// 개선 후 동일 명령으로 spot_after.json 생성 → p95, p90, avg 비교
