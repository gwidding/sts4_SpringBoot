package com.audio_mart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.audio_mart.domain.MemberDTO;
import com.audio_mart.mapper.MemberMapper;


@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper memberMapper;
//	@Autowired
//    private PasswordEncoder passwordEncoder;
	
	// 회원가입
	@Override
	public boolean signup(MemberDTO params) {
		boolean queryResult = memberMapper.insertMember(params);
		return queryResult;
	}

	@Override
	public boolean login(String custid, String password) {
		MemberDTO member = memberMapper.findByCustid(custid);
		
//		boolean queryResult = (member != null && passwordEncoder.matches(password, member.getPwd()));
		boolean queryResult = (member != null && password.equals(member.getPwd()) );
		return queryResult;
	}

	@Override
	public boolean logout(String custid) {
		// TODO Auto-generated method stub
		return false;
	}



	

}
