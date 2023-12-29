package com.audio_mart.domain;

import java.time.LocalDateTime;

public class MemberDTO {
	private Long idx;
	private String custid;
	private String pwd;
	private String custname;
	private String phone;
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
