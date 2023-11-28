use board; 

create table board (
	idx INT NOT NULL auto_increment,
    title VARCHAR(100) NOT NULL,
	content VARCHAR(3000) NOT NULL,
    writer VARCHAR(20) NOT NULL,
    view_cnt INT NOT NULL DEFAULT 0,
    notice_yn ENUM('Y', 'N') NOT NULL DEFAULT 'N',
    secret_yn ENUM('Y', 'N') NOT NULL DEFAULT 'N',
    delete_yn ENUM('Y', 'N') NOT NULL DEFAULT 'N',
    insert_time DATETIME NOT NULL DEFAULT NOW(),
    update_time DATETIME NULL,
    delete_time DATETIME NULL,
    PRIMARY KEY(idx)
);

desc board;
show tables;

select * from board;