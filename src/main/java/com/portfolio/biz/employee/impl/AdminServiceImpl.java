package com.portfolio.biz.employee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.biz.employee.AdminService;
import com.portfolio.biz.employee.dto.AdminVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public AdminVO getAdmin(AdminVO vo) {
		return adminDAO.getAdmin(vo);
	}

}
