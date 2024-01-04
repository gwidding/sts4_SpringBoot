use audio_mart;

create table category (
	cate_id int not null auto_increment primary key
    , cate_name varchar(50) not null
);

create table product (
	product_id int not null auto_increment primary key
    , cate_id int not null
    , pname varchar(50) not null
    , pprice int not null
    , stock int not null default 0
    , description varchar(500) null
    , order_cnt int not null default 0
    , view_cnt int not null default 0
    , register_date datetime not null default NOW()
    , delete_yn ENUM('Y','N') DEFAULT 'N' NOT NULL
    , delete_date datetime null
    , update_date datetime null
    
    ,FOREIGN KEY (cate_id) REFERENCES category(cate_id)
);
alter table product add (thumbImg varchar(200) null);

create table orders (
	order_id int not null auto_increment primary key
    , member_idx int not null
    , price int not null
    , payment_method ENUM('CreditCard', 'BankTransfer', 'Pay')
    , order_notes varchar(25) not null
    , order_date datetime not null default NOW()
    , update_date datetime null
    , order_status ENUM('NORMAL', 'REFUND', 'EXCHANGE') not null default 'NORMAL'
    
    ,foreign key (member_idx) references member(idx)
);

create table orderDetail (
	order_detail_id int not null auto_increment primary key
    , order_id int not null
    , product_id int not null
    , quantity int not null default 1
    
    ,FOREIGN KEY (order_id) REFERENCES orders(order_id)
    ,FOREIGN KEY (product_id) REFERENCES product(product_id)
);
create table product_image (
	img_id int not null auto_increment primary key
    , product_id int not null
    , img_name varchar(255) not null
    , img_path varchar(255) not null
    , is_rep tinyint not null default 0
    , delete_yn ENUM('Y', 'N') not null default 'N'
    , memo varchar(500) null
);

ALTER TABLE product_image ADD CONSTRAINT `FK_product_TO_product_image_1` 
	FOREIGN KEY (product_id) REFERENCES product(product_id);

insert into category (cate_name) values ('이어폰');
insert into category (cate_name) values ('헤드셋');
insert into category (cate_name) values ('스피커');
insert into category (cate_name) values ('마이크');
insert into category (cate_name) values ('액세서리');

select * from product;

select * FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_SCHEMA = 'audio_mart';

alter table product drop column img3;
ALTER TABLE product MODIFY COLUMN delete_yn ENUM('Y','N') DEFAULT 'N' NOT NULL;
alter table product Add column update_date datetime null;
-- alter table category rename column cateName to cate_name;


select * from product_image;
