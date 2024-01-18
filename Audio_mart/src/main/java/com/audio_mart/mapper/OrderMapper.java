package com.audio_mart.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.audio_mart.domain.OrderDetailDTO;
import com.audio_mart.domain.OrdersDTO;

@Mapper
public interface OrderMapper {
	public boolean insertOrder(OrdersDTO params);
	public boolean insertOrderDetail(OrderDetailDTO params);

}
