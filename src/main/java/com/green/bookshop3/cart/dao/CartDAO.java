package com.green.bookshop3.cart.dao;

import java.util.List;

import com.green.bookshop3.cart.vo.CartVO;
import com.green.bookshop3.goods.vo.GoodsVO;
import org.springframework.dao.DataAccessException;


public interface CartDAO {
	public List<CartVO> selectCartList(CartVO cartVO) throws DataAccessException;
	public List<GoodsVO> selectGoodsList(List<CartVO> cartList) throws DataAccessException;
	public boolean selectCountInCart(CartVO cartVO) throws DataAccessException;
	public int insertGoodsInCart(CartVO cartVO) throws DataAccessException;
	public void updateCartGoodsQty(CartVO cartVO) throws DataAccessException;
	public void deleteCartGoods(int cart_id) throws DataAccessException;
	
	

}
