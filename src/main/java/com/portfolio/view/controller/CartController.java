package com.portfolio.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.portfolio.biz.cart.CartService;
import com.portfolio.biz.cart.dto.CartVO;
import com.portfolio.biz.user.dto.UserVO;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="cart_action")
	public String insertCartAction(HttpSession session, CartVO vo) {
		UserVO user = (UserVO) session.getAttribute("loginUser");
		
		if(user == null) {
			return "member/login";
		} else {
			vo.setId(user.getId());
			cartService.insertCart(vo);
			return "redirect:category";
		}
	}
	
	@RequestMapping(value="cart_form")
	public String getCartListView(HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("loginUser");
		int totalPrice = 0;
		
		if(user == null) {
			return "member/login";					
		} else {
			List<CartVO> cartList = cartService.getCartList(user.getId());
			for(CartVO cart : cartList) {
				totalPrice += cart.getPrice2();
			}
			
			model.addAttribute("cartList", cartList);
			model.addAttribute("totalPrice", totalPrice);
			
			return "mypage/cartlist";
		}
	}
	
	@RequestMapping(value="delete_cartlist", method = RequestMethod.POST)
	public String deleteCartlistAction(@RequestParam(value="cartnum") int[] cartnum) {
		for(int i = 0; i < cartnum.length; i++) {
			cartService.deleteCartlist(cartnum[i]);
		}
		
		return "redirect:cart_form";
	}
}
