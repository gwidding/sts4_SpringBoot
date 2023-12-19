package com.audio_mart.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.audio_mart.domain.ProductDTO;

@Mapper
public interface ProductMapper {
	
	public boolean insertProduct(ProductDTO params);

//	public ProductDTO findByProductId(int productId);
//	public boolean updateProduct(int productId);
//	public boolean deleteProduct(int productId);
//	public List<ProductDTO> productList();
	
	

}
