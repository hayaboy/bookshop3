package com.green.bookshop3.mypage.dao;

import java.util.List;
import java.util.Map;

import com.green.bookshop3.member.vo.MemberVO;
import com.green.bookshop3.order.vo.OrderVO;
import org.springframework.dao.DataAccessException;


public interface MyPageDAO {
	public List<OrderVO> selectMyOrderGoodsList(String member_id) throws DataAccessException;
	public List selectMyOrderInfo(String order_id) throws DataAccessException;
	public List<OrderVO> selectMyOrderHistoryList(Map dateMap) throws DataAccessException;
	public void updateMyInfo(Map memberMap) throws DataAccessException;
	public MemberVO selectMyDetailInfo(String member_id) throws DataAccessException;
	public void updateMyOrderCancel(String order_id) throws DataAccessException;
}
