package com.audio_mart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.audio_mart.constant.Method;
import com.audio_mart.domain.CartDTO;
import com.audio_mart.domain.MemberDTO;
import com.audio_mart.domain.OrderDetailDTO;
import com.audio_mart.domain.OrdersDTO;
import com.audio_mart.service.CartService;
import com.audio_mart.service.MemberService;
import com.audio_mart.service.OrderService;
import com.audio_mart.util.UiUtils;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController extends UiUtils{
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	
	
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
            model.addAttribute("newOrder", new OrdersDTO());
        } else {
        	return showMessageWithRedirect("로그인 후 장바구니 이용이 가능합니다.", "/member/login", Method.GET, null, model);
        }
    	
    	return "cart/shopping-cart";
    }
    
    @PostMapping("/add-to-cart")
    public String addToCart(final CartDTO params, HttpSession session, Model model) {
    	MemberDTO memberInfo = getMemberInfo(session);
    	System.out.println("장바구니 " + params);
    	if (memberInfo != null ) {
    		cartService.addToCart(params);
    		System.out.println("장바구니 담기 완료");
    		return "redirect:/cart";
    	} else {
    		return showMessageWithRedirect("로그인 후 장바구니 이용이 가능합니다.", "/member/login", Method.GET, null, model);
    	}
    }
    
    @PostMapping("/cart/delete")
	public String deleteCart(@RequestParam(value ="cartId", required = false) Long cartId) {
		if (cartId < 1) {
			System.out.println("장바구니 번호 전달 안 됨");
			return "redirect:/cart";
		}
		try {
			boolean isDeleted = cartService.deleteItemCart(cartId);
			if (isDeleted == false) {
				System.out.println("장바구니 삭제 실패");
			}
		} catch(DataAccessException e) {
			System.out.println("데베 문제");
		} catch(Exception e) {
			System.out.println("시스템 문제");
		}
		
		return "redirect:/cart";
	}
    
    // 주문하기
    @PostMapping("/cart/order")
    public String orderCart(OrdersDTO order, HttpSession session, Model model) {
    	
    	System.out.println("받아온 값 " + order);
    	try {
    		boolean isAdded = orderService.addToOrder(order);
    		
    		if (isAdded) {
    			OrderDetailDTO detail = new OrderDetailDTO();
    			detail.setOrderId(order.getOrderId());
    			detail.setMemberId(order.getMemberIdx());
    			System.out.println("상세 주문 값 " + detail);
    			boolean isDetailAdded = orderService.addToOrderDetail(detail);
    			
    			if (!isDetailAdded ) {
    				System.out.println("주문 상세 추가 실패 " + isDetailAdded);
    			}
    		}
    		else {
    			System.out.println("주문 실패");    			
    		}

    	} catch(DataAccessException e) {
			System.out.println("데베 문제");
		} catch(Exception e) {
			System.out.println("시스템 문제");
		}
    	
    	return "redirect:/cart";
    }
    
//    @PostMapping("/cart/update")
//    public String updateCart(@RequestParam(value="cart") CartDTO[] cartArray, Model model) {
//    	List<CartDTO> cartList = Arrays.asList(cartArray);
//    	if (cartList == null || cartList.isEmpty()) {
//    		return showMessageWithRedirect("장바구니가 비었습니다.", "/cart", Method.GET, null, model);
//    	}
//    	try {
//    		for (CartDTO cart : cartList) {
//    			boolean isUpdated = cartService.updateCart(cart);
//    			if (!isUpdated) {
//    				System.out.println(cart.getCartId() + "번 장바구니 수정 실패");
//    			}
//    		}
//    	} catch(DataAccessException e) {
//			System.out.println("데베 문제");
//		} catch(Exception e) {
//			System.out.println("시스템 문제");
//		}
//    	
//    	return showMessageWithRedirect("장바구니 수정이 완료되었습니다.", "/cart", Method.GET, null, model);
//    }
}
