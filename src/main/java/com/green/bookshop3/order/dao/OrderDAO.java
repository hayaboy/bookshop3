package com.green.bookshop3.order.dao;

import java.util.ArrayList;
import java.util.List;

import com.green.bookshop3.order.vo.OrderVO;
import org.springframework.dao.DataAccessException;



public interface OrderDAO {
	public List<OrderVO> listMyOrderGoods(OrderVO orderBean) throws DataAccessException;
	public void insertNewOrder(List<OrderVO> myOrderList) throws DataAccessException;
	public OrderVO findMyOrder(String order_id) throws DataAccessException;
	public void removeGoodsFromCart(List<OrderVO> myOrderList)throws DataAccessException;
}
