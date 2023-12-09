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
		params.setCustid("id4");
		params.setPwd("4444");
		params.setCustname("4번 고객");
		params.setPhone("010-4444-4444");
		params.setAddr("인천ㅇㅎㅇㅎㄴㅁㅇ 3길 3");
		
		boolean result = memberMapper.insertMember(params);
		System.out.println("결과는 " + result + "입니다.");
	}
}
