package com.portfolio.biz.cart.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CartVO {
	private int cartnum;
	private String id;
	private int prodnum;
	private String mname; // 고객 이름
	private String pname; // 상품 이름
	private int quantity;
	private Timestamp indate;
	private int price2; // 상품 가격
	private String result;
	private String image;
}
