package com.audio_mart.service;

import com.audio_mart.domain.OrderDetailDTO;
import com.audio_mart.domain.OrdersDTO;

public interface OrderService {
	
	// 주문하기
	public boolean addToOrder(OrdersDTO params);
	// 주문 상세 정보 저장하기
	public boolean addToOrderDetail(OrderDetailDTO params);

}
