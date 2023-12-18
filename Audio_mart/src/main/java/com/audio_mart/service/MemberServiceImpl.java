package com.audio_mart.service;

import java.util.Collections;
import java.util.List;

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
	public MemberDTO findByIdx(int idx) {
		MemberDTO member = memberMapper.findByIdx(idx);
		return member;
	}
	
	@Override
	public MemberDTO findByCustid(String custid) {
		MemberDTO member = memberMapper.findByCustid(custid);
		return member;
	}
	

	@Override
	public boolean updateMember(MemberDTO params) {
		boolean queryResult = memberMapper.updateMember(params);
		System.out.println(params.getCustname() + " 회원 수정 결과 : " + queryResult);
		return queryResult;
	}

	@Override
	public boolean deleteMember(int idx) {
		boolean queryResult = memberMapper.deleteMember(idx);
		System.out.println(idx + " 회원 삭제 결과 : " + queryResult);
		return queryResult;
	}

	@Override
	public List<MemberDTO> getMemberList() {
		List<MemberDTO> memberList = Collections.emptyList();
		
		memberList = memberMapper.memberList();
		return memberList;
	}

	



	

}
