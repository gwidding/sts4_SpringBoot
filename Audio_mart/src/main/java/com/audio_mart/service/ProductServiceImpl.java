package com.audio_mart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.audio_mart.domain.ProductDTO;
import com.audio_mart.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public boolean uploadProduct(ProductDTO params) {
		boolean queryResult = productMapper.insertProduct(params);
		return queryResult;
	}

	@Override
	public boolean updateProduct(ProductDTO params) {
		boolean queryResult = productMapper.updateProduct(params);
		return queryResult;
	}

	@Override
	public ProductDTO findByProductId(int ProductId) {
		ProductDTO productInfo = productMapper.findByProductId(ProductId);
		return productInfo;
	}

	@Override
	public boolean removeProduct(int productId) {
		boolean queryResult = productMapper.deleteProduct(productId);
		return queryResult;
	}

	@Override
	public List<ProductDTO> getProductList() {
		List<ProductDTO> productList = productMapper.productList();
		return productList;
	}
	
	

}