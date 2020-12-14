package com.portfolio.view.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.portfolio.biz.order.OrderService;
import com.portfolio.biz.order.dto.OrderVO;
import com.portfolio.biz.user.dto.UserVO;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "order_product")
	public String orderProdctAction(HttpSession session, OrderVO vo, Model model) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			vo.setId(loginUser.getId());
			int ordernum = orderService.insertOrder(vo);
			model.addAttribute("ordernum", ordernum);

			return "redirect:order_list";
		}
	}

	@RequestMapping(value = "order_list")
	public String orderListView(OrderVO vo, HttpSession session, Model model) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			vo.setId(loginUser.getId());
			vo.setResult("1");

			List<OrderVO> orderList = orderService.selectOrderListById(vo);

			int totalPrice = 0;

			for (OrderVO order : orderList) {
				totalPrice += order.getPrice2();
			}

			model.addAttribute("orderList", orderList);
			model.addAttribute("totalPrice", totalPrice);
			return "mypage/orderlist";
		}
	}

	@RequestMapping(value = "order_form")
	public String AllOrderListView(Model model, HttpSession session) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			OrderVO order = new OrderVO();
			order.setId(loginUser.getId());
			order.setResult("");

			// 주문번호 불러오기
			List<Integer> ordernumList = orderService.selectSeqOrdering(order);

			// 주문 상세 현황 입력할 배열 설정하기
			List<OrderVO> orderList = new ArrayList<OrderVO>();

			// 불러온 주문번호로 주문상세내역 불러오기
			for (int ordernum : ordernumList) {
				OrderVO vo = new OrderVO();
				vo.setId(loginUser.getId());
				vo.setOrdernum(ordernum);
				vo.setResult("");

				// 아이디로 전체 주문내역 조회하기
				List<OrderVO> orderListing = orderService.selectOrderListById(vo);

				// item = 전체 주문 페이지에서 보여질 첫번째 주문 품목
				OrderVO item = orderListing.get(0);
				
				if(orderListing.size() > 1) {
					item.setPname(item.getPname() + " 외 " + (orderListing.size() - 1) + "건");
				}
				

				int totalPrice = 0;

				for (int i = 0; i < orderListing.size(); i++) {
					totalPrice += orderListing.get(i).getPrice2() * orderListing.get(i).getQuantity();
				}

				item.setPrice2(totalPrice);

				orderList.add(item);
			}

			model.addAttribute("orderList", orderList);
			return "mypage/orderstatus";
		}
	}

	@RequestMapping(value = "order_detail")
	public String orderDetailView(@RequestParam(value = "ordernum", defaultValue = "", required = false) int ordernum,
			HttpSession session, Model model) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {

			OrderVO vo = new OrderVO();
			vo.setId(loginUser.getId());
			vo.setOrdernum(ordernum);
			vo.setResult("");

			// 주문번호로 주문한 내역 조회
			List<OrderVO> orderList = orderService.selectOrderListById(vo);

			// 상단 주문 내역 조회
			OrderVO orderDetail = new OrderVO();
			orderDetail.setIndate(orderList.get(0).getIndate());
			orderDetail.setOrdernum(orderList.get(0).getProdnum());
			orderDetail.setMname(orderList.get(0).getMname());

			// totalPrice
			int totalPrice = 0;
			for (int i = 0; i < orderList.size(); i++) {
				totalPrice += (orderList.get(i).getPrice2() * orderList.get(i).getQuantity());
			}

			model.addAttribute("orderList", orderList);
			model.addAttribute("orderDetail", orderDetail);
			model.addAttribute("totalPrice", totalPrice);

			return "mypage/orderdetail";

		}
	}
}
