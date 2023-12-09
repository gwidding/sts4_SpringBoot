package com.audio_mart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.audio_mart.domain.MemberDTO;
import com.audio_mart.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping(value = "/member/login.do")
	public String openSignup(Model model) {
		model.addAttribute("newMember", new MemberDTO());
		System.out.println("get 됨");
		return "member/signup";
	}
	
	@PostMapping(value = "/member/register.do")
	public String registerMember(final MemberDTO params) {
		System.out.println("post됨");
		try {
			boolean isRegistered = memberService.signup(params);
			if (isRegistered == false) {
				System.out.println("등록 실패");
				return "member/signup";
			}
		} catch (DataAccessException e) {
			System.out.println("데베 문제");
			return "member/signup";
		} catch (Exception e) {
			System.out.println("시스템 문제");
		}
		System.out.println("회원가입 완료");
		return "member/signup";
	}
	

}
