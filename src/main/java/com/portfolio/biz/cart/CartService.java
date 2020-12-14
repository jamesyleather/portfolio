package com.portfolio.biz.cart;

import java.util.List;

import com.portfolio.biz.cart.dto.CartVO;

public interface CartService {

	void insertCart(CartVO vo);
	
	List<CartVO> getCartList(String id);
	
	void deleteCartlist(int cartnum);

}