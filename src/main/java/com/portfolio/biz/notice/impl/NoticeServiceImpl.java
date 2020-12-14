package com.portfolio.biz.notice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.biz.notice.NoticeService;
import com.portfolio.biz.notice.dto.NoticeVO;
import com.portfolio.biz.utils.Criteria;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public void writeNotice(NoticeVO vo) {
		noticeDAO.writeNotice(vo);
	}

	@Override
	public int selectMaxNoticeNum() {
		return noticeDAO.selectMaxNoticeNum();
	}

	@Override
	public void insertNoticeImage(NoticeVO vo) {
		noticeDAO.insertNoticeImage(vo);
	}

	@Override
	public List<NoticeVO> getNoticeList(Criteria criteria) {
		return noticeDAO.getNoticeList(criteria);
	}

	@Override
	public int noticeTotalCount() {
		return noticeDAO.noticeTotalCount();
	}

	@Override
	public List<NoticeVO> getNoticeDetail(int noticenum) {
		return noticeDAO.getNoticeDetail(noticenum);
	}

	@Override
	public void writeComment(NoticeVO vo) {
		noticeDAO.writeComment(vo);
	}

	@Override
	public List<NoticeVO> commentList(int noticenum) {
		return noticeDAO.commentList(noticenum);
	}

}
