package controller;

import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.CartVO;
import domain.LoginVO;
import service.OrderService;

@Controller
public class OrderController {
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	@RequestMapping(value ="/cas", method = RequestMethod.GET)
	public String cartStep() {
		return "redirect:/main";
	}
	@RequestMapping(value ="/cas", method = RequestMethod.POST)
	public String cartStep(LoginVO loginVO, CartVO cartVO, Model model, HttpSession session) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		String id = loginVO == null ? session.getId() : loginVO.getId();
		cartVO.setId(id);
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
		String id = loginVO == null ? session.getId() : loginVO.getId();
		model.addAttribute("cartList", orderService.listCart(id));
		return "/order/cart";
	}
}
