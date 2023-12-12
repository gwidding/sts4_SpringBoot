package com.audio_mart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.audio_mart.domain.MemberDTO;
import com.audio_mart.service.MemberService;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/home")
	public String openHome(Model model, HttpSession session) {
		String custid = (String) session.getAttribute("custid");
		
		if (custid != null) {
			MemberDTO memberInfo = memberService.findByCustid(custid);
			model.addAttribute("memberInfo", memberInfo);
		}
		
		return "home/index";
	}
	
	@GetMapping("/member/myaccount")
	public String openMyAccount(Model model, HttpSession session) {
		String custid = (String) session.getAttribute("custid");
		MemberDTO memberInfo = memberService.findByCustid(custid);
		model.addAttribute("memberInfo", memberInfo);
		
		return "member/myaccount";
	}
}
