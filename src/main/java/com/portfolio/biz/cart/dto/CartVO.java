package com.portfolio.biz.cart.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CartVO {
	private int cartnum;
	private String id;
	private int prodnum;
	private String mname; // �� �̸�
	private String pname; // ��ǰ �̸�
	private int quantity;
	private Timestamp indate;
	private int price2; // ��ǰ ����
	private String result;
	private String image;
}
