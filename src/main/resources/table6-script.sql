--사용자 테이블 생성
--reviews
CREATE TABLE reviews(
    review_id	NUMBER(10)		NOT NULL,
    product_id	NUMBER(10)		NOT NULL,
    user_id	NUMBER(10)		NOT NULL,
    nickname	VARCHAR2(20),
    content	VARCHAR2(200),
    purchase_options	VARCHAR2(50),
    help_count	NUMBER(10),

    CONSTRAINT PK_reviews PRIMARY KEY (review_id),
    CONSTRAINT FK_reviews_product FOREIGN KEY (product_id) REFERENCES products(product_id),
    CONSTRAINT FK_reviews_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE review_images(
    review_image_id NUMBER(10) NOT NULL,
    review_id NUMBER(10) NOT NULL,
    image_url VARCHAR2(200),

    CONSTRAINT PK_review_images PRIMARY KEY (review_image_id),
    CONSTRAINT FK_review_images_review FOREIGN KEY (review_id) REFERENCES reviews(review_id)
);

CREATE TABLE product_review_stats(
    product_rating_stats_id NUMBER(10) NOT NULL,
    review_id NUMBER(10) NOT NULL,
    review_count NUMBER(10) NULL,
    total_reviews NUMBER(10) NULL,
    rating_avg NUMBER(10) NULL,

    CONSTRAINT PK_product_review_stats PRIMARY KEY (product_rating_stats_id),
    CONSTRAINT FK_product_review_stats_review FOREIGN KEY (review_id) REFERENCES reviews(review_id),
    CHECK (rating_avg BETWEEN 0 AND 5)

);

CREATE TABLE comments(
    comment_id NUMBER(10) NOT NULL,
    review_id NUMBER(10) NOT NULL,
    nickname VARCHAR2(20) NULL,
    content VARCHAR2(200) NULL,

    CONSTRAINT PK_comments PRIMARY KEY (comment_id),
    CONSTRAINT FK_comments_review FOREIGN KEY (review_id) REFERENCES reviews(review_id)


);

CREATE TABLE user_product_like(
    user_product_like_id	NUMBER(10)		NOT NULL,
    user_id	NUMBER(10)		NOT NULL,
    product_id	NUMBER(10)		NOT NULL,

    CONSTRAINT PK_user_product_like PRIMARY KEY (user_product_like_id),
    CONSTRAINT FK_user_product_like_user FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT FK_user_product_like_product FOREIGN KEY (product_id) REFERENCES products(product_id)
);




CREATE TABLE user_brand_like(
    user_brand_like_id NUMBER(19) NOT NULL,
    brand_id NUMBER(10) NOT NULL,
    user_id NUMBER(10) NOT NULL,
    CONSTRAINT PK_user_brand_like PRIMARY KEY (user_brand_like_id),
    CONSTRAINT FK_user_brand_like_user FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT FK_user_brand_like_brand FOREIGN KEY (brand_id) REFERENCES brands(brand_id)



);

CREATE TABLE product_likes(
    product_like_id NUMBER(10) NOT NULL,
    user_id NUMBER(10) NOT NULL,
    product_id NUMBER(10) NOT NULL,
    CONSTRAINT PK_product_likes PRIMARY KEY (product_like_id),
    CONSTRAINT FK_product_likes_user FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT FK_product_likes_product FOREIGN KEY (product_id) REFERENCES products(product_id)


);

CREATE TABLE product_view_logs(
    product_view_log_id NUMBER(10) NOT NULL,
    product_id NUMBER(10) NOT NULL,
    view_at TIMESTAMP,
    product_view_type VARCHAR2(50),
    user_id NUMBER(10) NULL, //user_id 비식별 관계 - 비회원도 조회 로그 접근 가능이므로, NULL 하용, FK 제거
    CONSTRAINT PK_product_view_logs PRIMARY KEY (product_view_log_id),

);

CREATE TABLE recent_product_view_history(
    recent_product_view_history_id NUMBER(10) NOT NULL,
    user_id NUMBER(10) NOT NULL,
    product_id NUMBER(10) NOT NULL,
    view_time TIMESTAMP,
    CONSTRAINT PK_recent_product_view_history PRIMARY KEY (recent_product_view_history_id),
    CONSTRAINT FK_recent_view_user FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT FK_recent_view_product FOREIGN KEY (product_id) REFERENCES products(product_id)


);

CREATE TABLE search_keywords(
    search_keyword_id NUMBER(10) NOT NULL,
    keyword VARCHAR2(50) NOT NULL,
    keyword_initial VARCHAR2(20) NOT NULL,
    daily_count NUMBER(10) NOT NULL,
    current_hour_search_count NUMBER(10) NOT NULL,
    growth_rate NUMBER(10,2),
    is_trending VARCHAR2(1),
    CONSTRAINT PK_search_keywords PRIMARY KEY (search_keyword_id)

);

CREATE TABLE search_log(
    search_log_id NUMBER(10) NOT NULL,
    search_text VARCHAR2(50),
    search_datetime TIMESTAMP,
    search_count NUMBER(10),
    user_id NUMBER(10),
    CONSTRAINT PK_search_log PRIMARY KEY (search_log_id),
    CONSTRAINT FK_search_log_user FOREIGN KEY (user_id) REFERENCES users(user_id)


);
--created_at, updated_at 제외 가능
--CONSTRAINT
--review_images
--product_review_stats
--comments
--user
--5. `user_product_like` - 사용자 상품 좋아요
--6. `user_brand_like` - 사용자 브랜드 좋아요
--7. `product_likes` - 상품 좋아요
--8. `product_view_logs` - 상품 조회 로그
--9. `recent_product_view_history` - 최근 상품 조회 이력
--10. `search_keywords` - 검색 키워드
--11. `search_log` - 검색 로그

