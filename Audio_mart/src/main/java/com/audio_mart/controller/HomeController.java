package com.audio_mart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	@GetMapping("/store/home")
	public String openHome() {
		System.out.println("ㅎㅇㅎㅇ");
//		model.addAttribute("newMember", new MemberDTO());
		return "home/index";
	}
}
