package com.green.bookshop3.admin.order.dao;

import java.util.ArrayList;
import java.util.Map;

import com.green.bookshop3.member.vo.MemberVO;
import com.green.bookshop3.order.vo.OrderVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;



@Repository("adminOrderDAO")
public class AdminOrderDAOImpl  implements com.bookshop01.admin.order.dao.AdminOrderDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public ArrayList<OrderVO>selectNewOrderList(Map condMap) throws DataAccessException{
		ArrayList<OrderVO>  orderList=(ArrayList)sqlSession.selectList("mapper.admin.order.selectNewOrderList",condMap);
		return orderList;
	}
	public void  updateDeliveryState(Map deliveryMap) throws DataAccessException{
		sqlSession.update("mapper.admin.order.updateDeliveryState",deliveryMap);
	}
	
	public ArrayList<OrderVO> selectOrderDetail(int order_id) throws DataAccessException{
		ArrayList<OrderVO> orderList=(ArrayList)sqlSession.selectList("mapper.admin.order.selectOrderDetail",order_id);
		return orderList;
	}


	public MemberVO selectOrderer(String member_id) throws DataAccessException{
		MemberVO orderer=(MemberVO)sqlSession.selectOne("mapper.admin.order.selectOrderer",member_id);
		return orderer;
		
	}

}
