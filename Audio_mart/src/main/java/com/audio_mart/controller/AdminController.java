package com.audio_mart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.audio_mart.domain.CategoryDTO;
import com.audio_mart.domain.MemberDTO;
import com.audio_mart.domain.ProductDTO;
import com.audio_mart.service.MemberService;
import com.audio_mart.service.ProductService;
import com.audio_mart.util.UiUtils;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController extends UiUtils{
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private ProductService productService;
	
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
	public String registerForm(HttpSession session, Model model) {
		MemberDTO memberInfo = getMemberInfo(session);
        if (memberInfo == null || memberInfo.isAdmin() == false) {
        	System.out.println("관리자 외에 허용되지 않은 접근입니다.");
        	return "redirect:/home";
        }
        model.addAttribute("product",new ProductDTO());
        List<CategoryDTO> categoryList = productService.getCategoryList();
        model.addAttribute("categories", categoryList);
        
        return "manage/registerItem";
	}
	
	@PostMapping("/admin/registerItem")
	public String registerProduct(final ProductDTO params, Model model) {
		
		try {
			boolean isRegistered = productService.uploadProduct(params);
			if (isRegistered == false) {
				System.out.println("상품 등록에 실패했습니다.");
				return "redirect:/admin/registerItem";
			}
		} catch (DataAccessException e) {
			System.out.println("상품등록 - DB에 문제");
		} catch (Exception e) {
			System.out.println("상품등록 - 시스템 문제");
		}
		
		model.addAttribute("product", new ProductDTO());
		return "manage/registerItem";
	}
}
