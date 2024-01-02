package com.audio_mart.service;

import java.util.List;

import com.audio_mart.domain.ProductImgDTO;

public interface ProductImgService {
	
	public boolean registerImg(ProductImgDTO params);
	public boolean updateImg(ProductImgDTO params);
	public boolean deleteImg(Long imgId);
	public List<ProductImgDTO> getImgList(Long productId);

}
