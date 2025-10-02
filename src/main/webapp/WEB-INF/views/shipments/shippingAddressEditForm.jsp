<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>배송지 수정</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover, maximum-scale=1, user-scalable=no" />
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

    <style>
        :root{
            --bg:#fff;              /* 페이지 전체 배경 흰색 */
            --card:#fff;            /* 카드 영역도 흰색 유지 */
            --line:#ddd;            /* 라인 색상 좀 더 연하게 */
            --text:#111;            /* 진한 텍스트 */
            --muted:#aaa;           /* 보조 텍스트 */
        }
        *{box-sizing:border-box}
        html,body{height:100%}
        body{
            margin:0; background:var(--bg); color:var(--text);
            font-family:-apple-system,BlinkMacSystemFont,"Noto Sans KR","Segoe UI",Roboto,Helvetica,Arial,sans-serif;
        }

        /* 상단 고정 네비 영역이 있다고 가정하고 좌우 중앙폭/여백 조정 */
        .page{
            max-width:1040px;
            margin:0 auto;
            padding:32px 16px 140px;
            background:#fff;   /* 전체를 흰 배경으로 */
        }
        .title{
            font-size: 20px;
            font-weight: 700;
            margin-bottom: 20px;
            padding-bottom: 15px;
            border-bottom: 1px solid #eee; /* 이미지에 맞게 얇게 유지 */
            color: #333;}

        /* 카드 */
        .card{
            background:var(--card);
            border:none;            /* 테두리 제거 */
            padding:0;              /* 여백 최소화 */
            box-shadow:none;        /* 그림자 제거 */
        }

        .field{margin-bottom:16px}
        .label{font-weight:500; margin-bottom:8px; line-height: 20px;}
        .input,.select{
            width:100%; height:44px;
            background:#fff;
            border:1px solid var(--line);
            border-radius:6px;
            padding:0 12px;
            font-size:14px;
            outline:none;

        }
        .input::placeholder{color:#bfbfbf; }

        /* 우편번호 + 버튼 */
        .zip-row{display:flex; gap:8px}
        .btn{
            height:44px; padding:0 14px; border:1px solid var(--line); background:#fff;
            border-radius:6px; cursor:pointer; white-space:nowrap;
        }

        /* 셀렉트 화살표 */
        .select-wrap{position:relative}
        .select-wrap::after{
            content:"▾"; position:absolute; right:12px; top:50%; transform:translateY(-50%);
            color:#bfbfbf; font-size:12px; pointer-events:none;
        }
        .select{appearance:none}

        /* 체크박스 */
        .check{display:flex; align-items:center; gap:8px; margin-top:8px}

        /* 페이지 하단 고정 저장 바 */
        .savebar{
            position:fixed; left:0; right:0; bottom:0; background:#fff;
            border-top:1px solid var(--line); padding:16px;
        }
        .save-inner{max-width:1040px; margin:0 auto; padding:0 16px;}
        #saveBtn{
            width:100%; height:52px; border:none; border-radius:8px;
            background:#111; color:#fff; font-size:16px; cursor:pointer;
        }

        /* 모바일 보정 */
        @media (max-width:640px){
            .page{padding:20px 12px 140px;}
            .card{padding:20px}
        }
    </style>
</head>
<body>

<div class="page">
    <div class="title">배송지 수정</div>

    <div class="card">
        <!-- 이름 -->
        <div class="field">
            <div class="label">이름</div>
            <input type="text" id="recipientName" class="input" maxlength="20" value="${address.recipientName}">
        </div>

        <!-- 휴대폰번호 -->
        <div class="field">
            <div class="label">휴대폰번호</div>
            <input type="tel" id="recipientPhone" class="input" maxlength="13" value="${address.recipientPhone}">
        </div>

        <!-- 주소 -->
        <div class="field">
            <div class="label">주소</div>

            <div class="zip-row" style="margin-bottom:8px;">
                <input type="text" id="postalCode" class="input" inputmode="numeric" maxlength="5" value="${address.postalCode}" placeholder="우편번호">
                <button type="button" class="btn" id="btnFindAddr">주소 찾기</button>
            </div>

            <input type="text" id="address1" class="input" value="${address.addressLine1}" placeholder="기본 주소" style="margin-bottom:8px;">
            <input type="text" id="address2" class="input" maxlength="100" value="${address.addressLine2}" placeholder="상세 주소">

            <!-- 서버 전송용: 주소+상세주소 합쳐서 넣음 -->
            <input type="hidden" id="recipientAddress">
        </div>

        <!-- 배송 요청사항 (선택) -->
        <div class="field">
            <div class="label">배송 요청사항 (선택)</div>
            <div class="select-wrap" style="position: relative;">
                <select id="request" class="select">
                    <option value="">배송 요청사항을 선택해주세요</option>
                    <option value="문 앞에 놓아주세요">문 앞에 놓아주세요</option>
                    <option value="경비실에 맡겨주세요">경비실에 맡겨주세요</option>
                    <option value="부재 시 연락 부탁드립니다">부재 시 연락 부탁드립니다</option>
                    <option value="직접입력">직접입력</option>
                </select>
            </div>
            <div id="requestManualWrap" style="display:none; margin-top:8px;">
                <input type="text" id="requestManual" class="input" maxlength="50" placeholder="최대 50자까지 입력가능">
            </div>
        </div>

        <!-- 기본 배송지 체크 -->
        <div class="check">
            <input type="checkbox" id="isDefault">
            <label for="isDefault">기본 배송지로 설정</label>
        </div>
    </div>
</div>

<!-- 하단 고정 저장 버튼 -->
<div class="savebar">
    <div class="save-inner">
        <button id="saveBtn">저장하기</button>
    </div>
</div>

<script>
    const shippingAddressId = "${address.shippingAddressId}";
    const userId = "${userId}";


    $("#request").on("change",function(){
        $("#requestManualWrap").toggle($(this).val()==="직접입력");
    });

    $("#saveBtn").click(function(data){
        const recipientName = $("#recipientName").val().trim();
        const recipientPhone = $("#recipientPhone").val().trim();
        const postalCode = $("#postalCode").val().trim();
        const recipientAddress = $("#addressLine1").val().trim() + " " + $("#addressLine2").val().trim();
        $("#recipientAddress").val(recipientAddress);



        const payload = {
            recipientName: $("#recipientName").val().trim(),
            recipientPhone: $("#recipientPhone").val().trim(),
            postalCode: $("#postalCode").val().trim(),
            addressLine1: $("#address1").val().trim(),
            addressLine2: $("#address2").val().trim(),
            requestMessage: ($("#request").val()==="직접입력") ? $("#requestManual").val().trim() : $("#request").val(),
            isDefault: $("#isDefault").is(":checked")
        };


        $.ajax({
            type:"PUT",
            url:"${pageContext.request.contextPath}/api/v1/update/" + userId + "/" + shippingAddressId,
            contentType:"application/json",
            data:JSON.stringify(payload),
            success:()=>{
                alert("배송지가 수정되었습니다.");
                location.href="${pageContext.request.contextPath}/shipping-address-popup";
            },
            error:(xhr)=>alert("수정 실패: "+(xhr.responseText||"알 수 없는 오류"))
        });
    });
</script>


</body>
</html>