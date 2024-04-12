package com.bookshop01.admin.member.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.green.bookshop3.member.vo.MemberVO;
import org.springframework.dao.DataAccessException;



public interface AdminMemberDAO {
	public ArrayList<MemberVO> listMember(HashMap condMap) throws DataAccessException;
	public MemberVO memberDetail(String member_id) throws DataAccessException;
	public void modifyMemberInfo(HashMap memberMap) throws DataAccessException;
}
