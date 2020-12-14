package com.portfolio.biz.user;

import java.util.List;

import com.portfolio.biz.user.dto.UserVO;
import com.portfolio.biz.utils.Criteria;

public interface UserService {

	void joinUser(UserVO vo);

	UserVO loginUser(UserVO vo);

	UserVO idCheck(String id);
	
	UserVO findId(UserVO vo);
	
	UserVO findPassword(UserVO vo);
	
	void updatePassword(UserVO vo);
	
	void updateUserInfo(UserVO vo);
	
	List<UserVO> getUserListPaging(Criteria criteria, String name);
	
	int totalUserCount();
	
	UserVO snsLoginUser(UserVO vo);
}