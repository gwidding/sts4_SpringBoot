package com.audio_mart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.audio_mart.domain.ProductImgDTO;
import com.audio_mart.service.ProductImgService;

@RestController
public class ImageController {
	
	@Autowired
	private ProductImgService imgService;
	
	@GetMapping("/images/{productId}")
	public List<ProductImgDTO> getImgList(@PathVariable("productId") Long productId) {
		List<ProductImgDTO> imgList = imgService.getImgList(productId);
		return imgList;
	}
	
	
}