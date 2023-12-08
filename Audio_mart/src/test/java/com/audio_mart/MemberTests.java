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
		params.setCustid("id2");
		params.setPwd("2222");
		params.setCustname("2번 고객");
		params.setPhone("010-2222-2222");
		params.setAddr("서울특별시 구구구구 무슨로 222길 22");
		
		boolean result = memberMapper.insertMember(params);
		System.out.println("결과는 " + result + "입니다.");
	}
}
