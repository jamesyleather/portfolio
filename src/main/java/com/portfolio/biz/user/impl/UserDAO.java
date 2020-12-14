package com.portfolio.biz.user.impl;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.biz.user.dto.UserVO;
import com.portfolio.biz.utils.Criteria;

@Repository
public class UserDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public void joinUser(UserVO vo) {
		System.out.println("==> Mybatis로 joinUser() 기능 처리");

		mybatis.insert("UserDAO.joinUser", vo);
	}

	public UserVO loginUser(UserVO vo) {
		System.out.println("==> Mybatis로 loginUser() 기능 처리");

		return mybatis.selectOne("UserDAO.loginUser", vo);
	}
	
	public UserVO snsLoginUser(UserVO vo) {
		System.out.println("==> Mybatis로 snsLoginUser() 기능 처리");
		return mybatis.selectOne("UserDAO.snsLoginUser", vo);
	}

	public UserVO idCheck(String id) {
		System.out.println("==> Mybatis로 idCheck() 기능 처리");

		UserVO user = mybatis.selectOne("UserDAO.idCheck", id);

		return user;
	}

	public UserVO findId(UserVO vo) {
		System.out.println("==> Mybatis로 findId() 기능 처리");
		return mybatis.selectOne("UserDAO.findId", vo);
	}

	public UserVO findPassword(UserVO vo) {
		System.out.println("==> Mybatis로 findPassword() 기능 처리");
		return mybatis.selectOne("UserDAO.findPassword", vo);
	}

	public void updatePassword(UserVO vo) {
		System.out.println("==> Mybatis로 updatePassword() 기능 처리");
		mybatis.update("UserDAO.updatePassword", vo);
	}
	
	public void updateUserInfo(UserVO vo) {
		System.out.println("==> Mybatis로 updateUserInfo() 기능 처리");
		mybatis.update("UserDAO.updateUserInfo", vo);
	}
	
	public List<UserVO> getUserListPaging(Criteria criteria, String name){
		System.out.println("==> Mybatis로 getUserListPaging() 기능 처리");
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("name", name);
		return mybatis.selectList("UserDAO.getUserListPaging", map);
	}
	
	public int totalUserCount() {
		System.out.println("==> Mybatis로 totalUserCount() 기능 처리");
		return mybatis.selectOne("UserDAO.totalUserCount");
	}
}
