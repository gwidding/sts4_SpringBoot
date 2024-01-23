package com.audio_mart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.audio_mart.domain.OrderDetailDTO;
import com.audio_mart.domain.OrdersDTO;

@Mapper
public interface OrderMapper {
	
	public Long insertOrder(OrdersDTO params);
	public boolean insertOrderDetail(OrderDetailDTO params);
	
	public boolean emptyCartForOrder(Long memberIdx);
	
	public List<OrderDetailDTO> orderList(Long memberIdx);

}
