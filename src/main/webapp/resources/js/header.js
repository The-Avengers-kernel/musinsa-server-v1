
    // 사이드바 관련 변수
    const menuBtn = document.getElementById('menuBtn');
    const sidebar = document.getElementById('sidebar');
    const sidebarOverlay = document.getElementById('sidebarOverlay');
    const closeSidebar = document.getElementById('closeSidebar');
    const tabButtons = document.querySelectorAll('.tab-btn');
    const tabContents = document.querySelectorAll('.tab-content');

    // 햄버거 메뉴 버튼 클릭
    menuBtn.addEventListener('click', function() {
    openSidebar();
});

    // 사이드바 닫기 버튼 클릭
    closeSidebar.addEventListener('click', function() {
    closeSidebarFunc();
});

    // 오버레이 클릭시 사이드바 닫기
    sidebarOverlay.addEventListener('click', function() {
    closeSidebarFunc();
});

    // 사이드바 열기
    function openSidebar() {
    sidebar.classList.add('open');
    sidebarOverlay.classList.add('show');
    sidebarOverlay.style.display = 'block';
    document.body.style.overflow = 'hidden';
}

    // 사이드바 닫기
    function closeSidebarFunc() {
    sidebar.classList.remove('open');
    sidebarOverlay.classList.remove('show');
    setTimeout(() => {
    sidebarOverlay.style.display = 'none';
}, 300);
    document.body.style.overflow = 'auto';
}

    // 탭 버튼 클릭 이벤트
    tabButtons.forEach(button => {
    button.addEventListener('click', function() {
        const tabName = this.getAttribute('data-tab');

        // 모든 탭 버튼 비활성화
        tabButtons.forEach(btn => btn.classList.remove('active'));
        // 클릭된 탭 버튼 활성화
        this.classList.add('active');

        // 모든 탭 콘텐츠 숨기기
        tabContents.forEach(content => content.classList.remove('active'));
        // 선택된 탭 콘텐츠 보이기
        document.getElementById(tabName + '-tab').classList.add('active');
    });
});

    // 알파벳 버튼 클릭 이벤트
    const alphabetButtons = document.querySelectorAll('.alphabet-btn');
    alphabetButtons.forEach(button => {
    button.addEventListener('click', function() {
        alphabetButtons.forEach(btn => btn.classList.remove('active'));
        this.classList.add('active');
        console.log('선택된 초성:', this.textContent);
    });
});

    // 브랜드 검색 기능
    const brandSearchInput = document.getElementById('brandSearchInput');
    brandSearchInput.addEventListener('input', function() {
    const searchTerm = this.value.toLowerCase();
    const brandItems = document.querySelectorAll('.brand-item');

    brandItems.forEach(item => {
    const brandName = item.querySelector('.brand-name').textContent.toLowerCase();
    const brandNameEng = item.querySelector('.brand-name-eng').textContent.toLowerCase();

    if (brandName.includes(searchTerm) || brandNameEng.includes(searchTerm)) {
    item.style.display = 'flex';
} else {
    item.style.display = 'none';
}
});
});

    // 좋아요 버튼 클릭 이벤트
    document.addEventListener('click', function(e) {
    if (e.target.classList.contains('like-btn')) {
    e.preventDefault();
    e.stopPropagation();

    if (e.target.textContent === '♡') {
    e.target.textContent = '♥';
    e.target.style.color = '#e74c3c';
} else {
    e.target.textContent = '♡';
    e.target.style.color = '#ccc';
}
}
});

    // 카테고리 아이템 클릭 이벤트
    document.addEventListener('click', function(e) {
    if (e.target.closest('.category-item')) {
    const categoryName = e.target.closest('.category-item').querySelector('.category-name').textContent;
    alert('선택된 카테고리: ' + categoryName);
    closeSidebarFunc();
}

    if (e.target.closest('.brand-item') && !e.target.classList.contains('like-btn')) {
    const brandName = e.target.closest('.brand-item').querySelector('.brand-name').textContent;
    alert('선택된 브랜드: ' + brandName);
    closeSidebarFunc();
}
});

    // ESC 키로 사이드바 닫기
    document.addEventListener('keydown', function(e) {
    if (e.key === 'Escape' && sidebar.classList.contains('open')) {
    closeSidebarFunc();
}
});

    // 상품 카드 호버 효과 제거됨 - 관련 코드 삭제
