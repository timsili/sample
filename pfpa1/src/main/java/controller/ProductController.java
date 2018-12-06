package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.LoginVO;
import domain.ProductVO;
import service.ProductService;

@Controller
public class ProductController {
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	@RequestMapping(value = "/pin", method = RequestMethod.GET)
	public String insert(LoginVO loginVO, Model model, HttpSession session) {
		loginVO = (LoginVO)session.getAttribute("loginVO");
		if(session.getAttribute("loginVO") == null || !loginVO.getId().equals("admin")) {
			System.out.println("need login");
			return "redirect:/main";
		}
		model.addAttribute("productVO", new ProductVO());
		return "/product/insert";
	}
	@RequestMapping(value = "/pin", method = RequestMethod.POST)
	public String insert(ProductVO productVO) {
		productService.insert(productVO);
		return "redirect:/main";
	}
}
