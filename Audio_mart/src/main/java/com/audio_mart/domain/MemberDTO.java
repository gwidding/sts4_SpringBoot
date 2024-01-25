package com.audio_mart.domain;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class MemberDTO {
	
	private Long idx;
	
	// 어차피 html에서 빈칸 허용 안 하긴 함
	
	@NotBlank(message = "아이디는 필수 항목입니다.")
	@Pattern(regexp="^[a-zA-Z0-9]{4,20}$" , message="아이디는 4~20자의 영문, 숫자만 사용 가능합니다.")
	private String custid;
	
	
	@Pattern(regexp="^[a-zA-Z0-9]{8,16}$" , message="비밀번호는 8~16자의 영문, 숫자만 사용 가능합니다.")
	private String pwd;
	
	@NotBlank(message = "이름은 필수 항목입니다.")
	@Pattern(regexp="^[가-힣]{2,10}$" , message="이름은 2~10자의 한글만 가능합니다.")
	private String custname;
	
	@NotBlank(message = "연락처는 필수 항목입니다.")
	@Pattern(regexp="^010-\\d{4}-\\d{4}$", message="연락처는 010-0000-0000 형식으로 적어주세요.")
	private String phone;
	
	@NotBlank(message = "주소는 필수 항목입니다.")
	private String addr;
	
	private String deletionYn;
	private LocalDateTime joinTime;
	private LocalDateTime updateTime;
	private LocalDateTime deletionTime;
	private boolean admin;
	
	public Long getIdx() {
		return idx;
	}
	public void setIdx(Long idx) {
		this.idx = idx;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getDeletionYn() {
		return deletionYn;
	}
	public void setDeletionYn(String deletionYn) {
		this.deletionYn = deletionYn;
	}
	public LocalDateTime getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(LocalDateTime joinTime) {
		this.joinTime = joinTime;
	}
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	public LocalDateTime getDeletionTime() {
		return deletionTime;
	}
	public void setDeletionTime(LocalDateTime deletionTime) {
		this.deletionTime = deletionTime;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [idx=" + idx + ", custid=" + custid + ", pwd=" + pwd + ", custname=" + custname + ", phone="
				+ phone + ", addr=" + addr + ", deletionYn=" + deletionYn + ", joinTime=" + joinTime + ", updateTime="
				+ updateTime + ", deletionTime=" + deletionTime + ", admin=" + admin + "]";
	}	
	
}
