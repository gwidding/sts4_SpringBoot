package com.audio_mart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.audio_mart.domain.MemberDTO;
import com.audio_mart.domain.ProductDTO;
import com.audio_mart.service.MemberService;
import com.audio_mart.service.ProductService;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ProductService productService;
	
	private MemberDTO getMemberInfo(HttpSession session) {
        Long idx = (Long) session.getAttribute("idx");
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
        
        // 로그인 상태면 마이페이지 뜨도록 회원정보 보내기
        if (memberInfo != null) {
            model.addAttribute("memberInfo", memberInfo);
        }
        
        List<ProductDTO> itemList = productService.getProductList();
        model.addAttribute("products", itemList);
        
        return "item/product";
    }
    
    // 상세 상품 뷰 열기
    @GetMapping("/product-detail")
    public String showProductDetail(Model model, @RequestParam(value = "productId", required = false) Long productId, HttpSession session) {
    	
    	MemberDTO memberInfo = getMemberInfo(session);
    	
    	if (productId == null) {
    		System.out.println("상품 번호가 비었습니다. - 잘못된 접근");
    		return "redirect:/home";
    	}
    	
    	// 로그인 상태면 마이페이지, 주문자 정보 전달
        if (memberInfo != null) {
            model.addAttribute("memberInfo", memberInfo);
        }
        ProductDTO product = productService.findByProductId(productId);
        model.addAttribute("product", product);
        
        return "item/product-detail";  	
    	
    }
    
    // 장바구니 cart 뷰 열기
    @GetMapping("/cart")
    public String showCartView(Model model, HttpSession session) {
    	
    	MemberDTO memberInfo = getMemberInfo(session);
    	
    	if (memberInfo != null) {
            model.addAttribute("memberInfo", memberInfo);
        } else {
        	System.out.println("로그인 후 장바구니 볼 수 있음");
        }
    	
    	return "cart/shopping-cart";
    }
}
