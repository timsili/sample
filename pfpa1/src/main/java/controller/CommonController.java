package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
