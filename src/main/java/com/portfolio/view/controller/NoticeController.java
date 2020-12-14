package com.portfolio.view.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.portfolio.biz.employee.dto.AdminVO;
import com.portfolio.biz.notice.NoticeService;
import com.portfolio.biz.notice.dto.NoticeVO;
import com.portfolio.biz.user.dto.UserVO;
import com.portfolio.biz.utils.Criteria;
import com.portfolio.biz.utils.PageMaker;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "admin_write_notice_form")
	public String wirteNoticeView(HttpSession session, Model model) {
		AdminVO employee = (AdminVO) session.getAttribute("adminUser");
		String[] kindList = { "Notice", "Event" };

		if (employee == null) {
			return "admin/login";
		} else {
			model.addAttribute("kindList", kindList);
			return "admin/board/writenotice";
		}
	}

	@RequestMapping(value = "admin_notice_list")
	public String adminNoticeListView(HttpSession session, Model model, Criteria criteria) {
		AdminVO employee = (AdminVO) session.getAttribute("adminUser");

		if (employee == null) {
			return "admin/login";
		} else {
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria);

			int totalCount = noticeService.noticeTotalCount();
			pageMaker.setTotalCount(totalCount);

			List<NoticeVO> noticeList = noticeService.getNoticeList(criteria);
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("noticeList", noticeList);
			return "admin/board/noticelist";
		}
	}

	@RequestMapping(value = "admin_write_notice", method = RequestMethod.POST)
	public String writeNoticeAction(MultipartHttpServletRequest mtfRequest, HttpSession session, NoticeVO vo) {
		AdminVO employee = (AdminVO) session.getAttribute("adminUser");

		if (employee == null) {
			return "admin/login";
		} else {
			List<MultipartFile> fileList = mtfRequest.getFiles("notice_image");

			String root_path = session.getServletContext().getRealPath("WEB-INF/resources/notice_images/");

			int noticeNum = noticeService.selectMaxNoticeNum();

			vo.setNoticenum(noticeNum);
			vo.setId(employee.getId());
			noticeService.writeNotice(vo);

			if (fileList.size() < 1) {
				vo.setImage("");
				noticeService.insertNoticeImage(vo);
			} else {
				for (MultipartFile mf : fileList) {
					String fileName = mf.getOriginalFilename();

					File file = new File(root_path + fileName);
					System.out.println("file root = " + root_path + fileName);

					try {
						mf.transferTo(file);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					vo.setImage(fileName);
					noticeService.insertNoticeImage(vo);
				}
			}
			return "redirect:admin_notice_list";
		}
	}
	
	/*
	 * @RequestMapping(value="admin_write_notice", method=RequestMethod.POST) public
	 * String writeNoticeAction(@RequestParam(value="notice_image", defaultValue="",
	 * required=false) MultipartFile uploadFile, HttpSession session, NoticeVO vo) {
	 * AdminVO employee = (AdminVO) session.getAttribute("adminUser");
	 * 
	 * if(employee == null) { return "admin/login"; } else {
	 * 
	 * String fileName = "";
	 * 
	 * if(!uploadFile.isEmpty()) { String root_path =
	 * session.getServletContext().getRealPath("WEB-INF/resources/notice_images/");
	 * 
	 * fileName = uploadFile.getOriginalFilename();
	 * 
	 * File file = new File(root_path + fileName);
	 * 
	 * try { uploadFile.transferTo(file); } catch (IllegalStateException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } catch (IOException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } }
	 * 
	 * vo.setImage(fileName); vo.setId(employee.getId());
	 * noticeService.writeNotice(vo);
	 * 
	 * return "redirect:admin_notice_list"; } }
	 */
	
	@RequestMapping(value="admin_notice_detail")
	public String noticeDetailView(@RequestParam(value="noticenum", defaultValue="", required=false) int noticenum,
									HttpSession session, Model model) {
		AdminVO employee = (AdminVO) session.getAttribute("adminUser");
		
		if(employee == null) {
			return "admin/login";
		} else {
			List<NoticeVO> noticeImageList = noticeService.getNoticeDetail(noticenum);
			NoticeVO notice = noticeImageList.get(0);
			
			model.addAttribute("notice", notice);
			model.addAttribute("noticeImageList", noticeImageList);
			return "admin/board/noticedetail";
		}
	}
	
	@RequestMapping(value="notice_list")
	public String noticeView(Criteria criteria, Model model) {
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(criteria);
		
		int totalCount = noticeService.noticeTotalCount();
		pageMaker.setTotalCount(totalCount);
		
		List<NoticeVO> noticeList = noticeService.getNoticeList(criteria);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("noticeList", noticeList);
		
		return "board/noticelist";
	}
	
	@RequestMapping(value="notice_detail")
	public String noticeDetailView(@RequestParam(value="noticenum", defaultValue="", required=false) int noticenum,
			Model model) {
		
		List<NoticeVO> noticeDetailImage = noticeService.getNoticeDetail(noticenum);
		NoticeVO notice = noticeDetailImage.get(0);
		List<NoticeVO> commentList = noticeService.commentList(noticenum);
		
		model.addAttribute("commentList", commentList);
		model.addAttribute("noticeDetailImage", noticeDetailImage);
		model.addAttribute("notice", notice);
		return "board/noticedetail";
	}
	
	@RequestMapping(value="notice_comment", method=RequestMethod.POST)
	public String noticeCommentView(@RequestParam(value="noticenum", defaultValue="", required=false) int noticenum,
									NoticeVO vo, HttpSession session, Model model) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		if(loginUser == null) {
			return "member/login";
		}else {
			vo.setId(loginUser.getId());
			vo.setNoticenum(noticenum);
			List<NoticeVO> noticeDetailImage = noticeService.getNoticeDetail(noticenum);
			NoticeVO notice = noticeDetailImage.get(0);
			
			noticeService.writeComment(vo);
			List<NoticeVO> commentList = noticeService.commentList(noticenum);
			model.addAttribute("commentList", commentList);
			model.addAttribute("noticeDetailImage", noticeDetailImage);
			model.addAttribute("notice", notice);
			return "redirect:notice_detail?noticenum="+noticenum;
		}

	}
}
