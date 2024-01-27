package com.audio_mart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.audio_mart.constant.Method;
import com.audio_mart.domain.CartDTO;
import com.audio_mart.domain.MemberDTO;
import com.audio_mart.domain.OrderDetailDTO;
import com.audio_mart.domain.ProductDTO;
import com.audio_mart.domain.ProductImgDTO;
import com.audio_mart.service.MemberService;
import com.audio_mart.service.OrderService;
import com.audio_mart.service.ProductImgService;
import com.audio_mart.service.ProductService;
import com.audio_mart.util.UiUtils;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController extends UiUtils {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductImgService imgService;
	
	@Autowired
	private OrderService orderService;
	
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
    public String openAdminPage(Model model, HttpSession session) {
        MemberDTO memberInfo = getMemberInfo(session);
        if (memberInfo == null || memberInfo.isAdmin() == false) {
        	System.out.println("관리자 외에 허용되지 않은 접근입니다.");
        	return showMessageWithRedirect("관리자 외에 허용되지 않은 접근입니다.", "/home", Method.GET, null, model);
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
    // 주문 목록 보기
    @GetMapping("/member/myOrder")
    public String openMyOrder(Model model, HttpSession session) {
    	
    	MemberDTO memberInfo = getMemberInfo(session);
    	
    	if (memberInfo != null) {
    		model.addAttribute("memberInfo", memberInfo);
    		List<OrderDetailDTO> orderList = orderService.getOrderList(memberInfo.getIdx());
    		model.addAttribute("orderList", orderList);
    	} else {    		
    		return showMessageWithRedirect("로그인이 필요합니다.", "/home", Method.GET, null, model);
    	}
    	return "member/my_orderList";
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
        List<ProductImgDTO> imgList = imgService.getImgList(productId);  
        boolean viewCntResult = productService.increaseViewCnt(productId);
        if (!viewCntResult) {
        	System.out.println("조회수 증가 실패");
        }
        model.addAttribute("product", product);        
        model.addAttribute("imgList", imgList);
        model.addAttribute("newCart", new CartDTO());
        
        return "item/product-detail";  	
    }
}
