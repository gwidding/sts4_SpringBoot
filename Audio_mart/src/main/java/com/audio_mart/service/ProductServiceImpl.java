package com.audio_mart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audio_mart.domain.CategoryDTO;
import com.audio_mart.domain.ProductDTO;
import com.audio_mart.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public boolean uploadProduct(ProductDTO params) {
		boolean	queryResult = productMapper.insertProduct(params);
		return queryResult;
	}
	
	@Override
	public List<CategoryDTO> getCategoryList() {
		return productMapper.cateList();
	}

	@Override
	public boolean updateProduct(ProductDTO params) {
		boolean queryResult = productMapper.updateProduct(params);
		return queryResult;
	}

	@Override
	public ProductDTO findByProductId(Long ProductId) {
		ProductDTO productInfo = productMapper.findByProductId(ProductId);
		return productInfo;
	}

	@Override
	public boolean removeProduct(Long productId) {
		boolean queryResult = productMapper.deleteProduct(productId);
		boolean cartDeleteResult = productMapper.deleteCartForDeletion(productId);
		return queryResult & cartDeleteResult;
	}

	@Override
	public List<ProductDTO> getProductList() {
		List<ProductDTO> productList = productMapper.productList();
		return productList;
	}

	@Override
	public List<ProductDTO> getDeletionList() {
		List<ProductDTO> deletionList = productMapper.deletionList();
		return deletionList;
	}
	

}
