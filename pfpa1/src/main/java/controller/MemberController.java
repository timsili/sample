package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

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
	public String insert(Model model, HttpSession session) {
		if(session.getAttribute("loginVO") != null) {
			return "redirect:/main";
		}
		model.addAttribute("memberVO", new MemberVO());
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
	public String login(LoginVO loginVO, MemberVO memberVO, HttpSession session, HttpServletResponse resp) {
		if(memberService.countById(loginVO.getId()) <= 0) {
			return "redirect:/lin";
		}
		memberVO = memberService.selectById(loginVO.getId());
		String salt = memberVO.getSalt();
		String tmp = loginVO.getPwd();
		String npwd = Salt.getEncrypt(tmp, salt);
		if(!memberVO.getPwd().equals(npwd)) {
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
			System.out.println("need login");
			return "redirect:/main";
		}
		Pagination pagination = new Pagination();
		pagination.setCriteria(criteria);
		pagination.setCount(memberService.count());
		model.addAttribute("memberList", memberService.list(criteria));
		model.addAttribute("pagination", pagination);
		return "/member/list";
	}
	@RequestMapping(value = "/mse/{id}")
	public String select(LoginVO loginVO, Model model, HttpSession session, @PathVariable String id) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		if(loginVO == null || !loginVO.getId().equals("admin")) {
			System.out.println("need login");
			return "redirect:/main";
		}
		model.addAttribute("memberVO", memberService.selectById(id));
		return "/member/select";
	}
	@RequestMapping(value = "/mup/{id}", method = RequestMethod.GET)
	public String update(LoginVO loginVO, MemberVO memberVO, Model model, HttpSession session, @PathVariable String id) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		if(loginVO == null || !loginVO.getId().equals(id) && !loginVO.getId().equals("admin")) {
			System.out.println("need login");
			return "redirect:/main";
		}
		memberVO = memberService.selectById(id);
		model.addAttribute("memberVO", memberVO);
		return "/member/update";
	}
	@RequestMapping(value = "/mup/{id}", method = RequestMethod.POST)
	public String update(MemberVO memberVO, SessionStatus sessionStatus, String pwd) {
		if(!memberVO.getPwd().equals(pwd)) {
			return "redirect:/main";
		}
		MemberVO memberVODB = memberService.selectById(memberVO.getId());
		String salt = memberVODB.getSalt();
		String tmp = pwd;
		String npwd = Salt.getEncrypt(tmp, salt);
		if(!memberVODB.getPwd().equals(npwd)) {
			return "redirect:/main";
		}
		memberService.update(memberVO);
		sessionStatus.setComplete();
		return "redirect:/main";
	}
	@RequestMapping(value = "/mde/{id}", method = RequestMethod.GET)
	public String delete(LoginVO loginVO, Model model, HttpSession session, @PathVariable String id) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		if(loginVO == null) {
			System.out.println("need login");
			return "redirect:/main";
		}
		MemberVO memberVO = memberService.selectById(id);
		model.addAttribute("memberVO", memberVO);
		return "/member/delete";
	}
	@RequestMapping(value = "/mde/{id}", method = RequestMethod.POST)
	public String delete(LoginVO loginVO, MemberVO memberVO, HttpSession session, @PathVariable String id, String pwd) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		String salt = memberService.getSalt(id);
		String tmp = pwd;
		String npwd = Salt.getEncrypt(tmp, salt);
		MemberVO memberVODB = memberService.selectById(id);
		if(loginVO.getId().equals("admin")) {
			MemberVO memberVOLogin = memberService.selectById(loginVO.getId());
			String adminSalt = memberService.getSalt(loginVO.getId());
			String apwd = Salt.getEncrypt(tmp, adminSalt);
			if(!memberVOLogin.getPwd().equals(apwd)) {
				return "redirect:/mde/{id}";
			}
			memberService.delete(id);
			return "redirect:/mli";
		}
		if(!memberVODB.getPwd().equals(npwd)) {
			return "redirect:/mde/{id}";
		}
		memberService.delete(id);
		return "redirect:/lou";
	}
}
