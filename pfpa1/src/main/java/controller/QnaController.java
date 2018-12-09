package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import common.utils.Criteria;
import common.utils.Pagination;
import domain.LoginVO;
import domain.QnaVO;
import domain.ReQnaVO;
import service.QnaService;

@Controller
public class QnaController {
	private QnaService qnaService;
	public void setQnaService(QnaService qnaService) {
		this.qnaService = qnaService;
	}
	@RequestMapping(value = "/qin", method = RequestMethod.GET)
	public String insert(LoginVO loginVO, Model model, HttpSession session) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		if(loginVO == null) {
			return "redirect:/lin";
		}
		QnaVO qnaVO = new QnaVO();
		qnaVO.setWrit(loginVO.getId());
		model.addAttribute("qnaVO", qnaVO);
		model.addAttribute("loginVO", loginVO);
		return "/qna/insert";
	}
	@RequestMapping(value = "/qin", method = RequestMethod.POST)
	public String insert(QnaVO qnaVO, HttpSession session) {
		qnaService.insert(qnaVO);
		return "redirect:/qli";
	}
	@RequestMapping(value = "/qli")
	public String list(Model model, HttpSession session, Criteria criteria, String id) {
		if(session.getAttribute("searchId") != null) {
			id = (String)session.getAttribute("searchId");
		}
		Pagination pagination = new Pagination();
		pagination.setCriteria(criteria);
		id = (id == null) ? "" : id;
		pagination.setCount(qnaService.count(id));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("end", criteria.getEnd());
		map.put("start", criteria.getStart());
		model.addAttribute("qnaList", qnaService.list(map));
		model.addAttribute("pagination", pagination);
		session.setAttribute("searchID", id);
		return "/qna/list";
	}
	@RequestMapping(value = "/qse/{no}", method = RequestMethod.GET)
	public String select(LoginVO loginVO, QnaVO qnaVO, Model model, HttpSession session, @PathVariable int no) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		qnaVO = qnaService.selectByNo(no);
		if(loginVO == null) {
			return "redirect:/lin";
		}else if(!qnaVO.getWrit().equals(loginVO.getId()) && !loginVO.getId().equals("admin")) {
			return "redirect:/qli";
		}
		ReQnaVO reqnaVO = new ReQnaVO();
		if(loginVO.getId().equals("admin")) {
			reqnaVO.setWrit("admin");
			qnaService.updateAd(no);
		}else {
			reqnaVO.setWrit(loginVO.getId());
			qnaService.updateUs(no);
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
		return "redirect:/qse/{no}";
	}
	@RequestMapping(value = "/qde/{no}")
	public String delete(LoginVO loginVO, QnaVO qnaVO, HttpSession session, @PathVariable int no) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		qnaVO = qnaService.selectByNo(no);
		if(loginVO == null) {
			return "redirect:/lin";
		}else if(!qnaVO.getWrit().equals(loginVO.getId()) && !loginVO.getId().equals("admin")) {
			return "redirect:/qli";
		}
		qnaService.deleteRe(no);
		qnaService.delete(no);
		return "redirect:/qli";
	}
}
