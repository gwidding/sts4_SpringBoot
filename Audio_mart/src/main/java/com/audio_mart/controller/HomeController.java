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
	
	private MemberDTO getMemberInfo(HttpSession session) {
        Integer idx = (Integer) session.getAttribute("idx");
        if (idx != null) {
            return memberService.findByIdx(idx);
        }
        return null;
    }
    
    @GetMapping("/home")
    public String openHome(Model model, HttpSession session) {
        MemberDTO memberInfo = getMemberInfo(session);
        if (memberInfo != null) {
            model.addAttribute("memberInfo", memberInfo);
        }
        return "home/index";
    }
    
    @GetMapping("/admin")
    public String openAdminPage(HttpSession session) {
        MemberDTO memberInfo = getMemberInfo(session);
        if (memberInfo == null || memberInfo.isAdmin() == false) {
        	System.out.println("관리자 외에 허용되지 않은 접근입니다.");
        	return "redirect:/home";
        }
        return "manage/admin";
    }
    
    @GetMapping("/member/myaccount")
    public String openMyAccount(Model model, HttpSession session) {
        MemberDTO memberInfo = getMemberInfo(session);
        if (memberInfo == null) {
            System.out.println("로그인 해야 마이페이지 들어가짐");
            return "redirect:/home";
        }
        model.addAttribute("memberInfo", memberInfo);
        return "member/myaccount";
    }
    
    @GetMapping("/product")
    public String showItem(Model model, HttpSession session) {
        MemberDTO memberInfo = getMemberInfo(session);
        System.out.println("로그인 되어 있는 회원 번호 : " + (memberInfo != null ? memberInfo.getIdx() : "로그인 안됨"));
        
        if (memberInfo != null) {
            model.addAttribute("memberInfo", memberInfo);
        }
        return "item/product";
    }
}
