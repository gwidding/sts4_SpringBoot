package com.audio_mart;

import java.util.List;

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
		
		params.setCateId((long) 2);
		params.setPname("무선 헤드셋");
		params.setPprice(400000);
		params.setStock(15);
		params.setDescription("이것은 보스 qc45 헤드셋입니다.");
		
		boolean result = productMapper.insertProduct(params);
		System.out.println("상품 등록 쿼리 결과는 " + result + " 입니다." );
	}
	
	@Test
	public void testOfSelectP() {
		ProductDTO result = productMapper.findByProductId((long) 2);
		System.out.println(result);
	}
	
	@Test
	public void testOfUpdateP() {
		ProductDTO params = new ProductDTO();
		
		params.setProductId((long) 11);
		params.setPname("유선 이어폰");
		params.setPprice(20000);
		params.setStock(10);
		params.setDescription("줄을 유선으로 수정하고 가격을 2만원으로 할인한 유선 이어폰이 입고되었습니다! :)");
		
		boolean result = productMapper.updateProduct(params);
		System.out.println("상품 수정 쿼리 결과는 " + result + " 입니다.");
	}
	
	@Test
	public void testOfDeleteP() {
		boolean result = productMapper.deleteProduct((long) 2);
		System.out.println("상품 삭제 결과는 " + result + " 입니다.");
	}
	
	@Test
	public void testOfListP() {
		List<ProductDTO> list = productMapper.productList();
		System.out.println(list);
	}

	
	
}
