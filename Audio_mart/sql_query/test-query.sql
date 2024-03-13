select * from orders;
select * from product_image;
select * from cart;
select * from product;
select * from member;
select * from orderDetail;

desc product;
alter table product modify pname varchar(100) not null;

UPDATE product p
JOIN orderDetail od ON p.product_id = od.product_id
SET p.order_cnt = p.order_cnt + od.quantity
WHERE od.order_id = 1;

UPDATE product p
SET p.stock = 126
WHERE p.product_id = 45;

SELECT
	p.*, pi.img_path, pi.img_name, pi.is_rep, pi.delete_yn, pi.memo
FROM product p
	LEFT JOIN product_image pi ON p.product_id = pi.product_id
WHERE
	p.product_id = 2;
    
SELECT od.*
FROM orderDetail od
JOIN orders o ON od.order_id = o.order_id
WHERE o.member_idx = 1;

select * FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_SCHEMA = 'audio_mart';

alter table product drop column img3;
ALTER TABLE product MODIFY COLUMN pname varchar(200) not null;
alter table product Add column update_date datetime null;
alter table orders rename column order_notes to order_addr;

SELECT od.*, o.member_idx, p.pname, o.order_date, od.quantity * p.pprice as pAmountPrice,
				o.payment_method, o.order_addr, o.order_notes, o.order_status, o.update_date
FROM orderDetail od
	JOIN orders o ON od.order_id = o.order_id
	JOIN product p ON od.product_id = p.product_id
WHERE o.member_idx = 5;

SELECT
	product_id, p.cate_id, pname, pprice, stock, description, order_cnt, view_cnt, register_date
	, delete_yn, delete_date, update_date, c.cate_name
FROM
	product p
    join category c on p.cate_id = c.cate_id
WHERE
	product_id = 15
ORDER BY
	product_id DESC, register_date DESC;

