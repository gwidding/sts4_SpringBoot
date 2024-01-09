package com.audio_mart.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audio_mart.domain.CartDTO;
import com.audio_mart.mapper.CartMapper;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;
	
	@Override
	public boolean addToCart(CartDTO params) {
		boolean queryResult = cartMapper.insertCart(params);
		return queryResult;
	}

	@Override
	public boolean deleteItemCart(Long cartId) {
		
		boolean queryResult = false;
		CartDTO cart = cartMapper.selectByCartId(cartId);
		
		if (cart != null)
			queryResult = cartMapper.deleteCart(cartId);
		
		return queryResult;
	}

	@Override
	public boolean updateCart(CartDTO params) {
		boolean queryResult = cartMapper.updateCart(params);
		return queryResult;
	}

	@Override
	public List<CartDTO> getCartList(Long memberId) {
		List<CartDTO> cartList = Collections.emptyList();
		
		int cartCnt = cartMapper.selectCartTotalCnt(memberId);
		if (cartCnt > 0) {
			cartList = cartMapper.selectCartList(memberId);			
		}
		return cartList;
	}

	@Override
	public boolean deleteMemCart(Long memberId) {
		boolean queryResult = cartMapper.deleteMemberCart(memberId);
		return queryResult;
	}

}
