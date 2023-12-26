package com.audio_mart.domain;

public class CategoryDTO {
	private int cateId;
	private String cateName;
	
	public int getCateId() {
		return cateId;
	}
	public void setCateId(int cateId) {
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
		return "categoryDTO [cateId=" + cateId + ", cateName=" + cateName + "]";
	}
	
	
}
