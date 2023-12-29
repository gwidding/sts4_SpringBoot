package com.audio_mart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// 회원번호로 회원 정보 가져오기
	private MemberDTO getMemberInfo(HttpSession session) {
        Long idx = (Long) session.getAttribute("idx");
        if (idx != null) {
            return memberService.findByIdx(idx);
        }
        return null;
    }
	
	// 관리자 여부 확인
	private boolean isAdmin(HttpSession session) {
		MemberDTO memberInfo = getMemberInfo(session);
	    boolean isAdmin = memberInfo != null && memberInfo.isAdmin();
	    if (!isAdmin) {
	        System.out.println("관리자 외에 허용되지 않은 접근입니다.");
	    }
	    return isAdmin;
	}

	
	// 회원 목록
	@GetMapping("/admin/list")
	public String openMemberList(HttpSession session, Model model) {
        if (!isAdmin(session)) {
        	return "redirect:/home";
        }
        model.addAttribute("memberList", memberService.getMemberList());
        return "manage/memberList";
	}
	
	
	// 상품 등록 및 수정 폼 열기
	@GetMapping("/admin/registerItem")
	public String registerForm(HttpSession session, @RequestParam(value = "productId", required = false) Long productId, Model model) {
		
		if (!isAdmin(session)) {
        	return "redirect:/home";
        }
		
        if (productId == null) {
        	model.addAttribute("product",new ProductDTO());
        } else {
        	ProductDTO product = productService.findByProductId(productId);
        	model.addAttribute("product", product);
        }
        
        List<CategoryDTO> categoryList = productService.getCategoryList();
        model.addAttribute("categories", categoryList);
        
        return "manage/registerItem";
	}
	
	
	// 상품 등록하기
	@PostMapping("/admin/registerItem")
	public String registerProduct(final ProductDTO params, HttpSession session, Model model) {
		
		if (!isAdmin(session)) {
        	return "redirect:/home";
        }
        
		try {
			boolean isRegisterd = productService.uploadProduct(params);
			if (isRegisterd == false) {
				System.out.println("상품 등록에 실패했습니다.");
			}
		} catch (DataAccessException e) {
			System.out.println("상품등록 - DB에 문제");
		} catch (Exception e) {
			System.out.println("상품등록 - 시스템 문제");
		}
		
		model.addAttribute("product", new ProductDTO());
		return "redirect:/admin/itemList";
	}
	
	
	// 상품 수정하기
	@PostMapping("/admin/updateItem")
	public String updateProduct(@RequestParam("productId") Long productId, final ProductDTO params, HttpSession session, Model model) {
		
		if (!isAdmin(session)) {
        	return "redirect:/home";
        }
        
		try {
			boolean isUpdated = productService.updateProduct(params);
			if (isUpdated == false) {
				System.out.println("상품 수정에 실패했습니다.");
			}
		} catch (DataAccessException e) {
			System.out.println("상품수정 - DB에 문제");
		} catch (Exception e) {
			System.out.println("상품수정 - 시스템 문제");
		}
		
		model.addAttribute("product", new ProductDTO());
		return "redirect:/admin/itemList";
	}
	
	
	@GetMapping("/admin/itemList")
	public String showItemList(HttpSession session, Model model) {
		
		if (!isAdmin(session)) {
        	return "redirect:/home";
        }
        
        List<ProductDTO> itemList = productService.getProductList();
        model.addAttribute("itemList", itemList);
        return "manage/itemList";       
	}
}
