package com.audio_mart.domain;

import java.time.LocalDateTime;

public class ProductDTO {
	
	private int productId;
	private int cateId;
	private String pname;
	private int pprice;
	private int stock;
	private String description;
	private String img1;
	private String img2;
	private String img3;
	private int orderCnt;
	private int viewCnt;
	private LocalDateTime registerDate;
	private String deleteYn;
	private LocalDateTime deleteDate;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCateId() {
		return cateId;
	}
	public void setCateId(int cateId) {
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
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
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
	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", cateId=" + cateId + ", pname=" + pname + ", pprice=" + pprice
				+ ", stock=" + stock + ", description=" + description + ", img1=" + img1 + ", img2=" + img2 + ", img3="
				+ img3 + ", orderCnt=" + orderCnt + ", viewCnt=" + viewCnt + ", registerDate=" + registerDate
				+ ", deleteYn=" + deleteYn + ", deleteDate=" + deleteDate + "]";
	}

}
