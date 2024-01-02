package com.audio_mart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.audio_mart.domain.ProductImgDTO;

@Mapper
public interface ProductImgMapper {
	
	// 이미지 등록( file, path )
	public boolean insertImg(ProductImgDTO params);
	// 한 이미지 정보 가져오기
	public ProductImgDTO imgDetail(Long imgId);
	// 이미지 수정
	public boolean updateImg(ProductImgDTO params);
	// 이미지 삭제
	public boolean deleteImg(Long imgId);
	// 이미지 목록
	public List<ProductImgDTO> getImgList(Long productId);
	// 이미지 개수 카운팅
	public int selectImgTotalCnt(Long productId);
	

}
