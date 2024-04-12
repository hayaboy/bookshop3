package com.bookshop01.admin.member.service;

import com.green.bookshop3.member.vo.MemberVO;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface AdminMemberService {
	public ArrayList<MemberVO> listMember(HashMap condMap) throws Exception;
	public MemberVO memberDetail(String member_id) throws Exception;
	public void  modifyMemberInfo(HashMap memberMap) throws Exception;
}
