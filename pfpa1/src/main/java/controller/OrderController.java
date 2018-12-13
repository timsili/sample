package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.CartVO;
import domain.LoginVO;
import domain.MemberVO;
import domain.OrdersVO;
import service.MemberService;
import service.OrderService;

@Controller
public class OrderController {
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	@RequestMapping(value ="/cas", method = RequestMethod.GET)
	public String cartStep(LoginVO loginVO, HttpSession session) {
		return "redirect:/main";
	}
	@RequestMapping(value ="/cas", method = RequestMethod.POST)
	public String cartStep(LoginVO loginVO, CartVO cartVO, Model model, HttpSession session) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		if(loginVO == null) {
			return "redirect:/main";
		}
		cartVO.setId(loginVO.getId());
		if(orderService.searchDupl(cartVO) > 0) {
			orderService.updateCart(cartVO);
		}else {
			orderService.insertCart(cartVO);
		}
		return "redirect:/car";
	}
	@RequestMapping(value = "/car", method = RequestMethod.GET)
	public String cart(LoginVO loginVO, Model model, HttpSession session) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		if(loginVO == null) {
			return "redirect:/main";
		}
		model.addAttribute("cartList", orderService.listCart(loginVO.getId()));
		return "/order/cart";
	}
	@RequestMapping(value = "/cfm", method = RequestMethod.GET)
	public String confirm(LoginVO loginVO, MemberVO memberVO, Model model, HttpSession session) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		if(loginVO == null) {
			return "redirect:/main";
		}
		String id = loginVO.getId();
		if(orderService.listCart(id).isEmpty()) {
			return "redirect:/main";
		}
		List<CartVO> list = orderService.listCart(loginVO.getId());
		int sum = 0;
		for(int i=0 ; i<list.size() ; i++) {
			sum += (list.get(i).getPric() + list.get(i).getProop()) * list.get(i).getStock();
		}
		if(orderService.checkOrno(id) == 0) {
			Random r = new Random();
			int orno = 0;
			while(true) {
				orno = r.nextInt(900000) + 100000;
				if(orderService.searchOrno(orno) == 0) {
					break;
				}
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("orno", orno);
			map.put("id", id);
			orderService.updateOrno(map);
		}
		int point = (int)(sum * 0.002);
		model.addAttribute("cartList", orderService.listCart(id));
		model.addAttribute("memberVO", memberService.selectById(id));
		model.addAttribute("ordersVO", new OrdersVO());
		model.addAttribute("sum", sum);
		model.addAttribute("point", point);
		return "/order/confirm";
	}
	@RequestMapping(value = "/cfm", method = RequestMethod.POST)
	public String confirm(LoginVO loginVO, MemberVO memberVO, OrdersVO ordersVO, Model model, HttpSession session, HttpServletRequest req) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		memberVO = memberService.selectById(loginVO.getId());
		ordersVO.setId(memberVO.getId());
		ordersVO.setOrno(orderService.selectOrno(loginVO.getId()));
		if(req.getParameter("s").equals("sa")) {
			ordersVO.setName(memberVO.getName());
			ordersVO.setPoco(memberVO.getPoco());
			ordersVO.setAddr(memberVO.getAddr());
			ordersVO.setDaddr(memberVO.getDaddr());
			ordersVO.setTel(memberVO.getTel());
			ordersVO.setCeph(memberVO.getCeph());
			ordersVO.setDema(req.getParameter("sdema"));
		}else {
			ordersVO.setDema(req.getParameter("ddema"));
		}
		if(req.getParameter("pm").equals("ca")) {
			ordersVO.setPame("card");
			ordersVO.setPade("");
		}else {
			ordersVO.setPame(req.getParameter("bank"));
			ordersVO.setPade(req.getParameter("acco"));
		}
		orderService.insertOrder(ordersVO);
		return "redirect:/cfm";
	}
}
