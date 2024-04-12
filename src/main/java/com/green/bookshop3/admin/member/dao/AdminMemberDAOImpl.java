package com.green.bookshop3.admin.member.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.green.bookshop3.member.vo.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;



@Repository("adminMemberDao")
public class AdminMemberDAOImpl  implements com.bookshop01.admin.member.dao.AdminMemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	
	public ArrayList<MemberVO> listMember(HashMap condMap) throws DataAccessException{
		ArrayList<MemberVO>  memberList=(ArrayList)sqlSession.selectList("mapper.admin.member.listMember",condMap);
		return memberList;
	}
	
	public MemberVO memberDetail(String member_id) throws DataAccessException{
		MemberVO memberBean=(MemberVO)sqlSession.selectOne("mapper.admin.member.memberDetail",member_id);
		return memberBean;
	}
	
	public void modifyMemberInfo(HashMap memberMap) throws DataAccessException{
		sqlSession.update("mapper.admin.member.modifyMemberInfo",memberMap);
	}
	
	

}
