package com.portfolio.biz.qna;

import java.util.List;

import com.portfolio.biz.qna.dto.QnaVO;
import com.portfolio.biz.utils.Criteria;

public interface QnaService {

	List<QnaVO> getQnaList();
	
	void writeQna(QnaVO vo);
	
	QnaVO getQna(int qnanum);
	
	void modifyQna(QnaVO vo);
	
	void replyQna(QnaVO vo);
	
	List<QnaVO> getQnaListPaging(Criteria criteria);
	
	int countTotalQna();
	
	int beforeQnaAnswer();

}