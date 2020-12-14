package com.portfolio.biz.cart.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.biz.cart.dto.CartVO;

@Repository
public class CartDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertCart(CartVO vo) {
		System.out.println("==> Mybatis�� insertCart() ��� ó��");
		mybatis.insert("CartDAO.insertCart", vo);
	}
	
	public List<CartVO> getCartList(String id){
		System.out.println("==> Mybatis�� getCartList() ��� ó��");
		return mybatis.selectList("CartDAO.getCartList", id);
	}
	
	public void deleteCartlist(int cartnum) {
		System.out.println("==> Mybatis�� deleteCartlist() ��� ó��");
		mybatis.delete("CartDAO.deleteCartlist", cartnum);
	}
	
}
