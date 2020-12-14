package com.portfolio.biz.qna.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class QnaVO {
	private int qnanum;
	private String subject;
	private String content;
	private String reply;
	private String id;
	private String rep;
	private Timestamp indate;
	private String kind;
}
