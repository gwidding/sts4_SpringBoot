package com.audio_mart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audio_mart.domain.MemberDTO;
import com.audio_mart.mapper.MemberMapper;


@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public boolean signup(MemberDTO params) {
		boolean queryResult = memberMapper.insertMember(params);

		return queryResult;
	}
	

}
