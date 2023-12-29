package com.audio_mart.domain;

public class CategoryDTO {
	
	private Long cateId;
	private String cateName;
	
	public Long getCateId() {
		return cateId;
	}
	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	@Override
	public String toString() {
		return "CategoryDTO [cateId=" + cateId + ", cateName=" + cateName + "]";
	}	
}
