use board;

INSERT INTO board(title, content, writer)
SELECT title, content, writer FROM board WHERE delete_yn = 'N';