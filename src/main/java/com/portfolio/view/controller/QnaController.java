package com.portfolio.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.portfolio.biz.qna.QnaService;
import com.portfolio.biz.qna.dto.QnaVO;
import com.portfolio.biz.user.dto.UserVO;
import com.portfolio.biz.utils.Criteria;
import com.portfolio.biz.utils.PageMaker;

@Controller
public class QnaController {
	@Autowired
	private QnaService qnaService;

	@RequestMapping(value = "qna_form")
	public String QnaView(Model model, Criteria criteria) {
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(criteria);
		
		int totalCount = qnaService.countTotalQna();
		pageMaker.setTotalCount(totalCount);
		
		List<QnaVO> qnaList = qnaService.getQnaListPaging(criteria);

		model.addAttribute("qnaList", qnaList);
		model.addAttribute("pageMaker", pageMaker);
		return "board/qnalist";
	}

	@RequestMapping(value = "write_qna_form")
	public String WriteQnaView(HttpSession session) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			return "board/writeqna";
		}
	}

	@RequestMapping(value = "qna_write", method=RequestMethod.POST)
	public String WriteQnaAction(QnaVO vo, HttpSession session) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			vo.setId(loginUser.getId());
			qnaService.writeQna(vo);
			return "redirect:qna_form";
		}
	}

	@RequestMapping(value = "qna_detail")
	public String QnaDetailView(@RequestParam(value = "qnanum", defaultValue = "", required = false) int qnanum,
			Model model, HttpSession session) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		QnaVO qna = qnaService.getQna(qnanum);
		System.out.println("qna : " + qna);

		if (loginUser == null) {
			return "member/login";
		} else {
			if (!loginUser.getId().equals(qna.getId())) {
				return "board/qnaaccessfail";
			} else {
				model.addAttribute("qna", qna);
				return "board/qnadetail";
			}
		}
	}
	
	@RequestMapping(value="modify_qna_form")
	public String modifyQnaView(@RequestParam(value="qnanum", defaultValue="", required=false) int qnanum,
								HttpSession session, Model model) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			QnaVO qna = qnaService.getQna(qnanum);
			model.addAttribute("qna", qna);
			return "board/modifyqna";
		}
	}
	
	@RequestMapping(value="modify_qna", method=RequestMethod.POST)
	public String modifyQnaAction(HttpSession session, QnaVO vo, Model model) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "member/login";
		} else {
			qnaService.modifyQna(vo);
			model.addAttribute("qnanum", vo.getQnanum());
			return "redirect:qna_detail";
		}
	}
}
