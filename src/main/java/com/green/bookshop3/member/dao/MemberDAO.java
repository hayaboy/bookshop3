package com.green.bookshop3.member.dao;

import java.util.Map;

import com.green.bookshop3.member.vo.MemberVO;
import org.springframework.dao.DataAccessException;

import com.green.bookshop3.member.vo.MemberVO;

public interface MemberDAO {
	public MemberVO login(Map loginMap) throws DataAccessException;
	public void insertNewMember(MemberVO memberVO) throws DataAccessException;
	public String selectOverlappedID(String id) throws DataAccessException;
}
