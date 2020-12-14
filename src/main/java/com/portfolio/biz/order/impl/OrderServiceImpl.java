package com.portfolio.biz.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.biz.cart.CartService;
import com.portfolio.biz.cart.dto.CartVO;
import com.portfolio.biz.order.OrderService;
import com.portfolio.biz.order.dto.OrderVO;
import com.portfolio.biz.utils.Criteria;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private CartService cartService;
	@Override
	public int selectMaxOrdernum() {
		return orderDAO.selectMaxOrdernum();
	}

	@Override
	public int insertOrder(OrderVO vo) {
		// 주문번호 생성
		int ordernum = orderDAO.selectMaxOrdernum();
		
		// 주문번호 설정
		vo.setOrdernum(ordernum);
		
		// 주문번호 입력
		orderDAO.insertOrder(vo);
		
		// 카트에 있는 데이터 가져오기
		CartVO cart = new CartVO();
		cart.setId(vo.getId());
		List<CartVO> listCart = cartService.getCartList(cart.getId());
		
		// 주문 상세 정보 입력
		for(CartVO item : listCart) {
			OrderVO order = new OrderVO();
			
			order.setOrdernum(ordernum);
			order.setProdnum(item.getProdnum());
			order.setQuantity(item.getQuantity());
			
			orderDAO.insertOrderDetail(order);
			
			updateCartResult(item.getCartnum());
		}
		
		// 주문번호 반환
		return ordernum;
	}

	@Override
	public void insertOrderDetail(OrderVO vo) {
		orderDAO.insertOrderDetail(vo);
	}

	@Override
	public void updateCartResult(int cartnum) {
		orderDAO.updateCartResult(cartnum);
	}

	@Override
	public List<OrderVO> selectOrderListById(OrderVO vo) {
		return orderDAO.selectOrderListById(vo);
	}

	@Override
	public List<Integer> selectSeqOrdering(OrderVO vo) {
		return orderDAO.selectSeqOrdering(vo);
	}

	@Override
	public List<OrderVO> orderList(OrderVO vo) {
		return orderDAO.orderList(vo);
	}

	@Override
	public void updateOrderResult(int ordernum) {
		orderDAO.updateOrderResult(ordernum);
	}

	@Override
	public List<OrderVO> orderListPaging(String mname, Criteria criteria) {
		return orderDAO.orderListPaging(mname, criteria);
	}

	@Override
	public int countOrderList(String mname) {
		return orderDAO.countOrderList(mname);
	}

	@Override
	public int monthlyEarnings() {
		List<OrderVO> mothlyEarnings = orderDAO.monthlyEarnings();
		int totalEarnings = 0;
		for (OrderVO earning : mothlyEarnings) {
			totalEarnings += earning.getPrice2();
		}
		return totalEarnings;
	}

	@Override
	public int annualEarnings() {
		List<OrderVO> annualEarnings = orderDAO.annualEarnings();
		int totalEarnings = 0;
		for (OrderVO earning : annualEarnings) {
			totalEarnings += earning.getPrice2();
		}
		return totalEarnings;
	}

	@Override
	public int beforeOrderHanling() {
		return orderDAO.beforeOrderHanling();
	}
}
