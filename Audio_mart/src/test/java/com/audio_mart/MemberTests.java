package com.audio_mart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.audio_mart.domain.MemberDTO;
import com.audio_mart.mapper.MemberMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootTest
public class MemberTests {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void testOfInsert() {
		MemberDTO params = new MemberDTO();

		params.setCustid("test");
		params.setPwd("test");
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
		params.setIdx(1);
		params.setCustname("수정한 1번 고객");
		params.setPwd("test");
		params.setAddr("수정한 주소1");
		params.setPhone("010-1234-1234");
		
		boolean result = memberMapper.updateMember(params);
		System.out.println("결과는 " + result + "입니다.");
	}
	
	@Test
	public void testOfDelte() {
		boolean result = memberMapper.deleteMember(1);
		if (result) {
			MemberDTO member = memberMapper.findByIdx(1);
			try {
				String memberJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(member);
				System.out.println("삭제한 회원 " + memberJson);
				
			} catch(JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
	
}
