<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width" />
    <title>프로필 설정</title>
    <%@ include file="../main/header.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <style>
        body { font-family: 'Noto Sans KR', sans-serif; background:#f8f9fa; margin:0; }
        .layout { max-width:960px; margin:auto; padding:20px; }
        .settings-card { background:#fff; border-radius:12px; box-shadow:0 1px 4px rgba(0,0,0,0.05); padding:20px; margin-top:20px; }
        .profile-box { text-align:center; margin-bottom:20px; }
        .profile-box img { width:80px; height:80px; border-radius:50%; object-fit:cover; }
        .profile-info { margin:10px 0; font-size:16px; font-weight:600; }
        .profile-id { color:#666; font-size:14px; margin-bottom:15px; }
        .profile-actions { display:flex; gap:10px; justify-content:center; }
        .profile-actions button {
            flex:1; max-width:150px;
            padding:10px 15px;
            border:1px solid #ddd;
            border-radius:8px;
            background:#fff;
            color:#000;
            font-weight:600;
            font-size:14px;
            cursor:pointer;
            transition:all 0.2s ease;
        }
        .profile-actions button:hover {
            border-color:#000;
            background:#f9f9f9;
        }
        .settings-list { list-style:none; padding:0; margin:0; }
        .settings-list li {
            padding:16px; border-bottom:1px solid #eee;
            display:flex; justify-content:space-between; align-items:center;
            font-size:15px;
        }
        .settings-list li span { color:#000000; }

        /* 모달 스타일 */
        .modal {
            display:none;
            position:fixed;
            top:0; left:0;
            width:100%; height:100%;
            background:rgba(0,0,0,0.5);
            justify-content:center;
            align-items:center;
        }
        .modal-content {
            background:#fff;
            border-radius:12px;
            padding:20px;
            width:400px;
            max-width:90%;
            box-shadow:0 2px 8px rgba(0,0,0,0.2);
            text-align:center;
        }
        .modal-content h2 { margin-top:0; font-size:18px; }
        .modal-content input[type="text"],
        .modal-content input[type="file"] {
            width:100%;
            padding:10px;
            margin:10px 0;
            border:1px solid #ccc;
            border-radius:6px;
        }
        .modal-actions {
            display:flex;
            gap:10px;
            margin-top:15px;
        }
        .modal-actions button,
        .modal-actions a {
            flex:1;
            padding:10px;
            border:none;
            border-radius:6px;
            font-size:14px;
            cursor:pointer;
            text-decoration:none;
        }
        .btn-primary {
            background:#000;
            color:#fff;
        }
        .btn-secondary {
            background:#eee;
            color:#333;
        }
    </style>
</head>
<body>
<div class="layout">
    <section class="settings-card">
        <!-- 프로필 영역 -->
        <div class="profile-box">
            <img src="${profileImage != null ? profileImage : '/resources/img/default_profile.png'}" alt="프로필">
            <div class="profile-info">
                <p><strong>${nickname}</strong></p>
            </div>
            <div class="profile-actions">
                <button onclick="openModal('profileModal')">프로필 이미지 변경</button>
                <button onclick="openModal('nicknameModal')">닉네임 변경</button>
            </div>
        </div>
        <!-- 설정 리스트 -->
        <ul class="settings-list">

            <li><span onclick="location.href='/shipping-address-popup'">배송지 관리</span><span>></span></li>
            <li><span>환불 계좌 관리</span><span>></span></li>
            <li><span>알림 설정</span><span>></span></li>
            <li><span>회원 탈퇴</span><span>></span></li>
        </ul>
    </section>
</div>

<!-- 닉네임 변경 모달 -->
<div id="nicknameModal" class="modal">
    <div class="modal-content">
        <h2>닉네임 변경</h2>
        <form action="${pageContext.request.contextPath}/mypage/nickname" method="post">
            <input type="text" name="nickname" maxlength="8" placeholder="새 닉네임 입력 (최대 8자)" required>
            <div class="modal-actions">
                <button type="submit" class="btn-primary">변경하기</button>
                <button type="button" class="btn-secondary" onclick="closeModal('nicknameModal')">닫기</button>
            </div>
        </form>
    </div>
</div>

<!-- 프로필 이미지 변경 모달 -->
<div id="profileModal" class="modal">
    <div class="modal-content">
        <h2>프로필 이미지 변경</h2>
        <form action="${pageContext.request.contextPath}/mypage/profile-image" method="post" enctype="multipart/form-data">
            <input type="file" name="file" accept="image/*" required>
            <div class="modal-actions">
                <button type="submit" class="btn-primary">저장</button>
                <button type="button" class="btn-secondary" onclick="closeModal('profileModal')">닫기</button>
            </div>
        </form>
    </div>
</div>
<script>
    function openModal(id) {
        document.getElementById(id).style.display = "flex";
    }
    function closeModal(id) {
        document.getElementById(id).style.display = "none";
    }



</script>

</body>
</html>