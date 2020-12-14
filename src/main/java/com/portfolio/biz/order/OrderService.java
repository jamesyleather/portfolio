package com.portfolio.biz.order;

import java.util.List;

import com.portfolio.biz.order.dto.OrderVO;
import com.portfolio.biz.utils.Criteria;

public interface OrderService {

	int selectMaxOrdernum();

	int insertOrder(OrderVO vo);

	void insertOrderDetail(OrderVO vo);
	
	void updateCartResult(int cartnum);
	
	List<OrderVO> selectOrderListById(OrderVO vo);
	
	List<Integer> selectSeqOrdering(OrderVO vo);
	
	List<OrderVO> orderList(OrderVO vo);
	
	void updateOrderResult(int ordernum);
	
	List<OrderVO> orderListPaging(String mname, Criteria criteria);
	
	int countOrderList(String mname);
	
	int monthlyEarnings();
	
	int annualEarnings();
	
	int beforeOrderHanling();

}