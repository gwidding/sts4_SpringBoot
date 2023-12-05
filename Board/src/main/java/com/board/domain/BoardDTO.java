package com.board.domain;


//DTO(데이터를 넣고,쓰고,수정할 때) 나 DO(데이터 쓰진 않을 때)
public class BoardDTO extends CommonDTO {
	
	private Long idx;
	private String title;
	private String content;
	private String writer;
	private int viewCnt;
	private String noticeYn;
	private String secretYn;
//	private String deleteYn;
//	private LocalDateTime insertTime;
//	private LocalDateTime updateTime;
//	private LocalDateTime deleteTime;
	
	
	// @Getter, @Setter 써도 되지만 문제가 생겨서 일단 기본적인 방법으로
	public Long getIdx() {
		return idx;
	}
	public void setIdx(Long idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getNoticeYn() {
		return noticeYn;
	}
	public void setNoticeYn(String noticeYn) {
		this.noticeYn = noticeYn;
	}
	public String getSecretYn() {
		return secretYn;
	}
	public void setSecretYn(String secretYn) {
		this.secretYn = secretYn;
	}
//	public String getDeleteYn() {
//		return deleteYn;
//	}
//	public void setDeleteYn(String deleteYn) {
//		this.deleteYn = deleteYn;
//	}
//	public LocalDateTime getInsertTime() {
//		return insertTime;
//	}
//	public void setInsertTime(LocalDateTime insertTime) {
//		this.insertTime = insertTime;
//	}
//	public LocalDateTime getUpdateTime() {
//		return updateTime;
//	}
//	public void setUpdateTime(LocalDateTime updateTime) {
//		this.updateTime = updateTime;
//	}
//	public LocalDateTime getDeleteTime() {
//		return deleteTime;
//	}
//	public void setDeleteTime(LocalDateTime deleteTime) {
//		this.deleteTime = deleteTime;
//	}
	
	// (생성자 대신) 데이터가 잘 안 움직여질 때 도와줌
	@Override
	public String toString() {
		return "BoardDTO [idx=" + idx + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", viewCnt=" + viewCnt + ", noticeYn=" + noticeYn + ", secretYn=" + secretYn + "]";
	}
	

		
}