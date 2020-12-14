package com.portfolio.biz.user.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class UserVO {
	private String id;
	private String pwd;
	private String name;
	private String zip_code;
	private String address;
	private String phone;
	private int useyn;
	private Timestamp regdate;
	private String email;
	private String googleid;
	private String naverid;
}
