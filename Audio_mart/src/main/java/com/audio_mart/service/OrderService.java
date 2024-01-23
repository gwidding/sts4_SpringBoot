package com.audio_mart.service;

import java.util.List;

import com.audio_mart.domain.OrderDetailDTO;
import com.audio_mart.domain.OrdersDTO;

public interface OrderService {
	
	// 주문하기
	public boolean addToOrder(OrdersDTO params);
	// 주문 상세 정보 저장하기
	public boolean addToOrderDetail(OrderDetailDTO params);
	
	// 해당 회원 전체 주문 목록 가져오기
	public List<OrderDetailDTO> getOrderList(Long memberIdx);

}
