<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>최근 검색</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <style>
        body {
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
            background-color: #f8f9fa;
            padding: 20px;
        }
        .recent-searches-container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }
        .recent-searches-header {
            /* [수정] 아래는 Java(Spring) 컨트롤러 코드이므로 CSS 파일에 있을 수 없습니다.
              이 코드는 서버의 Java 파일에 위치해야 합니다. 따라서 삭제했습니다.
              @RestController
              @RequestMapping("/api/v1/search")
              ...
            */
            padding: 20px;
            border-bottom: 1px solid #e9ecef;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .recent-searches-title {
            font-size: 18px;
            font-weight: bold;
        }
        .delete-all-btn {
            font-size: 13px;
            color: #868e96;
            cursor: pointer;
        }
        .recent-searches-list {
            list-style: none;
            padding: 0;
            margin: 0;
        }
        .recent-search-item {
            display: flex;
            align-items: center;
            padding: 15px 20px;
            border-bottom: 1px solid #e9ecef;
        }
        .recent-search-item:last-child {
            border-bottom: none;
        }
        .item-image {
            width: 50px;
            height: 50px;
            border-radius: 4px;
            margin-right: 15px;
            object-fit: cover;
            background-color: #f0f0f0; /* 이미지가 없을 경우를 대비한 배경색 */
        }
        .item-info {
            flex-grow: 1;
        }
        .item-name {
            font-size: 15px;
            font-weight: 500;
            margin-bottom: 5px;
        }
        .item-type {
            font-size: 12px;
            color: #868e96;
        }
        .delete-item-btn {
            font-size: 18px;
            color: #adb5bd;
            cursor: pointer;
        }
    </style>
</head>
<body>

<div class="recent-searches-container">
    <div class="recent-searches-header">
        <h1 class="recent-searches-title">최근 검색</h1>
        <span class="delete-all-btn">전체삭제</span>
    </div>
    <ul class="recent-searches-list" id="recentSearchesList">
    </ul>
</div>

<script>

    $(document).ready(function () {

        // 화면 목록을 그려주는 함수
        function renderRecentSearches(searches) {
            const $list = $('#recentSearchesList'); // jQuery 셀렉터 사용
            $list.empty(); // 기존 목록 초기화

            if (!searches || searches.length === 0) {
                $list.html('<li class="recent-search-item">최근 검색 기록이 없습니다.</li>');
                return;
            }

            $.each(searches, function(index, item) {
                let imageUrl, name, typeText;

                if (item.type === 'brand') {
                    imageUrl = item.brandImageUrl;
                    name = item.brandName;
                    typeText = '브랜드';
                } else if (item.type === 'product') {
                    imageUrl = item.productImageUrl;
                    name = item.productName;
                    typeText = '상품';
                }

                // [수정] 백틱(``)을 사용한 템플릿 리터럴로 HTML 문자열을 더 깔끔하게 만듭니다.
                const itemHtml = `
                <li class="recent-search-item">
                    <img src="${imageUrl}" alt="${name}" class="item-image">
                    <div class="item-info">
                        <div class="item-name">${name}</div>
                        <div class="item-type">${typeText}</div>
                    </div>
                    <span class="delete-item-btn">×</span>
                </li>
            `;
                $list.append(itemHtml);
            });
        }


        $.ajax({
            url: '/api/v1/search/recent', // API 엔드포인트 URL
            method: 'GET',
            data: { userId: 123 }, // 서버에 전달할 파라미터. 실제로는 동적으로 userId를 전달해야 함
            dataType: 'json',
            success: function(response) {

                if (response && response.result && response.result.recentSearches) {
                    renderRecentSearches(response.result.recentSearches);
                } else {
                    // 서버가 배열만 바로 반환하는 경우
                    renderRecentSearches(response);
                }
            },
            error: function(xhr, status, error) {
                console.error('최근 검색어 로딩 중 오류 발생:', error);
                $('#recentSearchesList').html('<li class="recent-search-item">목록을 불러오는 데 실패했습니다.</li>');
            }
        });
    });
</script>

</body>
</html>