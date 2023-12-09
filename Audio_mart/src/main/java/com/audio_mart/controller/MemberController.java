package com.audio_mart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.audio_mart.constant.Method;
import com.audio_mart.domain.MemberDTO;
import com.audio_mart.service.MemberService;
import com.audio_mart.util.UiUtils;

@Controller
public class MemberController extends UiUtils{
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping(value = "/member/login.do")
	public String openSignup(Model model) {
		model.addAttribute("newMember", new MemberDTO());
		return "member/signup";
	}
	
	@PostMapping(value = "/member/register.do")
	public String registerMember(final MemberDTO params, Model model) {
		System.out.println("post됨");
		try {
			boolean isRegistered = memberService.signup(params);
			if (isRegistered == false) {
				return showMessageWithRedirect("회원가입에 실패하였습니다.", "/member/login.do", Method.GET, null, model);
			}
		} catch (DataAccessException e) {
			return showMessageWithRedirect("데이터베이스 문제 발생", "/member/login.do", Method.GET, null, model);
		} catch (Exception e) {
			return showMessageWithRedirect("시스템 문제 발생", "/member/login.do", Method.GET, null, model);
		}

		model.addAttribute("newMember", new MemberDTO());
		return showMessageWithRedirect("회원가입이 완료되었습니다.", "/member/login.do", Method.GET, null, model);
	}
	

}
