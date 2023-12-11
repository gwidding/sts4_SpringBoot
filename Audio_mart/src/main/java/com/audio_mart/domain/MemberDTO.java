package com.audio_mart.domain;

import java.time.LocalDateTime;

public class MemberDTO {
	private String custid;
	private String pwd;
	private String custname;
	private String phone;
	private String addr;
	private String signout;
	private LocalDateTime joinDate;
	private LocalDateTime updateDate;
	private LocalDateTime outDate;
	
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
	public LocalDateTime getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}
	public String getSignout() {
		return signout;
	}
	public void setSignout(String signout) {
		this.signout = signout;
	}
	public LocalDateTime getOutDate() {
		return outDate;
	}
	public void setOutDate(LocalDateTime outDate) {
		this.outDate = outDate;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [custid=" + custid + ", pwd=" + pwd + ", custname=" + custname + ", phone=" + phone
				+ ", addr=" + addr + ", signout=" + signout + ", joinDate=" + joinDate + ", updateDate=" + updateDate
				+ ", outDate=" + outDate + "]";
	}
}
