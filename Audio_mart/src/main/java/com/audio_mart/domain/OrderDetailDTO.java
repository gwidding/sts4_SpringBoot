package com.audio_mart.domain;

public class OrderDetailDTO {
	
	private Long orderDetailId;
	private	Long orderId;
	private Long productId;
	private int quantity;
	
	private Long memberId;

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
	@Override
	public String toString() {
		return "OrderDetailDTO [orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", productId=" + productId
				+ ", quantity=" + quantity + ", memberId=" + memberId + "]";
	}	
	
}
