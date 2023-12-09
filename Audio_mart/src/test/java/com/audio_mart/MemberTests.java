package com.audio_mart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.audio_mart.domain.MemberDTO;
import com.audio_mart.mapper.MemberMapper;

@SpringBootTest
public class MemberTests {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void testOfInsert() {
		MemberDTO params = new MemberDTO();
		params.setCustid("id3");
		params.setPwd("3333");
		params.setCustname("3번 고객");
		params.setPhone("010-3333-3333");
		params.setAddr("경기도 일산동구 뽀로로 3길 3");
		
		boolean result = memberMapper.insertMember(params);
		System.out.println("결과는 " + result + "입니다.");
	}
}
