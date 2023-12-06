use board;

create table comment (
	idx INT NOT NULL auto_increment,
    board_idx INT NOT NULL,
    content VARCHAR(3000) NOT NULL,
    writer VARCHAR(20) NOT NULL,
    delete_yn ENUM('Y', 'N') NOT NULL DEFAULT 'N',
    insert_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT NULL,
    delete_time DATETIME DEFAULT NULL,
    PRIMARY KEY(idx)
);

ALTER TABLE COMMENT ADD CONSTRAINT fk_comment_board_idx foreign key (board_idx) references board(idx);

SELECT *
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_SCHEMA = 'board';


select * from board where idx = 200;
select * from comment;