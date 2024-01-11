package com.audio_mart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.audio_mart.constant.Method;
import com.audio_mart.domain.CartDTO;
import com.audio_mart.domain.MemberDTO;
import com.audio_mart.service.CartService;
import com.audio_mart.service.MemberService;
import com.audio_mart.util.UiUtils;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController extends UiUtils{
	
	@Autowired
	private MemberService memberService;
	@Autowired
	CartService cartService;
	
	private MemberDTO getMemberInfo(HttpSession session) {
        Long idx = (Long) session.getAttribute("idx");
        if (idx != null) {
            return memberService.findByIdx(idx);
        }
        return null;
    }
	
	// 장바구니 cart 뷰 열기
    @GetMapping("/cart")
    public String showCartView(Model model, HttpSession session) {
    	
    	MemberDTO memberInfo = getMemberInfo(session);
    	
    	if (memberInfo != null) {
            model.addAttribute("memberInfo", memberInfo);
            List<CartDTO> cartList = cartService.getCartList(memberInfo.getIdx());
            model.addAttribute("cartList", cartList);
            System.out.println(cartList);
        } else {
        	return showMessageWithRedirect("로그인 후 장바구니 이용이 가능합니다.", "/member/login", Method.GET, null, model);
        }
    	
    	return "cart/shopping-cart";
    }
    
    @PostMapping("/add-to-cart")
    @ResponseBody
    public String addToCart(@RequestBody CartDTO cartRequest, HttpSession session) {
    	MemberDTO memberInfo = getMemberInfo(session);
    	
    	if (memberInfo != null ) {
    		Long productId = cartRequest.getProductId();
    		int quantity = cartRequest.getQuantity();
    		
    		cartService.addToCart(memberInfo.getIdx(), productId, quantity);
    		System.out.println("장바구니 담기 완료");
    		return "Product added to cart successfully";
    	} else {
    		return showMessageWithRedirect("로그인 후 장바구니 이용이 가능합니다.", "/member/login", Method.GET, null, model);
    	}
    	
    }
}
