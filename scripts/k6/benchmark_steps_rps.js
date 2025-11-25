// ./scripts/k6/benchmark_steps_rps.js
import http from "k6/http";
import {check} from "k6";

// ===== ENV =====
// 예) -e BASE_URL=http://localhost:8080 -e PATH=/api/v1/products/recommendations/male
const BASE_URL = __ENV.BASE_URL || "http://localhost:8080";
const GENDER = __ENV.GENDER || "male";
const TOKEN = __ENV.TOKEN || "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Im5hdmVyIFVGUkVTeVpGQTlnY3lOWHN3OXhLU1h6aFlncXhWeHdxM19rM0FfUWJMb1UiLCJyb2xlIjoiUk9MRV9VU0VSIiwiaWF0IjoxNzYwOTQzMjQ5LCJleHAiOjE3NjEwMjk2NDl9.sPCvpvBt_QGCBCE939Nuh53Dq9GDOsXWVEJ_tyQip4o";
// RPS 단계들(콤마 구분)
const STAGES_CSV = __ENV.STAGES_CSV || "40,60,80,100";
const DURATION_SEC = Number(__ENV.DURATION_SEC || 90);  // 각 단계 지속(초)
const COOLDOWN_SEC = Number(__ENV.COOLDOWN_SEC || 10);  // 단계 간 쿨다운(초)
// 클라이언트에서 필요한 VU 산정(느린 API면 5~10 권장)
const EXPECTED_P95_S = Number(__ENV.EXPECTED_P95_S || 1.0);
// 품질 기준(전체 테스트에 대한 전역 기준)
const P95_MS = Number(__ENV.P95_MS || 800);
const FAIL_RATE = Number(__ENV.FAIL_RATE || 0.01);

// 유틸
function startAt(i) {
    return `${i * (DURATION_SEC + COOLDOWN_SEC)}s`;
}

const STAGES = STAGES_CSV.split(",").map(s => Number(s.trim())).filter(n => !Number.isNaN(n));

// ===== dynamic scenarios =====
const scenarios = {};
STAGES.forEach((rps, i) => {
    const pre = Math.max(10, Math.ceil(rps * EXPECTED_P95_S * 1.2));
    const max = Math.max(50, pre * 2);
    scenarios[`rps_${rps}`] = {
        executor: "constant-arrival-rate",
        rate: rps,
        timeUnit: "1s",
        duration: `${DURATION_SEC}s`,
        startTime: startAt(i),
        preAllocatedVUs: pre,
        maxVUs: max,
        tags: {stage_rps: String(rps)}, // 태그로 구분
        gracefulStop: "10s",
    };
});

export const options = {
    scenarios,
    thresholds: {
        http_req_failed: [`rate<${FAIL_RATE}`],
        http_req_duration: [`p(95)<${P95_MS}`], // 전역 기준(스테이지별 추이는 그래프로 확인)
        // 필요하면 스테이지별 기준도 추가 가능 예시:
        // "http_req_duration{scenario:rps_80}": ["p(95)<1200"],
    },
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

// 👉 실행 예시(개선 전/후 각각 실행하고 요약 JSON을 저장):
// k6 run ./scripts/k6/benchmark_steps_rps.js \
//  -e BASE_URL="http://localhost:8080" \
//  -e PATH="/api/v1/products/recommendations/male" \
//  -e TOKEN="...JWT..." \
//  -e STAGES_CSV="40,60,80,100" \
//  -e DURATION_SEC=90 -e COOLDOWN_SEC=10 \
//  -e EXPECTED_P95_S=6 \
//  --summary-export=before.json
//
// (코드 개선 후 동일 명령으로 after.json 생성)
// --summary-export=after.json
//
// 비교 포인트(대시보드/요약 JSON):
// - 각 단계에서 목표 RPS에 “도달”했는지(Iteration/Request Rate 평탄? dropped_iterations?)
// - p95(ms) 추세가 개선되었는지
// - VUs가 maxVUs에 붙지 않는지
