package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String tac(HttpSession session) {
		if(session.getAttribute("loginVO") != null) {
			return "redirect:/main";
		}
		return "/common/tac";
	}
	@RequestMapping(value = "/tac", method = RequestMethod.POST)
	public String tac(HttpServletRequest req) {
		String terms = req.getParameter("terms");
		String policy = req.getParameter("policy");
		if(terms == null || policy == null || !terms.equals("true") || !policy.equals("true")) {
			return "redirect:/tac";
		}
		return "redirect:/min";
	}
}
