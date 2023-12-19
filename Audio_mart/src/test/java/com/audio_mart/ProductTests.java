package com.audio_mart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.audio_mart.domain.ProductDTO;
import com.audio_mart.mapper.ProductMapper;

@SpringBootTest
public class ProductTests {
	
	@Autowired
	private ProductMapper productMapper;
	
	
	@Test
	public void testOfInsertP() {
		ProductDTO params = new ProductDTO();
		
		params.setCateId(1);
		params.setPname("줄 이어폰");
		params.setPprice(150000);
		params.setStock(9);
		params.setDescription("이것은 줄 이어폰입니다.");
		
		boolean result = productMapper.insertProduct(params);
		System.out.println("회원 등록 쿼리 결과는 " + result + " 입니다." );
		
	}
}
