package com.audio_mart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.audio_mart.constant.Method;
import com.audio_mart.domain.MemberDTO;
import com.audio_mart.service.MemberService;
import com.audio_mart.util.UiUtils;

@Controller
public class MemberController extends UiUtils{
	
	@Autowired
	MemberService memberService;
	
	// 회원가입
	@PostMapping(value = "/member/register")
	public String registerMember(final MemberDTO params, Model model) {
		try {
//				String encryptedPassword = passwordEncoder.encode(params.getPwd());
//		        params.setPwd(encryptedPassword);
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
		return showMessageWithRedirect( params.getCustname() + "님의 회원가입이 완료되었습니다. 로그인 후 다양한 서비스를 이용해 주세요.", "/member/login", Method.GET, null, model);
	}
	
	
	// 회원 정보 수정
	@PostMapping("/member/update")
	public String updateMember(@ModelAttribute("params")final MemberDTO params, Model model) {
		memberService.updateMember(params);

		return "redirect:/member/myaccount";
	}
	
	@PostMapping("/member/delete")
	public String deleteMember(@RequestParam(value ="idx", required = false) Long idx) {
		if (idx < 1) {
			System.out.println("아이디 전달 안 됨");
			return "redirect:/member/myaccount";
		}
		try {
			boolean isDeleted = memberService.deleteMember(idx);
			if (isDeleted == false) {
				System.out.println("회원 탈퇴 실패");
			}
		} catch(DataAccessException e) {
			System.out.println("데베 문제");
		} catch(Exception e) {
			System.out.println("시스템 문제");
		}
		
		return "redirect:/home";
	}

}
