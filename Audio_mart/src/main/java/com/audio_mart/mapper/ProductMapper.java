package com.audio_mart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.audio_mart.domain.CategoryDTO;
import com.audio_mart.domain.ProductDTO;
import com.audio_mart.domain.ProductImgDTO;

@Mapper
public interface ProductMapper {
	
	public boolean insertProduct(ProductDTO params);
	public boolean insertImg(List<ProductImgDTO> imgList);
	public List<CategoryDTO> cateList();
	public ProductDTO findByProductId(Long productId);
	public boolean updateProduct(ProductDTO params);
	public boolean deleteProduct(Long productId);
	public boolean deleteCartForDeletion(Long productId);
	public List<ProductDTO> productList();
	public List<ProductDTO> deletionList();
	
	public boolean saveImg(ProductDTO params);

}
