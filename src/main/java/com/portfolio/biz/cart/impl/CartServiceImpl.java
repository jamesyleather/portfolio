package com.portfolio.biz.cart.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.biz.cart.CartService;
import com.portfolio.biz.cart.dto.CartVO;

@Service("cartService")
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDAO;
	
	@Override
	public void insertCart(CartVO vo) {
		cartDAO.insertCart(vo);
	}

	@Override
	public List<CartVO> getCartList(String id) {
		return cartDAO.getCartList(id);
	}

	@Override
	public void deleteCartlist(int cartnum) {
		cartDAO.deleteCartlist(cartnum);
	}

}
