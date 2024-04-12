package com.green.bookshop3.order.service;

import com.green.bookshop3.order.vo.OrderVO;

import java.util.List;
import java.util.Map;



public interface OrderService {
	public List<OrderVO> listMyOrderGoods(OrderVO orderVO) throws Exception;
	public void addNewOrder(List<OrderVO> myOrderList) throws Exception;
	public OrderVO findMyOrder(String order_id) throws Exception;
	
	
}
