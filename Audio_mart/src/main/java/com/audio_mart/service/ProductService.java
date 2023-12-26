package com.audio_mart.service;

import java.util.List;

import com.audio_mart.domain.ProductDTO;

public interface ProductService {
	
	// 상품 등록하기
	public boolean uploadProduct(ProductDTO params);
	// 상품 수정하기
	public boolean updateProduct(ProductDTO params);
	// 한 상품 정보 가져오기
	public ProductDTO findByProductId(int ProductId);
	// 상품 삭제하기
	public boolean removeProduct(int productId);
	// 상품 목록 가져오기
	public List<ProductDTO> getProductList();
	

}