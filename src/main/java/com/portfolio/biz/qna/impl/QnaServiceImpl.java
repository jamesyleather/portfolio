package com.portfolio.biz.qna.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.biz.qna.QnaService;
import com.portfolio.biz.qna.dto.QnaVO;
import com.portfolio.biz.utils.Criteria;

@Service("qnaService")
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public List<QnaVO> getQnaList() {
		return qnaDAO.getQnaList();
	}

	@Override
	public void writeQna(QnaVO vo) {
		qnaDAO.writeQna(vo);
		
	}

	@Override
	public QnaVO getQna(int qnanum) {
		return qnaDAO.getQna(qnanum);
	}

	@Override
	public void modifyQna(QnaVO vo) {
		qnaDAO.modifyQna(vo);
	}

	@Override
	public void replyQna(QnaVO vo) {
		qnaDAO.replyQna(vo);
	}

	@Override
	public List<QnaVO> getQnaListPaging(Criteria criteria) {
		return qnaDAO.getQnaListPaging(criteria);
	}

	@Override
	public int countTotalQna() {
		return qnaDAO.countTotalQna();
	}

	@Override
	public int beforeQnaAnswer() {
		return qnaDAO.beforeQnaAnswer();
	}

}
