use audio_mart;

create table member (
	  custid varchar(50) not null primary key
    , pwd varchar(100) not null
    , custname varchar(30) not null
    , phone varchar(20) not null
    , addr varchar(60) not null
    , join_date datetime not null default now()
    , signout enum('Y', 'N') not null default 'N'
    , out_date datetime null
);

desc member;

select * from member order by join_date desc;
