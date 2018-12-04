package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import common.utils.Salt;
import domain.MemberVO;
import service.MemberService;

@Controller
public class MemberController {
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	@RequestMapping(value = "/min", method = RequestMethod.GET)
	public String insert() {
		return "redirect:/tac";
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
}
