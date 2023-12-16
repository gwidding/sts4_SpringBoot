use audio_mart;

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
    
    ,FOREIGN KEY (cate_id) REFERENCES category(cate_id)
);

create table category (
	cate_id integer not null auto_increment primary key
    , catename varchar(50) not null
);

-- alter table category rename column cateid to cate_id; 

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







