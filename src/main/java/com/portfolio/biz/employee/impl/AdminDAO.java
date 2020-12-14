package com.portfolio.biz.employee.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.biz.employee.dto.AdminVO;

@Repository
public class AdminDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public AdminVO getAdmin(AdminVO vo) {
		System.out.println("==> Mybatis로 getAdmin() 기능 처리");
		AdminVO admin = mybatis.selectOne("AdminDAO.getAdmin", vo);
		return admin;
	}
}
