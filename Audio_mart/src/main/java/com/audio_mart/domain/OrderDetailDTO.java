package com.audio_mart.domain;

import java.time.LocalDateTime;

/*create table orderDetail (
	order_detail_id int not null auto_increment primary key
    , order_id int not null
    , product_id int not null
    , quantity int not null default 1
    
    ,FOREIGN KEY (order_id) REFERENCES orders(order_id)
    ,FOREIGN KEY (product_id) REFERENCES product(product_id)
);*/
public class OrderDetailDTO {
	
	private Long orderDetailId;
	private	Long orderId;
	private Long productId;
	private int quantity;
	
	// 주문 정보 조회을 위해 변수 추가
	private Long memberId;
	private String pname;
	private LocalDateTime orderDate;
	private int pAmountPrice;
	private String paymentMethod;
	private String orderAddr;
	private String orderNotes;
	private String orderStatus;
	private LocalDateTime updateDate;
	private String imgName;
	private String imgPath;
	

	public Long getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public int getpAmountPrice() {
		return pAmountPrice;
	}
	public void setpAmountPrice(int pAmountPrice) {
		this.pAmountPrice = pAmountPrice;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getOrderAddr() {
		return orderAddr;
	}
	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}
	public String getOrderNotes() {
		return orderNotes;
	}
	public void setOrderNotes(String orderNotes) {
		this.orderNotes = orderNotes;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
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
	@Override
	public String toString() {
		return "OrderDetailDTO [orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", productId=" + productId
				+ ", quantity=" + quantity + ", memberId=" + memberId + ", pname=" + pname + ", orderDate=" + orderDate
				+ ", pAmountPrice=" + pAmountPrice + ", paymentMethod=" + paymentMethod + ", orderAddr=" + orderAddr
				+ ", orderNotes=" + orderNotes + ", orderStatus=" + orderStatus + ", updateDate=" + updateDate
				+ ", imgName=" + imgName + ", imgPath=" + imgPath + "]";
	}

	
}
