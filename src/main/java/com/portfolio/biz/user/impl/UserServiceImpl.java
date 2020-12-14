package com.portfolio.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.biz.user.UserService;
import com.portfolio.biz.user.dto.UserVO;
import com.portfolio.biz.utils.Criteria;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	@Override
	public void joinUser(UserVO vo) {
		userDAO.joinUser(vo);
	}

	@Override
	public UserVO loginUser(UserVO vo) {
		return userDAO.loginUser(vo);
	}

	@Override
	public UserVO idCheck(String id) {
		return userDAO.idCheck(id);
	}

	@Override
	public UserVO findId(UserVO vo) {
		return userDAO.findId(vo);
	}

	@Override
	public UserVO findPassword(UserVO vo) {
		return userDAO.findPassword(vo);
	}

	@Override
	public void updatePassword(UserVO vo) {
		userDAO.updatePassword(vo);
	}

	@Override
	public void updateUserInfo(UserVO vo) {
		userDAO.updateUserInfo(vo);
	}

	@Override
	public List<UserVO> getUserListPaging(Criteria criteria, String name) {
		return userDAO.getUserListPaging(criteria, name);
	}

	@Override
	public int totalUserCount() {
		return userDAO.totalUserCount();
	}

	@Override
	public UserVO snsLoginUser(UserVO vo) {
		return userDAO.snsLoginUser(vo);
	}
}
