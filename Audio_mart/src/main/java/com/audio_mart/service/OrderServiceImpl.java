package com.audio_mart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audio_mart.domain.OrderDetailDTO;
import com.audio_mart.domain.OrdersDTO;
import com.audio_mart.mapper.OrderMapper;
import com.audio_mart.mapper.ProductMapper;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
	@Autowired
	ProductMapper productMapper;
	
	@Override
	public boolean addToOrder(OrdersDTO params) {
		Long orderId = orderMapper.insertOrder(params);
		System.out.println("주문 번호 " + orderId);
		return (orderId > 0) ? true : false ;
	}

	@Override
	public boolean addToOrderDetail(OrderDetailDTO params) {
		boolean queryResult = orderMapper.insertOrderDetail(params);
		
		Long orderId = params.getOrderId();
		Long memberId = params.getMemberId();
		boolean emptyCart = false;
		boolean orderCntResult = productMapper.increaseOrderCnt(orderId);
		boolean stockResult = productMapper.decreaseStock(orderId);
		
		if (!orderCntResult) {
			System.out.println("주문 수 증가 실패");
		}
		if (!stockResult) {
			System.out.println("재고 수 감소 실패");
		}
		if (queryResult) {
			emptyCart = orderMapper.emptyCartForOrder(memberId);
		}
		return emptyCart;
	}

	@Override
	public List<OrderDetailDTO> getOrderList(Long memberIdx) {
		return orderMapper.orderList(memberIdx); 
	}
}
