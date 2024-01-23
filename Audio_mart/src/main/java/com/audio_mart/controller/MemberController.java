package com.audio_mart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.audio_mart.constant.Method;
import com.audio_mart.domain.MemberDTO;
import com.audio_mart.service.MemberService;
import com.audio_mart.util.UiUtils;

import jakarta.validation.Valid;

@Controller
public class MemberController extends UiUtils {
	
	@Autowired
	MemberService memberService;
	
	// 회원가입
	@PostMapping("/member/register")
	public String registerMember(@Valid final MemberDTO params, BindingResult bindingResult, Model model) {
		try {
			// 회원 정보 유효성 검사
			if (bindingResult.hasErrors()) {
				StringBuilder errorMessage = new StringBuilder();
				bindingResult.getAllErrors().forEach(error ->errorMessage.append(error.getDefaultMessage()).append("\n"));
				return showMessageWithRedirect(errorMessage.toString(), "/member/login", Method.GET, null, model);
			}
			
			// 아이디 중복 검사
			if (memberService.findByCustid(params.getCustid()) != null) {
				return showMessageWithRedirect("중복된 아이디입니다. 다른 아이디를 사용해 주세요", "/member/login", Method.GET, null, model);
			}
			
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
	public String updateMember(@Valid @ModelAttribute("params")final MemberDTO params, BindingResult bindingResult, Model model) {
		// 수정한 정보 유효성 검사
		if (bindingResult.hasErrors()) {
			// 비밀번호 필드의 오류를 무시
            bindingResult.rejectValue("pwd", "field.pwd", null, null);
            
			StringBuilder errorMessage = new StringBuilder();
			bindingResult.getAllErrors().forEach(error ->errorMessage.append(error.getDefaultMessage()).append("\n"));
			return showMessageWithRedirect(errorMessage.toString(), "/member/myaccount", Method.GET, null, model);
		}
		try {
			boolean isUpdated = memberService.updateMember(params);
			if (!isUpdated) {
				return showMessageWithRedirect("회원정보 수정 실패", "/member/myaccount", Method.GET, null, model);
			}
		} catch (DataAccessException e) {
			return showMessageWithRedirect("회원정보 수정 실패 - 데이터베이스 문제", "/member/myaccount", Method.GET, null, model);
		} catch (Exception e) {
			return showMessageWithRedirect("회원정보 수정 실패 - 시스템 문제", "/member/myaccount", Method.GET, null, model);
		}

		return showMessageWithRedirect(params.getCustname() + "님의 정보가 수정되었습니다.", "/member/myaccount", Method.GET, null, model);
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
