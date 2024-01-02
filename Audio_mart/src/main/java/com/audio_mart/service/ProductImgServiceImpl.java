package com.audio_mart.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audio_mart.domain.ProductImgDTO;
import com.audio_mart.mapper.ProductImgMapper;

@Service
public class ProductImgServiceImpl implements ProductImgService{
	
	@Autowired
	private ProductImgMapper imgMapper;

	@Override
	public boolean registerImg(ProductImgDTO params) {
		boolean queryResult = imgMapper.insertImg(params);
		return queryResult;
	}

	@Override
	public boolean updateImg(ProductImgDTO params) {
		boolean queryResult = imgMapper.updateImg(params);
		return queryResult;
	}

	@Override
	public boolean deleteImg(Long imgId) {
		boolean queryResult = false;
		ProductImgDTO img = imgMapper.imgDetail(imgId);
		
		if (img != null && "N".equals(img.getDeleteYn())) {
			queryResult = imgMapper.deleteImg(imgId);
		}
		
		return queryResult;
	}

	@Override
	public List<ProductImgDTO> getImgList(Long productId) {
		List<ProductImgDTO> imgList = Collections.emptyList();
		
		int imgTotalCnt = imgMapper.selectImgTotalCnt(productId);
		if (imgTotalCnt > 0) {
			imgList = imgMapper.getImgList(productId);
		}
		return imgList;
	}

}
