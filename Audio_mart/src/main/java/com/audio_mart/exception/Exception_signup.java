package com.audio_mart.exception;

import org.springframework.beans.factory.annotation.Autowired;

import com.audio_mart.domain.MemberDTO;
import com.audio_mart.mapper.MemberMapper;

public class Exception_signup {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public boolean validateUserId(String memberId) {
		// 영어,숫자만 & 4-8자만 가능
		return memberId.matches("^[a-zA-Z0-9]{4,8}$");
	} 
	
	public boolean checkDupUserId(String memberId) {
		MemberDTO member = memberMapper.findByCustid(memberId);
		// 해당 회원 존재하면 중복이니 false
		return (member != null ) ? false : true;
	}
	
	public boolean validatePwd(String pwd) {
		// 영어,숫자만 & 8-20자만 가능
		return pwd.matches("^[a-zA-Z0-9]{8,20}$");
	} 
	
	public boolean validateName(String name) {
		// 이름은 한글만 가능
		return name.matches("^[가-힣]*$");
	}
	public boolean validatePhone(String phoneNumber) {
        // 010-0000-0000 형태만 가능
        return phoneNumber.matches("^010-\\d{4}-\\d{4}$");
    }

}
