package com.portfolio.biz.product.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ProductVO {
	private int rn;
	private int prodnum;
	private String name;
	private String kind;
	private int price1;
	private int price2;
	private int price3;
	private String content;
	private String image;
	private String useyn;
	private Timestamp regdate;
	private int viewnum;
	private int prodimagenum;
	private String detail_image;
}
