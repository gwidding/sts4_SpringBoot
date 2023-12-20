use audio_mart;

create table category (
	cate_id integer not null auto_increment primary key
    , cate_name varchar(50) not null
);

create table product (
	product_id integer not null auto_increment primary key
    , cate_id integer not null
    , pname varchar(50) not null
    , pprice integer not null
    , stock integer not null default 0
    , description varchar(500) null
    , img1 varchar(200) null
    , img2 varchar(200) null
    , img3 varchar(200) null
    , order_cnt integer not null default 0
    , view_cnt integer not null default 0
    , register_date datetime not null default NOW()
    , delete_yn ENUM('Y','N') DEFAULT 'N' NOT NULL
    , delete_date datetime null
    , update_date datetime null
    
    ,FOREIGN KEY (cate_id) REFERENCES category(cate_id)
);

ALTER TABLE product MODIFY COLUMN delete_yn ENUM('Y','N') DEFAULT 'N' NOT NULL;
alter table product Add column update_date datetime null;
-- alter table category rename column cateName to cate_name;

create table orders (
	order_id integer not null auto_increment primary key
    , idx integer not null
    , price integer not null
    , payment_method ENUM('CreditCard', 'BankTransfer', 'Pay')
    , order_notes varchar(25) not null
    , order_date datetime not null default NOW()
    , update_date datetime null
    , order_status ENUM('NORMAL', 'REFUND', 'EXCHANGE') not null default 'NORMAL'
);

create table orderDetail (
	order_detail_id integer not null auto_increment primary key
    , order_id integer not null
    , product_id integer not null
    , quantity integer not null default 1
    
    ,FOREIGN KEY (order_id) REFERENCES orders(order_id)
    ,FOREIGN KEY (product_id) REFERENCES product(product_id)
);

insert into category (cate_name) values ('이어폰');
insert into category (cate_name) values ('헤드셋');
insert into category (cate_name) values ('스피커');
insert into category (cate_name) values ('마이크');
insert into category (cate_name) values ('액세서리');

select * from category;
select * from product;


