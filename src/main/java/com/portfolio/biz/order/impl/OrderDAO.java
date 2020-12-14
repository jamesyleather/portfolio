package com.portfolio.biz.order.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.biz.order.dto.OrderVO;
import com.portfolio.biz.utils.Criteria;

@Repository
public class OrderDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int selectMaxOrdernum() {
		System.out.println("==> Mybatis로 selectMaxOrdernum() 기능 처리");
		return mybatis.selectOne("OrderDAO.selectMaxOrdernum");
	}
	
	public void insertOrder(OrderVO vo) {
		System.out.println("==> Mybatis로 insertOrder() 기능 처리");
		mybatis.insert("OrderDAO.insertOrder", vo);
	}
	
	public void insertOrderDetail(OrderVO vo) {
		System.out.println("==> Mybatis로 insertOrderDetail() 기능 처리");
		mybatis.insert("OrderDAO.insertOrderDetail", vo);
	}
	
	public void updateCartResult(int cartnum) {
		System.out.println("==> Mybatis로 updateCartREsult() 기능 처리");
		mybatis.update("CartDAO.updateCartResult", cartnum);
	}
	
	public List<OrderVO> selectOrderListById(OrderVO vo){
		System.out.println(" ==> Mybatis로 selectOrderListById() 기능 처리");
		return mybatis.selectList("OrderDAO.selectOrderListById", vo);
	}
	
	public List<Integer> selectSeqOrdering(OrderVO vo){
		System.out.println("==> Mybatis로 selectSeqOrdering() 기능 처리");
		return mybatis.selectList("OrderDAO.selectSeqOrdering", vo);
	}
	
	public List<OrderVO> orderList(OrderVO vo){
		System.out.println("==> Mybatis로 orderList() 기능 처리");
		return mybatis.selectList("OrderDAO.orderList", vo);
	}
	
	public List<OrderVO> orderListPaging(String mname, Criteria criteria){
		System.out.println("==> Mybatis로 orderListPaging() 기능 처리");
		HashMap<String, Object> map = new HashMap<>();
		map.put("mname", mname);
		map.put("criteria", criteria);
		return mybatis.selectList("OrderDAO.orderListPaging", map);
	}
	
	public void updateOrderResult(int ordernum) {
		System.out.println("==> Mybatis로 updateOrderResult() 기능 처리");
		mybatis.update("OrderDAO.updateOrderResult", ordernum);
	}
	
	public int countOrderList(String mname) {
		System.out.println("==> Mybatis로 countOrderList() 기능 처리");
		return mybatis.selectOne("OrderDAO.countOrderList", mname);
	}
	
	public List<OrderVO> monthlyEarnings(){
		System.out.println("==> Mybatis로 monthlyEarnings() 기능 처리");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		Date time = new Date();
		
		String month = dateFormat.format(time).substring(2,4);
		return mybatis.selectList("OrderDAO.monthlyEarnings", month);
	}
	
	public List<OrderVO> annualEarnings(){
		System.out.println("==> Mybatis로 annualEarnings() 기능 처리");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		Date time = new Date();
		
		String year = dateFormat.format(time).substring(0,2);
		return mybatis.selectList("OrderDAO.annualEarnings", year);
	}
	
	public int beforeOrderHanling() {
		System.out.println("==> Mybatis로 beforeOrderHanling() 기능 처리");
		return mybatis.selectOne("OrderDAO.beforeOrderHanling");
	}
}
