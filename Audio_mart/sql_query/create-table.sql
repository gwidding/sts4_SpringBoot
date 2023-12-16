use audio_mart;

create table member (
	idx integer not null auto_increment primary key
	, custid varchar(50) not null unique
    , pwd varchar(100) not null
    , custname varchar(30) not null
    , phone varchar(20) not null
    , addr varchar(60) not null
    , deletion_yn enum('Y', 'N') not null default 'N'
    , join_time datetime not null default now()
    , update_time datetime null
    , deletion_time datetime null
    , admin boolean not null default false
);

alter table member modify column admin boolean not null default false;
desc member;
select * from member order by join_time desc;
update member set admin=true where custid='test';
