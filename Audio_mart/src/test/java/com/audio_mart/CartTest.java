package com.audio_mart;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import com.audio_mart.domain.CartDTO;
import com.audio_mart.mapper.CartMapper;

@SpringBootTest
public class CartTest {
	
	@Autowired
	private CartMapper cartMapper;
	
	@Test
	public void testOfInsert() {
		CartDTO params = new CartDTO();
		
		params.setMemberId((long) 4);
		params.setProductId((long) 2);
		params.setQuantity(3);
		
		boolean result = cartMapper.insertCart(params);
		System.out.println("장바구니 작성 결과는 " + result + " 입니다.");
	}
	
	@Test
	public void testOfUpdate() {
		CartDTO params = new CartDTO();
		params.setCartId((long) 1);
		params.setQuantity(2);
		
		boolean result = cartMapper.updateCart(params);
		System.out.println("장바구니 수정 결과는 " + result + " 입니다.");
	}
	
	@Test
	public void testOfDeleteOneCart() {
		long cartId = (long) 2;
		
		boolean result = cartMapper.deleteCart(cartId);
		System.out.println("장바구니 하나 삭제 결과 " + result + " 입니다.");
	}
	
	@Test
	public void testOfDeleteMemberCart() {
		long memberId = (long) 3;
		boolean result = cartMapper.deleteMemberCart(memberId);
		System.out.println("탈퇴 회원 장바구니 삭제 결과 " + result + " 입니다.");
	}
	
	@Test
	public void testOfSelectOneCart() {
		CartDTO oneCart = cartMapper.selectByCartId((long) 1);
		if (oneCart != null)
			System.out.println("1번 장바구니는 " + oneCart + " 입니다.");
		else
			System.out.println("해당 장바구니가 없습니다.");
	}
	
	@Test
	public void testOfSelectByMember() {
		long memberId = (long) 2;
		int cartCnt = cartMapper.selectCartTotalCnt(memberId);
		
		if (cartCnt > 0) {
			List<CartDTO> carts = cartMapper.selectCartList(memberId);
			if (CollectionUtils.isEmpty(carts) == false) {
				for (CartDTO cart : carts) {
					System.out.println("==============");
					System.out.println("장바구니 고유 번호 " + cart.getCartId());
					System.out.println("회원 고유번호 " + cart.getMemberId());
					System.out.println("상품 번호 " + cart.getProductId());
					System.out.println("상품 수량 " + cart.getQuantity());
				}
			}
		}
		else {
			System.out.println("조회할 장바구니 없음");
		}
		
	}

}
