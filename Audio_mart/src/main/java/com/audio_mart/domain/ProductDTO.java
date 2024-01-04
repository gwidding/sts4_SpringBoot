package com.audio_mart.domain;

import java.time.LocalDateTime;

public class ProductDTO {
	
	private Long productId;
	private Long cateId;
	private String pname;
	private int pprice;
	private int stock;
	private String description;
	private int orderCnt;
	private int viewCnt;
	private LocalDateTime registerDate;
	private String deleteYn;
	private LocalDateTime deleteDate;
	private LocalDateTime updateDate;
	
	private String thumbImg;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getCateId() {
		return cateId;
	}
	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getOrderCnt() {
		return orderCnt;
	}
	public void setOrderCnt(int orderCnt) {
		this.orderCnt = orderCnt;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public LocalDateTime getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	public LocalDateTime getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(LocalDateTime deleteDate) {
		this.deleteDate = deleteDate;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	
	
	public String getThumbImg() {
		return thumbImg;
	}
	public void setThumbImg(String thumbImg) {
		this.thumbImg = thumbImg;
	}
	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", cateId=" + cateId + ", pname=" + pname + ", pprice=" + pprice
				+ ", stock=" + stock + ", description=" + description + ", orderCnt=" + orderCnt + ", viewCnt="
				+ viewCnt + ", registerDate=" + registerDate + ", deleteYn=" + deleteYn + ", deleteDate=" + deleteDate
				+ ", updateDate=" + updateDate + ", thumbImg=" + thumbImg + "]";
	}


}
