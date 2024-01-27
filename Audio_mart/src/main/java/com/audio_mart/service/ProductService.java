package com.audio_mart.service;

import java.util.List;

import com.audio_mart.domain.CategoryDTO;
import com.audio_mart.domain.ProductDTO;
import com.audio_mart.domain.ProductImgDTO;

public interface ProductService {
	
	// 상품 등록하기
	public boolean uploadProduct(ProductDTO params);
	// 상품 이미지 등록하기
	public boolean uploadPImg(List<ProductImgDTO> params);
	// 상품 카테고리 목록 가져오기
	public List<CategoryDTO> getCategoryList();
	// 상품 수정하기
	public boolean updateProduct(ProductDTO params);
	// 한 상품 정보 가져오기
	public ProductDTO findByProductId(Long ProductId);
	// 상품 삭제하기
	public boolean removeProduct(Long productId);
	// 상품 목록 가져오기
	public List<ProductDTO> getProductList();
	// 내려간 상품 목록 가져오기
	public List<ProductDTO> getDeletionList();
	

}
