--products - 상품 기본 정보
create table products(
    product_id NUMBER(10) PRIMARY KEY,
    brand_id NUMBER(10) NOT NULL,
    product_category_id NUMBER(10) NOT NULL,
    product_name VARCHAR2(50),
    price NUMBER(10) CHECK (price > 0),
    product_likes NUMBER(5) DEFAULT 0,
    FOREIGN KEY (brand_id) REFERENCES brands(brand_id),
    FOREIGN KEY (product_category_id) REFERENCES product_categories(product_category_id)
);

--product_option_types - 상품 옵션
create table product_option_types(
    product_option_id NUMBER(10) PRIMARY KEY,
    product_id NUMBER(10) NOT NULL,
    option_type_id NUMBER(10) NOT NULL,
    display_order NUMBER(3) CHECK (display_order > 0),
    FOREIGN KEY (product_id) REFERENCES products(product_id),
    FOREIGN KEY (option_type_id) REFERENCES option_types(option_type_id)
);

--option_types - 옵션 타입
create table option_types(
    option_type_id NUMBER(10) PRIMARY KEY,
    option_type VARCHAR2(200),
    option_type_display NUMBER(3) CHECK (option_type_display > 0)
);

--product_variants - 상품 변형/SKU 테이블
create table product_variants(
    product_variant_Id NUMBER(10) PRIMARY KEY,
    product_id NUMBER(10) NOT NULL,
    sku_code VARCHAR2(50),
    variant_name VARCHAR2(100),
    price NUMBER(10),
    stock_quantity NUMBER(10),
    size_value VARCHAR2(20),
    color_value VARCHAR2(20),
    material_value VARCHAR2(50),
    extra_price NUMBER(10),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

--product_images - 상품이미지(메인,서브,상세페이지) 목록
create table product_images(
    product_image_id NUMBER(10) PRIMARY KEY,
    product_id NUMBER(10) NOT NULL,
    image_type VARCHAR2(200) CHECK(image_type IN ('MAIN', 'SUB', 'DETAIL')),
    image_url VARCHAR2(200),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

--product_categories - 상품 카테고리
create table product_categories(
    product_category_id NUMBER(10) PRIMARY KEY,
    parent_product_category_id NUMBER(10),
    category_name VARCHAR2(200),
    category_image VARCHAR2(200),
    FOREIGN KEY (parent_product_category_id) REFERENCES product_categories(product_category_id)
);

--product_connection_tags - 상품 연관 태그
create table product_connection_tags(
    product_connection_tag_id NUMBER(10) PRIMARY KEY,
    product_id NUMBER(10) NOT NULL,
    tag_name VARCHAR2(200),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

--product_inquiries - 상품 문의
create table product_inquiries(
    product_inquiry_id NUMBER(10) PRIMARY KEY,
    product_id NUMBER(10) NOT NULL,
    user_id NUMBER(10) NOT NULL,
    inquiry_type VARCHAR2(50) CHECK(inquiry_type IN ('상품문의', '배송문의', '교환/환불', '기타')),
    title VARCHAR2(200),
    answer_state VARCHAR2(200) CHECK (answer_state IN ('대기중', '답변완료', '처리중', '보류')),
    nickname VARCHAR2(200),
    content VARCHAR2(200),
    FOREIGN KEY (product_id) REFERENCES products(product_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

--product_inquiry_images - 상품문의 이미지 목록
create table product_inquiry_images(
    product_inquiry_image_id NUMBER(10) PRIMARY KEY,
    product_inquiry_id NUMBER(10) NOT NULL,
    image_url VARCHAR2(200),
    FOREIGN KEY (product_inquiry_id) REFERENCES product_inquiries(product_inquiry_id)
);

--product_inquiry_answers - 상품문의 답변
create table product_inquiry_answers(
    product_inquiry_answer_id NUMBER(10) PRIMARY KEY,
    product_inquiry_id NUMBER(10) NOT NULL,
    manager_name VARCHAR2(200),
    content CLOB,
    FOREIGN KEY (product_inquiry_id) REFERENCES product_inquiries(product_inquiry_id)
);

