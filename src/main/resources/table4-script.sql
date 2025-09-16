-- 사용자 테이블
CREATE TABLE user
(
    user_id       NUMBER(10) NOT NULL,     -- 사용자 고유 ID
    user_name     VARCHAR2(20) NULL,
    nickname      VARCHAR2(20) NOT NULL,
    gender        VARCHAR2(10) NULL,
    birthday      DATE NULL,
    social_id     VARCHAR2(20) NULL,
    social_type   VARCHAR2(2) NOT NULL,
    active_status VARCHAR2(20) NULL,
    inactive_time TIMESTAMP NULL,
    user_mileage  NUMBER(10) NULL,
    is_member     VARCHAR2(1) DEFAULT 'Y', -- Y/N 플래그로 변경

    -- 기본키
    CONSTRAINT PK_USER PRIMARY KEY (user_id)
);

-- 사용자 배송지 테이블
CREATE TABLE user_address
(
    user_address_id NUMBER(10) NOT NULL,    -- 주소 고유 ID(기본키)
    user_id         NUMBER(10) NOT NULL,    -- 사용자 ID (외래키)
    address_name    VARCHAR2(50) NULL,      -- 주소 명칭
    recipient_name  VARCHAR2(20) NOT NULL,  -- 수령인 이름
    phone_number    VARCHAR2(50) NOT NULL,  -- 연락처
    is_default      NUMBER(1) DEFAULT 0,    -- 기본 배송지 여부
    is_recent       NUMBER(1) DEFAULT 0,    -- 최근사용여부
    address_line1   VARCHAR2(200) NOT NULL, -- 기본 주소
    address_line2   VARCHAR2(200) NULL,     -- 상세 주소

    -- 기본키 설정
    CONSTRAINT PK_USER_ADDRESS PRIMARY KEY (user_address_id),

    -- 외래키 설정(일대다 관계의 핵심)
    CONSTRAINT FK_USER_TO_USER_ADDRESS FOREIGN KEY (user_id)
        REFERENCES user (user_id)
        ON DELETE CASCADE                   -- 사용자 삭제시 주소 테이블도
);

-- 회원 적립 내역 테이블
CREATE TABLE user_mileage_history
(
    user_mileage_id      NUMBER(10) NOT NULL,
    user_id              NUMBER(10) NOT NULL,
    order_item_id        NUMBER(10) NOT NULL,
    user_mileage_type_id NUMBER(10) NOT NULL,
    amount               NUMBER(10) NULL,
    transaction_type     VARCHAR2(40) NULL,
    expires_at           TIMESTAMP NULL,
    earned_at            TIMESTAMP NULL,

    -- 기본키 설정
    CONSTRAINT PK_USER_MILEAGE_HISTORY PRIMARY KEY (user_mileage_id),

    -- 외래키 설정(일대다 관계의 핵심)
    CONSTRAINT FK_UMH_USER FOREIGN KEY (user_id)
        REFERENCES user (user_id)
        ON DELETE CASCADE, -- 사용자 삭제시 주소 테이블도
    CONSTRAINT FK_UMH_ORDER FOREIGN KEY (order_item_id)
        REFERENCES order_items (order_item_id),
    CONSTRAINT FK_UMH_TYPE FOREIGN KEY (user_mileage_type_id)
        REFERENCES user_mileage_types (user_mileage_type_id)
);

-- 유저 마일리지 종류(적립, 사용)
CREATE TABLE user_mileage_types
(
    user_mileage_type_id NUMBER(10) NOT NULL,
    mileage_type         VARCHAR2(50) NULL,

    -- 기본키 설정
    CONSTRAINT PK_USER_MILEAGE_TYPES PRIMARY KEY (user_mileage_type_id)
);

-- 은행이름 리스트
CREATE TABLE bank_name_list
(
    bank_name_list_id NUMBER(10) NOT NULL,
    bank_name         VARCHAR2(50) NULL

    -- 기본키 설정
    CONSTRAINT PK_BANK_NAME_LIST PRIMARY KEY (bank_name_list_id)
);


-- 환불계좌
CREATE TABLE user_bank_refund_account
(
    user_bank_refund_account_id NUMBER(10) NOT NULL,
    user_id                     NUMBER(10) NOT NULL,
    bank_name_list_id           NUMBER(10) NOT NULL,
    user_bank_refund_account    VARCHAR2(50) NOT NULL,

    -- 기본키 설정
    CONSTRAINT PK_USER_BANK_REFUND_ACCOUNT PRIMARY KEY (user_bank_refund_account_id),

    -- 외래키 설정
    CONSTRAINT FK_UBRA_USER FOREIGN KEY (user_id)
        REFERENCES user(user_id)
        ON DELETE CASCADE,
    CONSTRAINT FK_UBRA_BANK_NAME_LIST FOREIGN KEY (bank_name_list_id)
        REFERENCES bank_name_list (bank_name_list_id)
);

