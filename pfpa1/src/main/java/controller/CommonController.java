package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.MemberVO;

@Controller
public class CommonController {
	@RequestMapping(value = "")
	public String index() {
		return "redirect:/main";
	}
	@RequestMapping(value = "/main")
	public String main() {
		return "/common/main";
	}
	@RequestMapping(value = "/tac", method = RequestMethod.GET)
	public String tac() {
		return "/common/tac";
	}
	@RequestMapping(value = "/tac", method = RequestMethod.POST)
	public String tac(Model model,HttpServletRequest req) {
		String terms = req.getParameter("terms");
		String policy = req.getParameter("policy");
		if(terms == null || policy == null || !terms.equals("true") || !policy.equals("true")) {
			return "redirect:/tac";
		}
		model.addAttribute("memberVO", new MemberVO());
		return "/member/insert";
	}
}
