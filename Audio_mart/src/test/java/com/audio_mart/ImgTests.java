package com.audio_mart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.audio_mart.domain.ProductImgDTO;
import com.audio_mart.service.ProductImgService;

@SpringBootTest
public class ImgTests {
	
	@Autowired
	private ProductImgService imgService;
	
	@Test
	public void registerImg() {
		for (int i = 1; i <= 3; i++) {
			ProductImgDTO params = new ProductImgDTO();
			params.setImgName(i + "번 이미지 이름");
			params.setImgPath(i + "번 이미지 경로");
			if (i == 2) {
				params.setMemo("메모");				
			}
			params.setProductId((long) 2);
			if (i == 3) {
				params.setIsRep(1);				
			}
			imgService.registerImg(params);
		}
		System.out.println("이미지 DB 등록 테스트");
	}
	
	@Test
	public void updateImgTest() {
		ProductImgDTO params = new ProductImgDTO();
		params.setImgId((long) 1);
		params.setImgName("수정된 이미지 이름");
		params.setImgPath("수정된 이미지 경로");
		params.setMemo("이미지 설명 수정");
		imgService.updateImg(params);
		
		System.out.println("이미지 DB 수정 테스트");
	}
	
	@Test
	public void deleteImgTest() {
		imgService.deleteImg((long) 2);
		System.out.println("이미지 삭제 DB 테스트");
	}
	
	@Test
	public void getImgListTest() {
		for (ProductImgDTO img : imgService.getImgList((long) 3)) {
			System.out.println("=====================");
			System.out.println(img.getImgId());
			System.out.println(img.getProductId());
			System.out.println(img.getImgName());
			System.out.println(img.getImgPath());
			System.out.println(img.getIsRep());
			System.out.println(img.getDeleteYn());
			System.out.println(img.getMemo());
			System.out.println("=====================");
		}
	}	
}
