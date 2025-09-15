CREATE TABLE orders (
    order_id	            NUMBER(10)	PRIMARY KEY NOT NULL,
    user_id	                NUMBER(10)	NOT NULL,
    user_address_id	        NUMBER(10)	NOT NULL,
    shipping_id	            NUMBER(10)	NOT NULL,
    order_number	        NUMBER(20),
    total_price	            NUMBER(10)  CHECK (total_price >= 0),
    order_discount_amount	NUMBER(10),
    final_price	            NUMBER(10)  CHECK (final_price >= 0),
    order_status	        VARCHAR2(30),
    payment_method_id	    NUMBER(10)	NOT NULL,

    CONSTRAINT fk_orders_user
        FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT fk_orders_user_address
        FOREIGN KEY (user_address_id) REFERENCES user_address(user_address_id),
    CONSTRAINT fk_orders_shipments
        FOREIGN KEY (shipping_id) REFERENCES shipping(shipping_id),
    CONSTRAINT fk_orders_payment_method
        FOREIGN KEY (payment_method_id) REFERENCES payment_method(payment_method_id)
);

CREATE TABLE order_items (
    order_item_id           NUMBER(10) PRIMARY KEY NOT NULL,
    product_id              NUMBER(10)     NOT NULL,
    coupon_id               NUMBER(10)     NOT NULL,
    order_id                NUMBER(10)     NOT NULL,
    quantity                NUMBER(10),
    unit_price              NUMBER(10)  CHECK (unit_price > 0),
    total_price             NUMBER(10)  CHECK (total_price > 0),

    CONSTRAINT fk_order_items_products
                         FOREIGN KEY (product_id) REFERENCES products(product_id),
    CONSTRAINT fk_order_items_coupons
                         FOREIGN KEY (coupon_id) REFERENCES coupons(coupon_id),
    CONSTRAINT fk_order_items_orders
                         FOREIGN KEY (order_id) REFERENCES orders(order_id)
);

CREATE TABLE order_cancellation_return_exchanges (
     order_cancellation_return_exchange_id	NUMBER(10)	PRIMARY KEY 		NOT NULL,
     order_item_id	                        NUMBER(10)		NOT NULL,
     cancellation_return_exchange_reason	VARCHAR2(200),
     return_method	                        VARCHAR2(30),
     return_pickup_location	                VARCHAR2(30),
     return_destination	                    VARCHAR2(30),
     return_shipping_fee	                NUMBER(10),
     return_date	                        TIMESTAMP,
     exchange_method	                    VARCHAR2(30),
     exchange_pickup_location	            VARCHAR2(30),
     exchange_destination	                VARCHAR2(30),
     exchange_shipping_fee	                NUMBER(10)  CHECK ( exchange_shipping_fee >= 0),
     cancellation_return_exchange_status	VARCHAR2(30) CHECK ( cancellation_return_exchange_status IN ('요청', '승인', '거절', '환불 처리', '상품 회수', '환불', '새 상품 발송', '완료')),
     return_carrier	                        VARCHAR2(30),
     return_tracking_number	                VARCHAR2(30),
     reshipment_carrier	                    VARCHAR2(30),
     reship_tracking_number	                VARCHAR2(30),
     refund_method	                        VARCHAR2(30),
     refund_status	                        VARCHAR2(30) CHECK(refund_status IN ('환불요청', '승인', '거절', '환불진행', '환불완료', '환불실패')),
     notices_id	                            VARCHAR2(30),
     completion_date	                    TIMESTAMP,

     CONSTRAINT fk_order_cancellation_return_exchanges_order_items
                            FOREIGN KEY (order_item_id) REFERENCES order_items(order_item_id)
);

CREATE TABLE user_carts (
    user_cart_id            NUMBER(10) PRIMARY KEY NOT NULL,
    user_id                 NUMBER(10) NOT NULL,
    product_id              NUMBER(10) NOT NULL,
    cart_quantity           NUMBER(10)  CHECK ( cart_quantity > 0),
    cart_option             VARCHAR2(200),
    cart_status             VARCHAR2(200),

    CONSTRAINT fk_user_carts_users
                            FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT fk_user_carts_products
                        FOREIGN KEY (product_id) REFERENCES products(product_id)
);

CREATE TABLE sale_records (
    sales_record_id         NUMBER(10) PRIMARY KEY NOT NULL,
    order_item_id           NUMBER(10) NOT NULL,
    user_id                 NUMBER(10) NOT NULL,
    quantity                NUMBER(10)  CHECK (quantity > 0),
    sale_price              NUMBER(10)  CHECK (sale_price > 0),
    sale_date               TIMESTAMP,

    CONSTRAINT fk_sale_records_order_items
                        FOREIGN KEY (order_item_id) REFERENCES order_items(order_item_id),
    CONSTRAINT fk_sale_records_user_id
                          FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE payment_methods (
    payment_method_id       NUMBER(10) PRIMARY KEY NOT NULL,
    payment_name            VARCHAR2(50)
);

CREATE TABLE payment_benefits (
    payment_benefit_id       NUMBER(10) PRIMARY KEY NOT NULL,
    payment_method_id       NUMBER(10) NOT NULL,
    benefit_type             VARCHAR2(10),

    CONSTRAINT fk_payment_benefits_payment_methods
                              FOREIGN KEY (payment_method_id) REFERENCES payment_methods(payment_method_id)
);

CREATE TABLE payment_companies (
    payment_company_id      NUMBER(10) PRIMARY KEY NOT NULL,
    payment_benefit_id      NUMBER(10) NOT NULL,
    name                    VARCHAR2(50),

    CONSTRAINT fk_payment_companies_payment_benefits
                               FOREIGN KEY (payment_benefit_id) REFERENCES payment_benefits(payment_benefit_id)
);

CREATE TABLE payment_company_discount_prices (
    payment_company_discount_price_id   NUMBER(10) PRIMARY KEY NOT NULL,
    payment_benefit_id                  NUMBER(10) NOT NULL,
    discount_price          NUMBER(10)  CHECK (discount_price > 0),

    CONSTRAINT fk_payment_company_discount_prices_payment_benefits
                                             FOREIGN KEY (payment_benefit_id) REFERENCES payment_benefits(payment_benefit_id)
);

CREATE TABLE payment_company_discount_contract_terms (
    payment_company_discount_contract_terms_id NUMBER(10) PRIMARY KEY NOT NULL,
    payment_benefit_id       NUMBER(10) NOT NULL,
    contract_terms_price    NUMBER(10)  CHECK (contract_terms_price > 0),

    CONSTRAINT fk_payment_company_discount_contract_terms_payment_benefits
                                            FOREIGN KEY (payment_benefit_id) REFERENCES payment_benefits(payment_benefit_id)
);

CREATE TABLE scheduled_delivery_information (
    scheduled_delivery_information_id   PRIMARY KEY NOT NULL,
    local                   VARCHAR2(20),
    expected_arrival_date   NUMBER(1)
);
