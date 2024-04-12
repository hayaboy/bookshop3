package com.green.bookshop3.admin.goods.service;

import com.green.bookshop3.goods.vo.GoodsVO;
import com.green.bookshop3.goods.vo.ImageFileVO;
import com.green.bookshop3.order.vo.OrderVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public interface AdminGoodsService {
	public int  addNewGoods(Map newGoodsMap) throws Exception;
	public List<GoodsVO> listNewGoods(Map condMap) throws Exception;
	public Map goodsDetail(int goods_id) throws Exception;
	public List goodsImageFile(int goods_id) throws Exception;
	public void modifyGoodsInfo(Map goodsMap) throws Exception;
	public void modifyGoodsImage(List<ImageFileVO> imageFileList) throws Exception;
	public List<OrderVO> listOrderGoods(Map condMap) throws Exception;
	public void modifyOrderGoods(Map orderMap) throws Exception;
	public void removeGoodsImage(int image_id) throws Exception;
	public void addNewGoodsImage(List imageFileList) throws Exception;
	
}
