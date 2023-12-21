package com.audio_mart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.audio_mart.domain.MemberDTO;
import com.audio_mart.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	private MemberService memberService;	
	
	private MemberDTO getMemberInfo(HttpSession session) {
        Integer idx = (Integer) session.getAttribute("idx");
        if (idx != null) {
            return memberService.findByIdx(idx);
        }
        return null;
    }

	@GetMapping("/admin/list")
	public String openMemberList(HttpSession session, Model model) {
		 MemberDTO memberInfo = getMemberInfo(session);
        if (memberInfo == null || memberInfo.isAdmin() == false) {
        	System.out.println("관리자 외에 허용되지 않은 접근입니다.");
        	return "redirect:/home";
        }
        model.addAttribute("memberList", memberService.getMemberList());
        return "manage/memberList";
	}
	
	@GetMapping("/admin/registerItem")
	public String registerForm(HttpSession session) {
		MemberDTO memberInfo = getMemberInfo(session);
        if (memberInfo == null || memberInfo.isAdmin() == false) {
        	System.out.println("관리자 외에 허용되지 않은 접근입니다.");
        	return "redirect:/home";
        }

        return "manage/registerItem";
	}
	
	@PostMapping("/admin/registerItem")
	public String registerProduct() {
		return "";
	}
}
