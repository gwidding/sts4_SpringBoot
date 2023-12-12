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
		params.setCustid("id1");
		params.setPwd("1111");
		params.setCustname("1번 고객");
		params.setPhone("010-1111-1111");
		params.setAddr("경기도 성남시 분당구 정자일로 95");
		
		boolean result = memberMapper.insertMember(params);
		System.out.println("결과는 " + result + "입니다.");
	}
	
	@Test
	public void testOfSelect() {
		
	}
	
	@Test
	public void testOfUpdate() {
		MemberDTO params = new MemberDTO();
		params.setCustname("수정");
		params.setPwd("tnwjd");
		params.setAddr("수정한 주소1");
		params.setPhone("010-5454-5454");
		params.setCustid("test");
		
		boolean result = memberMapper.updateMember(params);
		System.out.println("결과는 " + result + "입니다.");
	}
}
