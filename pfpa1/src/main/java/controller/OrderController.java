package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping(value = "/cfo", method = RequestMethod.GET)
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
		int orno = 0;
		if(orderService.checkOrno(id) == 0) {
			Random r = new Random();
			while(true) {
				orno = r.nextInt(900000) + 100000;
				if(orderService.searchOrno(orno) == 0) {
					break;
				}
			}
		}else {
			orno = orderService.selectOrno(id);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orno", orno);
		map.put("id", id);
		orderService.updateOrno(map);
		int point = (int)(sum * 0.002);
		model.addAttribute("cartList", orderService.listCart(id));
		model.addAttribute("memberVO", memberService.selectById(id));
		model.addAttribute("ordersVO", new OrdersVO());
		model.addAttribute("sum", sum);
		model.addAttribute("point", point);
		return "/order/confirm";
	}
	@RequestMapping(value = "/cfo", method = RequestMethod.POST)
	public String confirm(LoginVO loginVO, MemberVO memberVO, OrdersVO ordersVO, Model model, HttpSession session, HttpServletRequest req, int sum) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		String id = loginVO.getId();
		memberVO = memberService.selectById(id);
		ordersVO.setId(id);
		ordersVO.setOrno(orderService.selectOrno(id));
		String item = orderService.selectLaIt(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", ordersVO.getId());
		map.put("orno", ordersVO.getOrno());
		String itemEx = String.valueOf(orderService.countCart(map));
		ordersVO.setItem(item + " 외 " + itemEx + "품목");
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
		ordersVO.setSum(sum);
		orderService.insertOrder(ordersVO);
		return "redirect:/cho";
	}
	@RequestMapping(value = "/cho", method = RequestMethod.GET)
	public String check(LoginVO loginVO, Model model, HttpSession session) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		if(loginVO == null) {
			return "redirect:/main";
		}
		if(orderService.listCart(loginVO.getId()).isEmpty()) {
			return "redirect:/main";
		}
		int orno = orderService.selectOrno(loginVO.getId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", loginVO.getId());
		map.put("orno", orno);
		if(orderService.selectOrders(map) == null) {
			return "redirect:/main";
		}
		model.addAttribute("ordersVO", orderService.selectOrders(map));
		return "/order/check";
	}
	@RequestMapping(value = "/cho", method = RequestMethod.POST)
	public String check(LoginVO loginVO, HttpSession session) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		List<CartVO> cartList = orderService.listCart(loginVO.getId());
		for(CartVO cartVO : cartList) {
			orderService.insertOrDe(cartVO);
		}
		orderService.deleteCart(loginVO.getId());
		return "redirect:/main";
	}
	@RequestMapping(value = "/pro", method = RequestMethod.GET)
	public String progress(LoginVO loginVO, Model model, HttpSession session) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		if(loginVO == null) {
			return "redirect:/main";
		}
		model.addAttribute("ordersList", orderService.listOrders(loginVO.getId()));
		return "/order/progress";
	}
	@RequestMapping(value = "/pro/{orno}", method = RequestMethod.GET)
	public String progressOrno(LoginVO loginVO, Model model, HttpSession session, @PathVariable int orno) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		if(loginVO == null) {
			return "redirect:/main";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", loginVO.getId());
		map.put("orno", orno);
		model.addAttribute("order", orderService.selectOrders(map));
		model.addAttribute("orderList", orderService.listOrde(map));
		return "/order/progDetail";
	}
}
