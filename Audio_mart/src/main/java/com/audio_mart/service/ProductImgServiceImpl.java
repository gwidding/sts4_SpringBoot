package com.audio_mart.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.audio_mart.domain.ProductDTO;
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
	
	private static String generateFileName(MultipartFile multiPart) {
        return "product-" + StringUtils.cleanPath(multiPart.getOriginalFilename());
    }
	
	
	public static void saveImg(ProductDTO productDTO, MultipartFile imgFile) throws IOException {
        // 파일 저장 경로 설정
        String uploadDir = "src/main/resources/static/images"; // 실제 경로로 변경해야 합니다.
        String fileName = generateFileName(imgFile); // 실제 이름으로 변경해야 합니다.

        Path uploadPath = Paths.get(uploadDir);

        // 디렉토리가 존재하지 않으면 생성
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // 파일 저장
        Path filePath = uploadPath.resolve(fileName);
        imgFile.transferTo(filePath.toFile());

        // ProductDTO에 파일 경로 저장 (필요에 따라)
        productDTO.setImgPath("/images/" + fileName); // 이미지 파일의 웹 경로 저장
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
