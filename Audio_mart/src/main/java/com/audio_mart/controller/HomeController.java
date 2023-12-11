package com.audio_mart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String openHome() {
		System.out.println("home 페이지 열림");
//		model.addAttribute("newMember", new MemberDTO());
		return "home/index";
	}
	
	@GetMapping("/member/myaccount")
	public String openMyAccount() {
		System.out.println("마이페이지 열림");
		return "member/myaccount";
	}
}
