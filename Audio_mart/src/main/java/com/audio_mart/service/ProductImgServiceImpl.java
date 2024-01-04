package com.audio_mart.service;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.audio_mart.domain.ProductDTO;
import com.audio_mart.domain.ProductImgDTO;
import com.audio_mart.mapper.ProductImgMapper;
import com.audio_mart.mapper.ProductMapper;

@Service
public class ProductImgServiceImpl implements ProductImgService{
	
	@Autowired
	private ProductImgMapper imgMapper;

	@Override
	public boolean registerImg(ProductImgDTO params) {
		boolean queryResult = imgMapper.insertImg(params);
		return queryResult;
	}
	
//	public static boolean saveImg (ProductDTO params, MultipartFile imgFile) throws Exception {
//		String oriImgName = imgFile.getOriginalFilename();
//		String imgName = "";
//		
//		String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files";
//		
//		UUID uuid = UUID.randomUUID();
//		
//		String savedFileName = uuid + "_" + oriImgName; // 파일명 -> ImgName
//		
//		imgName = savedFileName;
//		
//		File saveFile = new File(projectPath, imgName);
//		imgFile.transferTo(saveFile);
//		
//		params.setThumbImg(imgName);
//		params.setImgPath("/files/" + imgName);
//		
//		boolean imgResult = productMapper.saveImg(params);
//		
//		return imgResult;
//	}

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
