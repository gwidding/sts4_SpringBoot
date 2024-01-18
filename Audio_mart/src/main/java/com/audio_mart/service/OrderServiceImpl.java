package com.audio_mart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audio_mart.domain.OrderDetailDTO;
import com.audio_mart.domain.OrdersDTO;
import com.audio_mart.mapper.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }
	
	@Override
	public boolean addToOrder(OrdersDTO params) {
		boolean queryResult = orderMapper.insertOrder(params);
		
		return false;
	}

	@Override
	public boolean addToOrder(OrderDetailDTO params) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
