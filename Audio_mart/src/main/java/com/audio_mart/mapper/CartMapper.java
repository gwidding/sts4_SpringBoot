package com.audio_mart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.audio_mart.domain.CartDTO;

@Mapper
public interface CartMapper {
	
	public boolean insertCart(CartDTO params);
	// 수량만 업데이트
	public boolean updateCart(CartDTO params);
	// 한 상품 삭제
	public boolean deleteCart(Long cartId);
	// 회원 탈퇴 시 장바구니 삭제
	public boolean deleteMemberCart(Long memberId);
	// 한 상품에 대한 정보 + 상품 정보
	public CartDTO selectByCartId(Long cartId);
	// 해당 회원의 장바구니 목록
	public List<CartDTO> selectCartList(Long memberId);
	// 해당 회원의 장바구니 개수
	public int selectCartTotalCnt(Long memberId);

}
