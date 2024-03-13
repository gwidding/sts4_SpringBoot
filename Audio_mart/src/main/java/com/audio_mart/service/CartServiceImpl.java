package com.audio_mart.service;

import java.util.Collections;
import java.util.List;

import com.audio_mart.domain.ProductDTO;
import com.audio_mart.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audio_mart.domain.CartDTO;
import com.audio_mart.mapper.CartMapper;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private ProductService productService;
	
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
			for (CartDTO cart : cartList) {
				// 장바구니 담은 상품 재고 부족 시 삭제
				ProductDTO product = productService.findByProductId(cart.getProductId());
				if (product == null && product.getStock() - cart.getQuantity() < 0) {
					cartMapper.deleteCart(cart.getCartId());
				}
			}
//			System.out.println(cartList);
		}
		return cartList;
	}

	@Override
	public boolean deleteMemCart(Long memberId) {
		boolean queryResult = cartMapper.deleteMemberCart(memberId);
		return queryResult;
	}

}
