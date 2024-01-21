package com.audio_mart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audio_mart.domain.OrderDetailDTO;
import com.audio_mart.domain.OrdersDTO;
import com.audio_mart.mapper.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
	
	@Override
	public boolean addToOrder(OrdersDTO params) {
		Long orderId = orderMapper.insertOrder(params);
		System.out.println("주문 번호 " + orderId);
		return (orderId > 0) ? true : false ;
	}

	@Override
	public boolean addToOrderDetail(OrderDetailDTO params) {
		boolean queryResult = orderMapper.insertOrderDetail(params);
		boolean emptyCart = false;
		if (queryResult) {
			emptyCart = orderMapper.emptyCartForOrder(params.getMemberId());
		}
		return emptyCart;
	}
}
