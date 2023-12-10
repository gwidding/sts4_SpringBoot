package com.audio_mart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.audio_mart.constant.Method;
import com.audio_mart.domain.MemberDTO;
import com.audio_mart.service.MemberService;
import com.audio_mart.util.UiUtils;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController extends UiUtils{
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// 로그인,가입 폼 띄우기 get
	@GetMapping(value = "/member/login.do")
	public String openSignup(Model model) {
		model.addAttribute("newMember", new MemberDTO());
		return "member/signup";
	}
	
	// 회원가입
	@PostMapping(value = "/member/register.do")
	public String registerMember(final MemberDTO params, Model model) {
		try {
			String encryptedPassword = passwordEncoder.encode(params.getPwd());
	        params.setPwd(encryptedPassword);
	        
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
	
	// 로그인 post
	@PostMapping(value = "/member/signin.do")
	public String signin(@RequestParam String custid, @RequestParam String password, HttpSession session) {
		if (custid == null) {
			return showMessageWithRedirect("올바르지 않은 접근입니다.", "/member/login.do", Method.GET, null, null);
		}
		
		if (memberService.login(custid, password)) {
			session.setAttribute("custid", custid);
			return showMessageWithRedirect("로그인 성공", "/shop", Method.GET, null, null);
		} else {
			return showMessageWithRedirect("로그인 실패", "/member/login.do", Method.GET, null, null);
		}
	}
	
//	@GetMapping("/checkLoginStatus")
//	public String checkLoginStatus(HttpSession session) {
//		String custid = (String) session.getAttribute("custid");
//		if (custid != null) {
//			return showMessageWithRedirect("환영합니다" + custid, "/shop", Method.GET, null, null);
//		} else {
//			return showMessageWithRedirect("not logged in", "/member/login.do", Method.GET, null, null);
//		}
//	}

//	@PostMapping("/member/logout")
//	public String logout(HttpSession session) {
//		session.removeAttribute("custid");
//		return showMessageWithRedirect("로그아웃 완료", "/member/login.do", Method.GET, null, null);
//	}

}
