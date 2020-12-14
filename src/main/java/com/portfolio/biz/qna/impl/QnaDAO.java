package com.portfolio.biz.qna.impl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.biz.qna.dto.QnaVO;
import com.portfolio.biz.utils.Criteria;

@Repository
public class QnaDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<QnaVO> getQnaList(){
		System.out.println("==> Mybatis로 getQnaList() 기능 처리");
		return mybatis.selectList("QnaDAO.getQnaList");
	}
	
	public void writeQna(QnaVO vo) {
		System.out.println("==> Mybatis로 writeQna() 기능 처리");
		mybatis.insert("QnaDAO.writeQna", vo);
	}
	
	public QnaVO getQna(int qnanum) {
		System.out.println("==> Mybatis로 getQna() 기능 처리");
		return mybatis.selectOne("QnaDAO.getQna", qnanum);
	}
	
	public void modifyQna(QnaVO vo) {
		System.out.println("==> Mybatis로 modifyQna() 기능 처리");
		mybatis.update("QnaDAO.modifyQna", vo);
	}
	
	public void replyQna(QnaVO vo) {
		System.out.println("==> Mybaits로 replyQna() 기능 처리");
		mybatis.update("QnaDAO.replyQna", vo);	
	}
	
	public List<QnaVO> getQnaListPaging(Criteria criteria){
		System.out.println("==> Mybatis로 getQnaListPaging() 기능 처리");
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		return mybatis.selectList("QnaDAO.getQnaListPaging", map);
	}
	
	public int countTotalQna() {
		System.out.println("==> Mybatis로 countTotalQna() 기능 처리");
		return mybatis.selectOne("QnaDAO.countTotalQna");
	}
	
	public int beforeQnaAnswer() {
		System.out.println("beforeQnaAnswer");
		return mybatis.selectOne("QnaDAO.beforeQnaAnswer");
	}
}
