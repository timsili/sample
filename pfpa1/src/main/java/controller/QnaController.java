package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import common.utils.Criteria;
import common.utils.Pagination;
import common.utils.Salt;
import domain.LoginVO;
import domain.MemberVO;
import domain.QnaVO;
import service.MemberService;
import service.QnaService;

@Controller
public class QnaController {
	private QnaService qnaService;
	private MemberService memberService;
	public void setQnaService(QnaService qnaService) {
		this.qnaService = qnaService;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	@RequestMapping(value = "/qin", method = RequestMethod.GET)
	public String insert(LoginVO loginVO, Model model, HttpSession session) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		if(loginVO == null) {
			return "redirect:/main";
		}
		QnaVO qnaVO = new QnaVO();
		qnaVO.setWrit(loginVO.getId());
		model.addAttribute("qnaVO", qnaVO);
		return "/qna/insert";
	}
	@RequestMapping(value = "/qin", method = RequestMethod.POST)
	public String insert(LoginVO loginVO, MemberVO memberVO, QnaVO qnaVO, HttpSession session, String pwd) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		if(!loginVO.getPwd().equals(pwd)) {
			return "redirect:/qin";
		}
		memberVO = memberService.selectById(loginVO.getId());
		String salt = memberVO.getSalt();
		String tmp = pwd;
		String npwd = Salt.getEncrypt(tmp, salt);
		if(!memberVO.getPwd().equals(npwd)) {
			return "redirect:/qin";
		}
		qnaVO.setPwd(npwd);
		qnaVO.setRef(qnaService.getRef());
		qnaService.insert(qnaVO);
		return "redirect:/main";
	}
	@RequestMapping(value = "/qli")
	public String list(LoginVO loginVO, Model model, Criteria criteria) {
		Pagination pagination = new Pagination();
		pagination.setCriteria(criteria);
		pagination.setCount(qnaService.count());
		model.addAttribute("qnaList", qnaService.list(criteria));
		model.addAttribute("pagination", pagination);
		return "/qna/list";
	}
}