-- 회원 등급
CREATE TABLE user_grades
(
    grade_id   NUMBER(10) NOT NULL,
    user_id    NUMBER(10) NOT NULL,
    grade_name VARCHAR2(20) NULL,
    grade_code VARCHAR2(10) NULL,
    min_amount NUMBER(10) NULL,
    max_amount NUMBER(10) NULL,

    -- 기본키 설정
    CONSTRAINT PK_USER_GRADES PRIMARY KEY (grade_id),

    -- 외래키 설정
    CONSTRAINT FK_UG_USER FOREIGN KEY (user_id)
        REFERENCES user (user_id)
        ON DELETE CASCADE
);

-- 1:1 문의 테이블
CREATE TABLE user_inquiries
(
    user_inquiries_id     NUMBER(10) NOT NULL,
    user_id               NUMBER(10) NOT NULL,
    title                 VARCHAR2(200) NULL,
    content               CLOB NULL,
    inquiries_status      VARCHAR2(30) NULL,
    inquiry_number        VARCHAR2(30) NULL,
    response_completed_at TIMESTAMP NULL

    -- 기본키
    CONSTRAINT PK_USER_INQUIRIES PRIMARY KEY (user_inquiries_id),

    -- 외래키
    CONSTRAINT FK_UI_USER FOREIGN KEY (user_id)
        REFERENCES user (user_id)
        ON DELETE CASCADE
);

-- 1:1 문의 이미지
CREATE TABLE user_inquiries_images
(
    user_inquiries_images_id NUMBER(10) NOT NULL,
    user_inquiries_id        NUMBER(10) NOT NULL,
    image_url                VARCHAR2(200) NULL,

    -- 기본키
    CONSTRAINT PK_USER_INQUIRIES_IMAGES PRIMARY KEY (user_inquiries_images_id),

    -- 외래키
    CONSTRAINT FK_UII_USER_INQUIRIES_ID FOREIGN KEY (user_inquiries_id)
        REFERENCES user_inquiries (user_inquiries_id)
        ON DELETE CASCADE
);

-- 문의 대분류
CREATE TABLE inquiry_types
(
    inquiry_types_id NUMBER(10) NOT NULL,
    user_inquiry_id  NUMBER(10) NOT NULL,
    type_name        VARCHAR2(30) NULL,

    -- 기본키
    CONSTRAINT PK_INQUIRY_TYPES PRIMARY KEY (inquiry_types_id),

    -- 외래키
    CONSTRAINT FK_IT_USER_INQUIRIES FOREIGN KEY (user_inquiry_id)
        REFERENCES user_inquiries (user_inquiry_id)
        ON DELETE CASCADE
);

-- 문의 세부 유형
CREATE TABLE inquiry_subtypes
(
    inquiry_subtypes_id NUMBER(10) NOT NULL,
    inquiry_type_id     NUMBER(10) NOT NULL,
    subtype_name        VARCHAR2(30) NULL,

    -- 기본키
    CONSTRAINT PK_INQUIRY_SUBTYPES PRIMARY KEY (inquiry_subtypes_id),

    -- 외래키
    CONSTRAINT FK_IS_INQURIY_TYPE FOREIGN KEY (inquiry_type_id)
        REFERENCES inquiry_types (inquiry_type_id)
        ON DELETE CASCADE

);

-- 회원_쿠폰
CREATE TABLE user_coupons
(
    user_coupon_id NUMBER(10) NOT NULL,
    user_id        NUMBER(10) NOT NULL,

    -- 기본키
    CONSTRAINT PK_USER_COUPONS PRIMARY KEY (user_coupon_id),

    -- 외래키
    CONSTRAINT FK_UC_USER FOREIGN KEY (user_id)
        REFERENCES user (user_id)
        ON DELETE CASCADE
);

-- 유저 프로필 이미지
CREATE TABLE user_profile_image
(
    user_profile_image_id NUMBER(10) NOT NULL,
    user_id               NUMBER(10) NOT NULL,
    profile_image_url     VARCHAR2(500) NULL,

    -- 기본키
    CONSTRAINT PK_USER_PROFILE_IMAGE PRIMARY KEY (user_profile_image_id),

    -- 외래키
    CONSTRAINT FK_UPI_USER FOREIGN KEY (user_id)
        REFERENCES user (user_id)
        ON DELETE CASCADE
);

-- 회원 신체 정보
CREATE TABLE user_physical_info
(
    user_physical_info_id NUMBER(10) NOT NULL,
    user_id               NUMBER(10) NOT NULL,
    height                NUMBER(3) NULL,
    weight                NUMBER(3) NULL,

    -- 기본키
    CONSTRAINT PK_USER_PHYSICAL_INFO PRIMARY KEY (user_physical_info_id),

    -- 외래키
    CONSTRAINT FK_UPIFO_USER FOREIGN KEY (user_id)
        REFERENCES user (user_id)
        ON DELETE CASCADE
);

