package com.audio_mart.mapper;

import com.audio_mart.domain.ProductImgDTO;

public interface ProductImgMapper {
	
	// 이미지 등록( file, path )
	public boolean insertImg(ProductImgDTO params);
	// 이미지 수정
	public boolean updateImg(ProductImgDTO params);
	// 이미지 삭제
	public boolean deleteImg(Long imageId);
	

}
