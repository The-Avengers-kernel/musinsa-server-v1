import http from "k6/http";
import {check} from "k6";

/**
 * 🔧 ENV
 * BASE_URL           기본: http://localhost:8080
 * PATH               기본: /api/v1/products/recommendations/male   (원하면 /api/v1/products/category/101 등으로 교체)
 * TOKEN              기본: ""  (쿠키 Authorization로 전송)
 * STEP_DURATION      기본: 2m  (각 스텝 지속시간)
 * STAGES_CSV         기본: "50,100,150,200,250,300"  (RPS 단계)
 * P95_MS             기본: 800  (전체 테스트 성공 기준)
 * FAIL_RATE          기본: 0.01
 * EXPECTED_P95_S     기본: 1.0  (클라이언트 VU 산정용; 느린 API면 5~10으로 올리세요)
 */

const BASE_URL = __ENV.BASE_URL || "http://localhost:8080";
const GENDER = __ENV.GENDER || "male";
const TOKEN = __ENV.TOKEN || "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Im5hdmVyIFVGUkVTeVpGQTlnY3lOWHN3OXhLU1h6aFlncXhWeHdxM19rM0FfUWJMb1UiLCJyb2xlIjoiUk9MRV9VU0VSIiwiaWF0IjoxNzYwOTQzMjQ5LCJleHAiOjE3NjEwMjk2NDl9.sPCvpvBt_QGCBCE939Nuh53Dq9GDOsXWVEJ_tyQip4o";
const STEP_DURATION = __ENV.STEP_DURATION || "2m";
const STAGES_CSV = __ENV.STAGES_CSV || "40, 60, 80, 100";
const P95_MS = Number(__ENV.P95_MS || 800);
const FAIL_RATE = Number(__ENV.FAIL_RATE || 0.01);
const EXPECTED_P95_S = Number(__ENV.EXPECTED_P95_S || 1.0);

// 파싱된 스테이지들 (예: [50,100,150,...])
const STAGES = STAGES_CSV.split(",").map((v) => Number(v.trim())).filter((n) => !Number.isNaN(n));
const MAX_RPS = Math.max(...STAGES);

// VU 산정: RPS * 예상 p95(s) * 여유계수
const PRE_ALLOC = Math.max(50, Math.ceil(MAX_RPS * EXPECTED_P95_S * 1.2));
const MAX_VUS = Math.max(200, PRE_ALLOC * 2);

export const options = {
    scenarios: {
        ramp_find_limit: {
            executor: "ramping-arrival-rate",
            startRate: STAGES[0],
            timeUnit: "1s",
            preAllocatedVUs: PRE_ALLOC,
            maxVUs: MAX_VUS,
            stages: STAGES.map((target) => ({target, duration: STEP_DURATION})),
            gracefulStop: "15s",
        },
    },
    thresholds: {
        http_req_failed: [`rate<${FAIL_RATE}`],
        http_req_duration: [`p(95)<${P95_MS}`], // 전체 기준(스텝별 추세는 대시보드로 확인)
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
