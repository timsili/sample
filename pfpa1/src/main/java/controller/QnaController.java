package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import common.utils.Criteria;
import common.utils.Pagination;
import domain.LoginVO;
import domain.MemberVO;
import domain.QnaVO;
import domain.ReQnaVO;
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
			return "redirect:/qli";
		}
		QnaVO qnaVO = new QnaVO();
		qnaVO.setWrit(loginVO.getId());
		model.addAttribute("qnaVO", qnaVO);
		return "/qna/insert";
	}
	@RequestMapping(value = "/qin", method = RequestMethod.POST)
	public String insert(LoginVO loginVO, MemberVO memberVO, QnaVO qnaVO, HttpSession session) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		qnaVO.setRef(qnaService.getRef());
		qnaService.insert(qnaVO);
		return "redirect:/qli";
	}
	@RequestMapping(value = "/qli")
	public String list(Model model, Criteria criteria) {
		Pagination pagination = new Pagination();
		pagination.setCriteria(criteria);
		pagination.setCount(qnaService.count());
		model.addAttribute("qnaList", qnaService.list(criteria));
		model.addAttribute("pagination", pagination);
		return "/qna/list";
	}
	@RequestMapping(value = "/qse/{no}", method = RequestMethod.GET)
	public String select(LoginVO loginVO, QnaVO qnaVO, Model model, HttpSession session, @PathVariable int no) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		qnaVO = qnaService.selectByNo(no);
		if(loginVO == null || !qnaVO.getWrit().equals(loginVO.getId()) && !loginVO.getId().equals("admin")) {
			return "redirect:/qli";
		}
		ReQnaVO reqnaVO = new ReQnaVO();
		reqnaVO.setWrit(loginVO.getId());
		if(loginVO.getId().equals("admin")) {
			reqnaVO.setWrit("admin");
		}
		model.addAttribute("qnaVO", qnaService.selectByNo(no));
		model.addAttribute("reqnaList", qnaService.listRe(no));
		model.addAttribute("reqnaVO", reqnaVO);
		return "/qna/select";
	}
	@RequestMapping(value = "/qse/{no}", method = RequestMethod.POST)
	public String select(ReQnaVO reqnaVO, @PathVariable int no) {
		reqnaVO.setNo(no);
		qnaService.insertRe(reqnaVO);
		return "redirect:/qli";
	}
}
