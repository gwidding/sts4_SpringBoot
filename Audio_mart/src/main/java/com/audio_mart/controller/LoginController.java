package com.audio_mart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.audio_mart.constant.Method;
import com.audio_mart.domain.MemberDTO;
import com.audio_mart.service.MemberService;
import com.audio_mart.util.UiUtils;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController extends UiUtils{
	
	@Autowired
	private MemberService memberService;
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	// 로그인,가입 폼 띄우기 get
	@GetMapping("/member/login")
	public String showLoginPage(Model model, HttpSession session) {
		if (session.getAttribute("custid") != null) {
			return "redirect:/home";
		}
		model.addAttribute("newMember", new MemberDTO());
		return "member/signup";
	}
	
	// 회원가입
	@PostMapping(value = "/member/register")
	public String registerMember(final MemberDTO params, Model model) {
		try {
//			String encryptedPassword = passwordEncoder.encode(params.getPwd());
//	        params.setPwd(encryptedPassword);
	        
			boolean isRegistered = memberService.signup(params);
			if (isRegistered == false) {
				return showMessageWithRedirect("회원가입에 실패하였습니다.", "/member/login", Method.GET, null, model);
			}
		} catch (DataAccessException e) {
			return showMessageWithRedirect("데이터베이스 문제 발생", "/member/login", Method.GET, null, model);
		} catch (Exception e) {
			return showMessageWithRedirect("시스템 문제 발생", "/member/login", Method.GET, null, model);
		}

		model.addAttribute("newMember", new MemberDTO());
		return showMessageWithRedirect("회원가입이 완료되었습니다.", "/member/login", Method.GET, null, model);
	}
	
	// 로그인 post
	@PostMapping(value = "/member/signin")
	public String signin(@RequestParam("custid") String custid, @RequestParam("pwd") String pwd, HttpSession session, Model model) {
		
		if (memberService.login(custid, pwd)) {
			session.setAttribute("custid", custid);
			System.out.println("로그인 성공");
			MemberDTO memberInfo = memberService.findByCustid(custid);
			model.addAttribute(memberInfo);
			return showMessageWithRedirect("환영합니다! " + custid +"님", "/home", Method.GET, null, model);
		} else {
			System.out.println("로그인 실패!");
			return showMessageWithRedirect("아이디와 비밀번호가 일치하지 않습니다.", "/member/login", Method.GET, null, model);
		}
	}
	
	// 로그인 상태 확인
	@GetMapping("/member/checkLoginStatus")
	public String checkLoginStatus(HttpSession session, RedirectAttributes redirectAttributes) {
		String custid = (String) session.getAttribute("custid");
		if (custid != null) {
			System.out.println("로그인 회원 : " + custid);
			
			MemberDTO memberInfo = memberService.findByCustid(custid);
			redirectAttributes.addFlashAttribute("memberInfo", memberInfo);
			
			return "redirect:/member/myaccount";
//			return showMessageWithRedirect("회원 : " + memberInfo.getCustname(), "/member/myaccount", Method.GET, null, model);
		} else {
			System.out.println("로그아웃 된 상태로 들어옴");
			return "redirect:/member/login";
//			return showMessageWithRedirect("로그인 후 사용해 주세요 :)", "/member/login", Method.GET, null, model);
		}
	}

//	@PostMapping("/member/logout")
//	public String logout(HttpSession session) {
//		session.removeAttribute("custid");
//		return showMessageWithRedirect("로그아웃 완료", "/member/login", Method.GET, null, null);
//	}

}
