package com.portfolio.biz.notice.impl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.biz.notice.dto.NoticeVO;
import com.portfolio.biz.utils.Criteria;

@Repository
public class NoticeDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void writeNotice(NoticeVO vo) {
		System.out.println("==> Mybatis로 writeNotice() 기능 처리");
		mybatis.insert("NoticeDAO.writeNotice", vo);
	}
	
	public int selectMaxNoticeNum() {
		System.out.println("==> Mybatis로 selectMaxNoticeNum() 기능 처리");
		return mybatis.selectOne("NoticeDAO.selectMaxNoticeNum");
	}
	
	public void insertNoticeImage(NoticeVO vo) {
		System.out.println("Mybatis로 insertNoticeImage() 기능 처리");
		mybatis.insert("NoticeDAO.insertNoticeImage", vo);
	}
	
	public List<NoticeVO> getNoticeList(Criteria criteria){
		System.out.println("Mybatis로 getNoticeList() 기능 처리");
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		return mybatis.selectList("NoticeDAO.getNoticeList", map);
	}
	
	public int noticeTotalCount() {
		System.out.println("Mybatis로 noticeTotalCount() 기능 처리");
		return mybatis.selectOne("NoticeDAO.noticeTotalCount");
	}
	
	public List<NoticeVO> getNoticeDetail(int noticenum) {
		System.out.println("Mybatis로 getNoticeDetail() 기능 처리");
		return mybatis.selectList("NoticeDAO.getNoticeDetail", noticenum);
	}
	
	public void writeComment(NoticeVO vo) {
		System.out.println("Mybatis로 writeComment() 기능 처리");
		mybatis.insert("NoticeDAO.writeComment", vo);
	}
	
	public List<NoticeVO> commentList(int noticenum){
		System.out.println("Mybatis로 commentList() 기능 처리");
		return mybatis.selectList("NoticeDAO.commentList", noticenum);
	}
}
