package com.portfolio.biz.order.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class OrderVO {
	private int odnum; // order detail  number
	private int ordernum;
	private String id;
	private Timestamp indate;
	private int prodnum;
	private int quantity;
	private String mname;
	private String zip_code;
	private String address;
	private String phone;
	private String pname;
	private int price2;
	private String result;
	private String image;
	
}
