package com.portfolio.biz.notice;

import java.util.List;

import com.portfolio.biz.notice.dto.NoticeVO;
import com.portfolio.biz.utils.Criteria;

public interface NoticeService {

	void writeNotice(NoticeVO vo);
	
	int selectMaxNoticeNum();
	
	void insertNoticeImage(NoticeVO vo);
	
	List<NoticeVO> getNoticeList(Criteria criteria);
	
	int noticeTotalCount();
	
	List<NoticeVO> getNoticeDetail(int noticenum);
	
	void writeComment(NoticeVO vo);
	
	List<NoticeVO> commentList(int noticenum);

}