package com.audio_mart.domain;

public class ProductImageDTO {
	
	private Long imageId;
	private Long productId;
	private String imgName;
	private String imgDescription;
	private String imgPath;
	private String isPrimary;
	
	
	public Long getImageId() {
		return imageId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getImgDescription() {
		return imgDescription;
	}
	public void setImgDescription(String imgDescription) {
		this.imgDescription = imgDescription;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getIsPrimary() {
		return isPrimary;
	}
	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}
	@Override
	public String toString() {
		return "ProductImageDTO [imageId=" + imageId + ", productId=" + productId + ", imgName=" + imgName
				+ ", imgDescription=" + imgDescription + ", imgPath=" + imgPath + ", isPrimary=" + isPrimary + "]";
	}
	
	
}
