package com.portfolio.biz.notice.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class NoticeVO {
	private int noticenum;
	private String title;
	private String content;
	private String id;
	private Timestamp indate;
	private String kind;
	private String image;
	private int noticeimagenum;
	private int commentnum;
}
