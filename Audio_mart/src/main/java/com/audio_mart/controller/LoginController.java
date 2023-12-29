package com.audio_mart.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	// 로그인,가입 폼
	@GetMapping("/member/login")
	public String showLoginPage(Model model, HttpSession session) {

		if (session.getAttribute("custid") != null) {
			return "redirect:/home";
		}

		model.addAttribute("newMember", new MemberDTO());
		return "member/signup";
	}
	
	// 로그인 post
	@PostMapping(value = "/member/signin")
	public String signin(@RequestParam("custid") String custid, @RequestParam("pwd") String pwd, HttpSession session, Model model) {
		
		if (memberService.login(custid, pwd)) {
			MemberDTO memberInfo = memberService.findByCustid(custid);
			session.setAttribute("idx", memberInfo.getIdx());
			model.addAttribute(memberInfo);
			return showMessageWithRedirect("환영합니다! " + memberInfo.getCustname() +"님", "/home", Method.GET, null, model);
		} else {
			return showMessageWithRedirect("아이디와 비밀번호가 일치하지 않습니다.", "/member/login", Method.GET, null, model);
		}
	}
	
	// 로그인 상태 확인
	// 추후 변경 필요 : 로그인 확인 시 다른 페이지로 이동
	@GetMapping("/member/checkLoginStatus")
	public String checkLoginStatus(HttpSession session, RedirectAttributes redirectAttributes) {
		Long idx = (Long) session.getAttribute("idx");
		if (idx != null) {
			MemberDTO memberInfo = memberService.findByIdx(idx);
			redirectAttributes.addFlashAttribute("memberInfo", memberInfo);
			return "redirect:/member/myaccount";
		} else {
			return "redirect:/member/login";
		}
	}

	// 로그아웃
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("idx");
		return "redirect:/home";
	}

}
