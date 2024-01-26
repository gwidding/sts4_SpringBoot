package com.audio_mart.domain;

public class ProductImgDTO {
	
	private Long imgId;
	private Long productId;
	private String imgName;
	private String imgPath;
	private int isRep;
	private String deleteYn;
	private String memo;


	public Long getImgId() {
		return imgId;
	}
	public void setImgId(Long imgId) {
		this.imgId = imgId;
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
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public int getIsRep() {
		return isRep;
	}
	public void setIsRep(int isRep) {
		this.isRep = isRep;
	}
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "ProductImgDTO [imgId=" + imgId + ", productId=" + productId + ", imgName=" + imgName + ", imgPath="
				+ imgPath + ", isRep=" + isRep + ", deleteYn=" + deleteYn + ", memo=" + memo + "]";
	}
	
}
