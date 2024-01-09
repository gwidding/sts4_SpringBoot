package com.audio_mart.service;

import java.util.List;

import com.audio_mart.domain.CartDTO;

public interface CartService {
	// 장바구니에 추가하기
	public boolean addToCart(CartDTO params);
	// 장바구니에서 삭제하기
	public boolean deleteItemCart(Long cartId);
	// 상품 주문 수량 바꾸기 - 장바구니 수정
	public boolean updateCart(CartDTO params);
	// 장바구니 목록 가져오기 - 해당 회원
	public List<CartDTO> getCartList(Long memberId);
	
	// 회원탈퇴 시 실행할 장바구니 모두 제거
	public boolean deleteMemCart(Long memberId);

}
