package com.audio_mart.domain;

import java.time.LocalDateTime;

public class OrdersDTO {
	/*
	 * order_id int not null auto_increment primary key , 
	 * member_idx int not null ,
	 * price int not null , 
	 * payment_method ENUM('신용카드', '계좌이체', '무통장입금') ,
	 * order_addr varchar(60) not null , 
	 * order_notes varchar(60) not null ,
	 * order_date datetime not null default NOW() , 
	 * update_date datetime null ,
	 * order_status ENUM('정상', '환불', '교환') not null default '정상'
	 * 
	 * ,foreign key (member_idx) references member(idx)
	 */
	private Long orderId;
	private Long memberIdx;
	private int price;
	private String paymentMethod;
	private String orderAddr;
	private String orderNotes;
	private LocalDateTime orderDate;
	private LocalDateTime updateDate;
	private String orderStatus;
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(Long memberIdx) {
		this.memberIdx = memberIdx;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "OrdersDTO [orderId=" + orderId + ", memberIdx=" + memberIdx + ", price=" + price + ", paymentMethod="
				+ paymentMethod + ", orderAddr=" + orderAddr + ", orderNotes=" + orderNotes + ", orderDate=" + orderDate
				+ ", updateDate=" + updateDate + ", orderStatus=" + orderStatus + "]";
	}
}
