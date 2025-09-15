/**
  1. `shipments` - 배송
2. `shipping_statuses` - 배송 상태
3. `shipping_request_types` - 배송 요청 타입
4. `shipping_fees` - 배송비
5. `shipping_fee_conditions` - 배송비 조건
6. `shipping_fee_policies` - 배송비 정책
7. `product_shipping_status` - 상품 배송 상태
8. `coupons` - 쿠폰
9. `coupon_conditions` - 쿠폰 조건
10. `coupon_discount_rules` - 쿠폰 할인 규칙
11. `coupon_types` - 쿠폰 타입**/

-- `shipments` - 배송
CREATE TABLE shipments(
    Shipping_id NUMBER(10) not null, -- 배송id
    scheduled_delivery_information_id NUMBER(10) not null,
    shipping_request_type_id number(10) not null,
    shipping_statuses_id number(10) not null,
    shipping_inquiry varchar2(100) null,
    recipient_name varchar2(100) not null,
    recipient_phone varchar2(20) not null,
    recipient_address varchar2(300) null,
    shipping_direct_request varchar2(500) null,
    postal_code varchar2(20) not null,
    created_at timestamp,
    updated_at timestamp,

    constraint PK_shipments_Shipping_id PRIMARY KEY (Shipping_id),
    constraint FK_shipments_scheduled_delivery_information_id foreign key (scheduled_delivery_information_id) references scheduled_delivery_informations(scheduled_delivery_information_id),
    constraint FK_shipments_shipping_request_type_id foreign key (shipping_request_type_id) references shipping_request_types(shipping_request_type_id),
    constraint FK_shipments_shipping_statuses_id foreign key (shipping_statuses_id) references shipping_statuses(shipping_statuses_id)
);

--shipping_statuses - 배송 상태
create table shipping_statuses(
    shipping_statuses_id number(10) not null ,
    status varchar2(50) not null,
    hub_name	varchar2(100)	NULL,
    hub_status	varchar2(50)	NULL,
    arrival_time	TIMESTAMP	NULL,
    departure_time	TIMESTAMP	NULL,
    created_at	TIMESTAMP	NULL,
    updated_at	TIMESTAMP	NULL,

    constraint PK_shipping_statuses_shipping_statuses_id PRIMARY KEY (shipping_statuses_id)


);

--shipping_request_types - 배송 요청 타입
create table shipping_request_types(
    shipping_request_type_id number(10) not null,
    shipping_request_type varchar2(50) null,

    constraint PK_shipping_request_types_shipping_request_type_id PRIMARY KEY (shipping_request_type_id)


);

--shipping_fees - 배송비
create table shipping_fees(
    shipping_fee_id number(10) not null,
    fee_amount number(10) not null,
    created_at timestamp null,
    updated_at timestamp null,

    -- pk 설정
    constraint PK_shipping_fees_shipping_fee_id PRIMARY KEY (shipping_fee_id)

);

--shipping_fee_conditions - 배송비 조건
create table shipping_fee_conditions(
    shipping_fee_conditions_id number(10) not null,
    condition_name varchar2(100) not null,
    created_at timestamp null,
    updated_at timestamp null,

    -- PK 설정
    constraint PK_shipping_fee_conditions_shipping_fee_conditions_id PRIMARY KEY (shipping_fee_conditions_id)

);

--shipping_fee_policies - 배송비 정책
create table shipping_fee_policies(
    shipping_fee_policy_id number(10) not null,
    shipping_fee_id number(10) not null,
    shipping_conditions_id number(10) not null,
    brand_id number(10) not null,

    constraint PK_shipping_fee_policies_shipping_fee_policy_id PRIMARY KEY (shipping_fee_policy_id),
    constraint FK_shipping_fee_policies_shipping_fee_id foreign key (shipping_fee_id) references shipping_fees(shipping_fee_id),
    constraint FK_shipping_fee_policies_shipping_conditions_id foreign key (shipping_conditions_id) references shipping_fee_conditions(shipping_fee_conditions_id),
    constraint FK_shipping_fee_policies_brand_id foreign key (brand_id) references brands(brand_id)
);

--product_shipping_status - 상품 배송 상태
create table product_shipping_status(
    product_shipping_status_id number(10) not null,
    shipping_statuses_id number(10) not null,
    order_item_id number(10) not null,
    track_number varchar2(100) null,

    constraint PK_product_shipping_status_product_shipping_status_id PRIMARY KEY (product_shipping_status_id),
    constraint FK_product_shipping_status_shipping_statuses_id foreign key (shipping_statuses_id) references shipping_statuses(shipping_statuses_id),
    constraint FK_product_shipping_status_order_item_id foreign key (order_item_id) references order_items(order_item_id)

);

--coupons - 쿠폰
create table coupons(
    coupon_id number(10) not null,
    user_id number(10) not null,
    brand_id number(10) not null,
    coupon_name varchar2(20) not null,
    coupon_code varchar2(30) not null,
    description varchar2(50) null,
    start_date date not null,
    end_date date not null,
    is_stackable char(1) not null,
    created_at timestamp not null ,
    updated_at timestamp null,

    constraint PK_coupons_coupon_id PRIMARY KEY (coupon_id),
    constraint FK_coupons_user_id foreign key (user_id) references users(user_id),
    constraint FK_coupons_brand_id foreign key (brand_id) references brands(brand_id)

);

--coupon_conditions - 쿠폰 조건
create table coupon_conditions(
    coupon_condition_id number(10) not null,
    grade_id number(10) not null,
    user_id number(10) not null,
    coupon_id number(10) not null,
    condition_type  number(10) not null,
    min_purchase_amount number(5) null,
    min_quantity number(5) null,
    min_product_count number(5) null,
    created_time timestamp null,
    updated_time timestamp null,

    constraint PK_coupon_conditions_id primary key (coupon_condition_id),
    constraint FK_coupon_conditions_grade_id foreign key (grade_id) references grades(grade_id),
    constraint FK_coupon_conditions_user_id foreign key (user_id) references users(user_id),
    constraint FK_coupon_conditions_coupon_id foreign key (coupon_id) references coupons(coupon_id)

);

--coupon_discount_rules - 쿠폰 할인 규칙
create table coupon_discount_rules(
    coupon_discount_rule_id number(10) not null,
    coupon_id number(10) not null,
    user_id number(10) not null,
    discount_percent number(5) null,
    discount_amount number(10) null,
    max_discount_amt number(10) null,
    created_time timestamp null,
    updated_time timestamp null,

    constraint PK_coupon_discount_rule_id primary key (coupon_discount_rule_id),
    constraint FK_coupon_discount_coupon_id foreign key (coupon_id) references coupons(coupon_id),
    constraint FK_coupon_discount_user_id foreign key (user_id) references users(user_id)




);

--coupon_types - 쿠폰 타입
create table coupon_types(
    coupon_type_id number(10) not null,
    coupon_id number(10) not null,
    user_id number(10) not null,
    type_code varchar2(20) not null,
    type_name varchar2(20) not null,
    apply_scope varchar2(20) not null,
    discount_type varchar2(10) not null,
    created_at timestamp null,
    updated_at timestamp null,

    constraint PK_coupon_types_coupon_type_id primary key (coupon_type_id),
    constraint FK_coupon_types_coupon_coupon_id foreign key (coupon_id) references coupons(coupon_id),
    constraint FK_coupon_types_coupon_user_id foreign key (user_id) references users(user_id)



);

