package com.portfolio.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.portfolio.biz.auth.SNSLogin;
import com.portfolio.biz.auth.SnsValue;
import com.portfolio.biz.employee.dto.AdminVO;
import com.portfolio.biz.user.UserService;
import com.portfolio.biz.user.dto.UserVO;
import com.portfolio.biz.utils.Criteria;
import com.portfolio.biz.utils.PageMaker;

@Controller
@SessionAttributes("loginUser")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private SnsValue naverSns;
	
	@Autowired
	private SnsValue googleSns;
	
	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	
	@Autowired
	private OAuth2Parameters googleOAuth2Parameters;
	
	@RequestMapping(value="/about")
	public String aboutPageView() {
		return "about";
	}
	
	@RequestMapping(value="/auth/{service}/callback", method= RequestMethod.GET)
	public String snsLoginCallback(@PathVariable String service, 
									Model model, 
									@RequestParam String code, HttpSession session) throws Exception {
		
		SnsValue sns = null;
		if(StringUtils.equals("naver", service)) {
			sns = naverSns;
		}else {
			sns = googleSns;
		}
		
		// 1. code를 이용해서 access_token 받기
		// 2. access_token을 이용해서 사용자 profile 정보 가져오기
		SNSLogin snslogin = new SNSLogin(sns);
		UserVO snsUser = snslogin.getUserProfile(code);
		
		UserVO loginUser = userService.snsLoginUser(snsUser);
		System.out.println("profile : " + snsUser);
		model.addAttribute("result", snsUser);
		
		if(loginUser == null) {
			model.addAttribute("snsUser", snsUser);
			return "member/snsjoin";
		}else {
			model.addAttribute("loginUser", loginUser);
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/login_form")
	public String loginFormView(Model model) {
		
		SNSLogin naverLogin = new SNSLogin(naverSns);
		model.addAttribute("naver_url", naverLogin.getNaverAuthURL());
		
		/*
		SNSLogin googleLogin = new SNSLogin(googleSns);
		model.addAttribute("google_url", googleLogin.getGoogleAuthURL());
		*/
		
		/* 구글code 발행을 위한 URL 생성 */
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
		model.addAttribute("google_url", url);

		return "member/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginAction(UserVO vo, Model model) {
		UserVO loginUser = userService.loginUser(vo);
		
		if(loginUser == null) {
			model.addAttribute("check", 1);
			model.addAttribute("message", "아이디와 비밀번호를 확인해주세요.");
			return "member/login";
		}else {
			model.addAttribute("loginUser", loginUser);
			return "redirect:index";
		}
	}
	
	@RequestMapping(value="/logout")
	public String logoutAction(SessionStatus status) {
		status.setComplete();
		return "redirect:index";
	}

	@RequestMapping(value = "/join_form")
	public String joinFormView() {
		return "member/join";
	}

	@RequestMapping(value = "/id_check_form")
	public String idCheckFormView(@RequestParam(value = "id", defaultValue = "", required = false) String id,
			Model model) {
		model.addAttribute("id", id);
		return "member/idcheck";
	}

	@RequestMapping(value = "/id_check_form", method = RequestMethod.POST)
	public String idCheckAction(HttpServletRequest request, Model model, UserVO user) {
		String id = request.getParameter("id");
		UserVO vo = userService.idCheck(id);
		System.out.println(vo);

		if(vo == null) {
			model.addAttribute("check", 0);
		}else {
			model.addAttribute("check", 1);
		}
		
		model.addAttribute("id", id);
		return "member/idcheck";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinAction(@RequestParam(value = "addr1", defaultValue = "", required = false) String addr1, 
								@RequestParam(value = "addr2", defaultValue = "", required = false) String addr2, 
								UserVO vo) {
		vo.setAddress(addr1 + " " + addr2);
		vo.setEmail(vo.getId() + "@email.com");
		System.out.println(vo);
		userService.joinUser(vo);
		return "member/login";
	}
	
	@RequestMapping(value = "/sns_join", method = RequestMethod.POST)
	public String snsJoinAction(@RequestParam(value = "addr1", defaultValue = "", required = false) String addr1, 
								@RequestParam(value = "addr2", defaultValue = "", required = false) String addr2, 
								UserVO vo) {
		vo.setPwd("");
		vo.setAddress(addr1 + " " + addr2);
		System.out.println(vo);
		userService.joinUser(vo);
		return "member/login";
	}
	
	@RequestMapping(value="find_id_form")
	public String findIdView() {
		return "member/findId";
	}
	
	@RequestMapping(value="find_id", method=RequestMethod.POST)
	public String findIdAction(UserVO vo, Model model) {
		UserVO user = userService.findId(vo);
		
		if(user == null) { 
			model.addAttribute("check", 1);
		} else { 
			model.addAttribute("check", 0);
			model.addAttribute("id", user.getId());
		}
		
		return "member/findId";
	}
	
	@RequestMapping(value="find_password_form")
	public String findPasswordView() {
		return "member/findPassword";
	}
	
	@RequestMapping(value="find_password", method=RequestMethod.POST)
	public String findPasswordAction(UserVO vo, Model model) {
		UserVO user = userService.findPassword(vo);
		
		if(user == null) { 
			model.addAttribute("check", 1);
		} else { 
			model.addAttribute("check", 0);
			model.addAttribute("updateid", user.getId());
		}
		
		return "member/findPassword";
	}
	
	@RequestMapping(value="update_password", method=RequestMethod.POST)
	public String updatePasswordAction(@RequestParam(value="updateid", defaultValue="", required=false) String id,
										UserVO vo) {
		vo.setId(id);
		System.out.println(vo);
		userService.updatePassword(vo);
		return "member/findPasswordConfirm";
	}
	
	@RequestMapping(value="check_password_view")
	public String checkPasswordForModify(HttpSession session, Model model) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			return "mypage/checkformodify";
		}
	}
	
	@RequestMapping(value="pass_check", method=RequestMethod.POST)
	public String passCheckAction(@RequestParam(value="pwd", defaultValue="", required=false) String pwd,
								HttpSession session, Model model) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		
		if(loginUser.getPwd().equals(pwd)) {
			return "mypage/modifymyinfo";
		} else {
			model.addAttribute("message", "fail");
			return "redirect:check_password_view";
		}
	}
	
	@RequestMapping(value="update_user_info", method=RequestMethod.POST)
	public String updateUserInfoAction(@RequestParam(value="addr1", defaultValue="", required=false) String addr1,
										@RequestParam(value="addr2", defaultValue="", required=false) String addr2,
										HttpSession session, UserVO vo) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		}else {
			vo.setAddress(addr1 + " " + addr2);
			userService.updateUserInfo(vo);
			return "index";
		}
	}
	
	@RequestMapping(value="admin_member_list")
	public String adminMemberListView(@RequestParam(value="name", defaultValue="", required=false) String name,
								HttpSession session, Criteria criteria, Model model) {
		 AdminVO employee = (AdminVO) session.getAttribute("adminUser");
		 
		 if(employee == null) {
			 return "admin/login";
		 } else {
			 PageMaker pageMaker = new PageMaker();
			 pageMaker.setCri(criteria);
			 
			 int totalCount = userService.totalUserCount();
			 pageMaker.setTotalCount(totalCount);
			 
			 List<UserVO> userList = userService.getUserListPaging(criteria, name);
			 
			 model.addAttribute("userList", userList);
			 model.addAttribute("pageMaker", pageMaker);
			 
			 return "admin/member/memberlist";
		 }
	}
}
