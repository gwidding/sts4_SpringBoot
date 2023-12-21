package com.audio_mart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audio_mart.domain.ProductDTO;
import com.audio_mart.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// 상품 업로드
	@PostMapping("/upload")
	public ResponseEntity<String> uploadProduct(@RequestBody ProductDTO product) {
		boolean isUploaded = productService.uploadProduct(product);
		if (isUploaded) {
			return ResponseEntity.ok(product.getPname() + " 상품이 성공적으로 등록되었습니다.");
		} else {
			return ResponseEntity.badRequest().body("상품 등록에 실패하였습니다.");
		}
	}
	
	// 상품 정보 수정
	@PatchMapping("/{productId}/update")
	public ResponseEntity<String> updateProduct(@PathVariable int productId, @RequestBody ProductDTO updatedProduct) {
	    boolean isUpdated = productService.updateProduct(updatedProduct);
	    if (isUpdated) {
	        return ResponseEntity.ok(updatedProduct.getPname() + " 상품이 성공적으로 수정 되었습니다.");
	    } else {
	        return ResponseEntity.badRequest().body("상품 정보 수정에 실패하였습니다.");
	    }
	}
	// 상품 삭제(내리기)
	@DeleteMapping("/{productId}/remove")
	public ResponseEntity<String> removeProduct(@PathVariable int productId) {
	    boolean isRemoved = productService.removeProduct(productId);
	    if (isRemoved) {
	        return ResponseEntity.ok("상품이 성공적으로 삭제처리 되었습니다.");
	    } else {
	        return ResponseEntity.badRequest().body("상품 삭제에 실패했습니다.");
	    }
	}
	
	// 상품번호 -> 상품 정보
	@GetMapping("/{productId}")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable int productId) {
		ProductDTO product = productService.findByProductId(productId);
		
		if (product != null) {
			return ResponseEntity.ok(product); // 200 응답과 함께 productDTO 반환
		} else {
			return ResponseEntity.notFound().build(); // 404
		}
	}
	
	// 상품 목록 조회 (순서 기준은 html에서 요청 -? )
	@GetMapping("/list")
	public ResponseEntity<List<ProductDTO>> getProductsList() {
		List<ProductDTO> productList = productService.getProductList();
		if (!productList.isEmpty()) {
			return ResponseEntity.ok(productList);
		} else {
			return ResponseEntity.noContent().build();
		}
		
	}	
}
