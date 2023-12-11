package com.audio_mart.service;

import com.audio_mart.domain.MemberDTO;

public interface MemberService {
	
	// 회원가입
	public boolean signup(MemberDTO params);
	// 로그인
	public boolean login(String custid, String password);
	// 로그아웃
	public boolean logout(String custid);
	
	// 회원정보
	public MemberDTO findByCustid(String custid);

}
