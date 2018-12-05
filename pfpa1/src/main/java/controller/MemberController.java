package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import common.utils.Criteria;
import common.utils.Pagination;
import common.utils.Salt;
import domain.LoginVO;
import domain.MemberVO;
import service.MemberService;

@Controller
public class MemberController {
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	@RequestMapping(value = "/min", method = RequestMethod.GET)
	public String insert(HttpSession session) {
		if(session.getAttribute("loginVO") != null) {
			return "redirect:/main";
		}
		return "/member/insert";
	}
	@RequestMapping(value = "/min", method = RequestMethod.POST)
	public String insert(MemberVO memberVO) {
		if(!memberVO.getPwd().equals(memberVO.getCpwd())) {
			return "redirect:/min";
		}
		String salt = Salt.generateSalt();
		String tmp = memberVO.getPwd();
		String npwd = Salt.getEncrypt(tmp, salt);
		memberVO.setPwd(npwd);
		memberVO.setSalt(salt);
		memberService.insert(memberVO);
		return "redirect:/main";
	}
	@RequestMapping(value = "/lin", method = RequestMethod.GET)
	public String login(LoginVO loginVO, HttpSession session, @CookieValue(value = "reme", required = false) Cookie cookie) {
		if(session.getAttribute("loginVO") != null) {
			return "redirect:/main";
		}
		if(cookie != null) {
			loginVO.setId(cookie.getValue());
			loginVO.setReme(true);
		}
		return "/common/login";
	}
	@RequestMapping(value = "/lin", method = RequestMethod.POST)
	public String login(LoginVO loginVO, HttpSession session, HttpServletResponse resp) {
		if(memberService.countById(loginVO.getId()) <= 0) {
			return "redirect:/lin";
		}
		MemberVO memberVO = memberService.selectById(loginVO.getId());
		String salt = memberVO.getSalt();
		String tmp = loginVO.getPwd();
		String npwd = Salt.getEncrypt(tmp, salt);
		if(!npwd.equals(memberVO.getPwd())) {
			return "redirect:/lin";
		}
		session.setAttribute("loginVO", loginVO);
		Cookie cookie = new Cookie("reme", loginVO.getId());
		cookie.setPath("/");
		if(loginVO.isReme()) {
			cookie.setMaxAge(60*60*24*30);
		}else {
			cookie.setMaxAge(0);
		}
		resp.addCookie(cookie);
		return "redirect:/main";
	}
	@RequestMapping(value = "/lou")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
	@RequestMapping(value = "/mli")
	public String list(LoginVO loginVO, Model model, HttpSession session, Criteria criteria) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		if(loginVO == null || !loginVO.getId().equals("admin")) {
			return "redirect:/main";
		}
		Pagination pagination = new Pagination();
		pagination.setCriteria(criteria);
		pagination.setCount(memberService.count());
		model.addAttribute("memberList", memberService.list(criteria));
		model.addAttribute("pagination", pagination);
		return "/member/list";
	}
}
