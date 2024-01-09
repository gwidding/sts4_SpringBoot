package com.audio_mart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.audio_mart.domain.CartDTO;

@Mapper
public interface CartMapper {
	
	public boolean insertCart(CartDTO params);
	public boolean updateCart(CartDTO params);
	public boolean deleteCart(CartDTO params);
	
	public CartDTO selectByCartId(Long cartId);
	public List<CartDTO> selectCartList(CartDTO params);
	public int selectCartTotalCnt(CartDTO parmas);

}
