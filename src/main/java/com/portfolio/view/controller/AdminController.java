package com.portfolio.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.portfolio.biz.employee.AdminService;
import com.portfolio.biz.employee.dto.AdminVO;
import com.portfolio.biz.order.OrderService;
import com.portfolio.biz.order.dto.OrderVO;
import com.portfolio.biz.product.ProductService;
import com.portfolio.biz.product.dto.ProductVO;
import com.portfolio.biz.qna.QnaService;
import com.portfolio.biz.qna.dto.QnaVO;
import com.portfolio.biz.utils.Criteria;
import com.portfolio.biz.utils.PageMaker;

@Controller
@SessionAttributes("adminUser")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private QnaService qnaService;

	@RequestMapping(value = "admin_form")
	public String adminView(HttpSession session, Model model) {
		AdminVO employee = (AdminVO) session.getAttribute("adminUser");

		if (employee == null) {
			return "admin/login";
		} else {
			int monthlyEarnings = orderService.monthlyEarnings();
			int annualEarnings = orderService.annualEarnings();
			int Tasks = orderService.beforeOrderHanling();
			int noReply = qnaService.beforeQnaAnswer();
			
			model.addAttribute("noReply", noReply);
			model.addAttribute("Tasks", Tasks);
			model.addAttribute("monthlyEarnings", monthlyEarnings);
			model.addAttribute("annualEarnings", annualEarnings);
			
			return "admin/index";
		}
	}

	@RequestMapping(value = "admin_login", method = RequestMethod.POST)
	public String adminLoginAction(AdminVO vo, Model model) {
		AdminVO adminUser = adminService.getAdmin(vo);

		if (adminUser == null) {
			model.addAttribute("message", "아이디와 비밀번호를 확인해주세요.");
			return "admin/login";
		} else {
			
			int monthlyEarnings = orderService.monthlyEarnings();
			int annualEarnings = orderService.annualEarnings();
			int Tasks = orderService.beforeOrderHanling();
			int noReply = qnaService.beforeQnaAnswer();
			
			model.addAttribute("noReply", noReply);
			model.addAttribute("Tasks", Tasks);
			model.addAttribute("monthlyEarnings", monthlyEarnings);
			model.addAttribute("annualEarnings", annualEarnings);
			model.addAttribute("adminUser", adminUser);
			return "admin/index";
		}
	}

	@RequestMapping(value = "admin_product_list")
	public String adminPorudctListPagingView(
			@RequestParam(value = "kind", defaultValue = "", required = false) String kind, Criteria criteria,
			HttpSession session, Model model) {
		AdminVO employee = (AdminVO) session.getAttribute("adminUser");

		if (employee == null) {
			return "admin/login";
		} else {
			List<ProductVO> productList = productService.getProductListPaging(kind, criteria);

			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria);

			int productCount = productService.countProductList(kind);
			pageMaker.setTotalCount(productCount);

			model.addAttribute("productList", productList);
			model.addAttribute("pageMaker", pageMaker);
			return "admin/product/productlist";
		}
	}

	/*
	 * @RequestMapping(value="admin_product_list") public String
	 * adminProductListView(HttpSession session, Model model) { AdminVO employee =
	 * (AdminVO) session.getAttribute("adminUser"); String[] kindList = {"", "bag",
	 * "wallet", "shoes", "acc"}; List<ProductVO> productList =
	 * productService.getProductList("");
	 * 
	 * if(employee == null) { return "admin/login"; } else {
	 * model.addAttribute("kindList", kindList); model.addAttribute("productList",
	 * productList);
	 * 
	 * return "admin/product/productlist"; } }
	 */

	@RequestMapping(value = "admin_enroll_product")
	public String adminEnrollProductView(HttpSession session, Model model) {
		AdminVO employee = (AdminVO) session.getAttribute("adminUser");
		String[] kindList = { "bag", "wallet", "shoes", "acc" };
		if (employee == null) {
			return "admin/login";
		} else {
			model.addAttribute("kindList", kindList);
			return "admin/product/enrollproduct";
		}
	}

	@RequestMapping(value = "admin_order_list")
	public String adminOrderListPagingView(
			@RequestParam(value = "mname", defaultValue = "", required = false) String mname, Criteria criteria,
			HttpSession session, Model model) {
		AdminVO employee = (AdminVO) session.getAttribute("adminUser");

		if (employee == null) {
			return "admin/login";
		} else {
			List<OrderVO> orderList = orderService.orderListPaging(mname, criteria);

			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria);

			int countOrder = orderService.countOrderList(mname);
			pageMaker.setTotalCount(countOrder);

			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("orderList", orderList);

			return "admin/order/orderlist";
		}
	}

	/*
	 * @RequestMapping(value="admin_order_list") public String
	 * adminOrderListView(HttpSession session, OrderVO vo, Model model) { AdminVO
	 * employee = (AdminVO) session.getAttribute("adminUser");
	 * 
	 * if(employee == null) { return "admin/login"; } else { vo.setMname("");
	 * List<OrderVO> orderList = orderService.orderList(vo);
	 * model.addAttribute("orderList", orderList); return "admin/order/orderlist"; }
	 * }
	 */

	@RequestMapping(value = "admin_start_order", method = RequestMethod.POST)
	public String startOrderAction(@RequestParam(value = "ordernum") int[] ordernum, HttpSession session) {
		AdminVO employee = (AdminVO) session.getAttribute("adminUser");

		if (employee == null) {
			return "admin/login";
		} else {
			for (int i = 0; i < ordernum.length; i++) {
				orderService.updateOrderResult(ordernum[i]);
			}
			return "redirect:admin_order_list";
		}
	}

	@RequestMapping(value = "admin_qna_list_form")
	public String adminQnaListPagingView(HttpSession session, Criteria criteria, Model model) {
		AdminVO employee = (AdminVO) session.getAttribute("adminUser");

		if (employee == null) {
			return "admin/login";
		} else {
			List<QnaVO> qnaList = qnaService.getQnaListPaging(criteria);

			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria);

			int qnaTotalCount = qnaService.countTotalQna();
			pageMaker.setTotalCount(qnaTotalCount);

			model.addAttribute("qnaList", qnaList);
			model.addAttribute("pageMaker", pageMaker);

			return "admin/board/qnalist";
		}
	}

	/*
	 * @RequestMapping(value="admin_qna_list_form") public String
	 * adminQnaListView(HttpSession session, Model model) { AdminVO employee =
	 * (AdminVO) session.getAttribute("adminUser");
	 * 
	 * if(employee == null) { return "admin/login"; } else { List<QnaVO> qnaList =
	 * qnaService.getQnaList(); model.addAttribute("qnaList", qnaList); return
	 * "admin/board/qnalist"; } }
	 */

	@RequestMapping(value = "admin_qna_detail")
	public String adminQnaDetailView(@RequestParam(value = "qnanum") int qnanum, HttpSession session, Model model) {
		AdminVO employee = (AdminVO) session.getAttribute("adminUser");

		if (employee == null) {
			return "admin/login";
		} else {
			QnaVO qna = qnaService.getQna(qnanum);
			model.addAttribute("qna", qna);
			return "admin/board/qnadetail";
		}
	}

	@RequestMapping(value = "admin_reply_qna", method = RequestMethod.POST)
	public String replyQnaAction(HttpSession session, Model model, QnaVO vo) {
		AdminVO employee = (AdminVO) session.getAttribute("adminUser");

		if (employee == null) {
			return "admin/login";
		} else {
			qnaService.replyQna(vo);

			QnaVO qna = qnaService.getQna(vo.getQnanum());

			model.addAttribute("qna", qna);

			return "admin_qna_list_form";
		}
	}
}
