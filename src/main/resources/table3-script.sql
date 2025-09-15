create table brands(
       brand_id number(10) not null,
       brand_name_kr varchar2(50) not null,
       brand_name_eng varchar2(50) not null,
       brand_image varchar2(200),
       brand_likes number(5),
       brand_info	VARCHAR2(200)	NULL,
       brand_born	VARCHAR2(4)	NULL,
       brand_first_letter_kr VARCHAR2(1) NOT NULL,

    constraint pk_brands primary key (brand_id)

);

create table brand_categories(
    brand_category_id number(10) not null,
    category_name varchar2(50) not null,

    constraint pk_brand_categories primary key(brand_category_id)
);

create table brand_has_categories(
    brand_has_category_id number(10) not null,
    brand_category_id number(10) not null,
    brand_id number(10) not null,

    constraint pk_brand_has_categories primary key (brand_has_category_id),
    constraint fk_brands_to_brand_has_categories foreign key (brand_id) references brands(brand_id) on delete cascade,
    constraint fk_brand_categories_to_brand_has_categories foreign key (brand_category_id) references brand_categories(brand_category_id) on delete cascade

);

create table national_infos(
    national_info_id number(10) not null,
    nation_image varchar2(500),
    national_name varchar2(50),
    constraint pk_national_info primary key (national_info_id)
);

create table advertisements(
    advertisement_id number(10) not null ,
    brand_id number(10) not null ,
    advertisement_price number(10) not null ,

    constraint pk_advertisement primary key(advertisement_id),
    constraint fk_brands_to_advertisement foreign key(brand_id) references brands(brand_id)

);

CREATE TABLE event_hashtags(
    event_hashtag_id number(10)	not null,
    hashtag_name	varchar2(50) not null,
    hashtag_image_url varchar2(50) not null,
    event_startDate	timestamp null,
    event_endDate	timestamp null,

    constraint pk_event_hashTag primary key(event_hashtag_id)
);


CREATE TABLE product_has_events (
    product_id number(10) not null,
    event_hashtag_id number(10) not null,
    constraint pk_product_has_events primary key (product_id, event_hashtag_id),
    constraint fk_product_has_events_product FOREIGN KEY (product_id) REFERENCES products(product_id),
    constraint fk_product_has_events_event FOREIGN KEY (event_hashtag_id) REFERENCES event_hashtags(event_hashtag_id)
);


CREATE TABLE courier_companies (
    courier_company_id NUMBER(10) NOT NULL,
    brand_id NUMBER(10)	NOT NULL,
    courier_company_name VARCHAR2(50),

    constraint pk_courier_companies primary key (courier_company_id),
    constraint fk_brands_to_courier_companies foreign key(courier_company_id) references brands(brand_id)
);

CREATE TABLE notice (
    notice_id NUMBER NOT NULL,
    title VARCHAR2(200)	NOT NULL,
    content	VARCHAR2(200) NOT NULL

);

CREATE TABLE qna (
    qna_id	VARCHAR(255)	NOT NULL,
    question VARCHAR2(200)	NOT NULL,
    answer VARCHAR2(200)
);

CREATE TABLE inquiry_types (
    inquiry_type_id NUMBER(10) NOT NULL,
    user_inquiry_id NUMBER(10) NOT NULL,
    type_name VARCHAR2(30) NOT NULL,
    constraint pk_inquiry_types primary key(inquiry_type_id),
    constraint fk_user_inquiries_to_inquiry_types foreign key(user_inquiry_id) references user_inquiries(user_inquiry_id)
);