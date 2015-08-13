package ua.lviv.melesh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.melesh.domain.Product;
import ua.lviv.melesh.domain.ProductCategory;
import ua.lviv.melesh.service.ProductCategoryService;
import ua.lviv.melesh.service.ProductService;

@Controller
public class HomeController {
	@Autowired
	private ProductService pService;
	@Autowired
	private ProductCategoryService pcService;

	@RequestMapping(value = "/welcome")
	public String getAllProducts(Model model) {
		List<ProductCategory> productCategory = pcService
				.getAllProductCategory();
		model.addAttribute("productCategory", productCategory);
		List<Product> products = (pService.getAllProducts()).subList(0, 12);
		model.addAttribute("products", products);
		return "welcome";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginFail")
	public String loginFail(Model model) {
		model.addAttribute("error", "Bad username or password");
		return "login";
	}

	@RequestMapping(value = "/cart")
	public String cart(Model model, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<Product> cartItems = (List<Product>) session.getAttribute("cart");
		if (cartItems != null) {
			getSumm(model, session);
		}
		return "cart";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/toCart", method = RequestMethod.POST)
	public String cart(Model model, @RequestParam(value = "id") Integer id,
			HttpSession session) {
		List<Product> cartItems = (List<Product>) session.getAttribute("cart");
		if (cartItems == null) {
			cartItems = new ArrayList<Product>();
		}
		cartItems.add(pService.getProductById(id));
		session.setAttribute("cart", cartItems);
		getSumm(model, session);
		return "cart";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/removeFromCart")
	public String removeFromCart(Model model,
			@RequestParam(value = "id") Integer id, HttpSession session) {
		List<Product> cartItems = (List<Product>) session.getAttribute("cart");
		cartItems.remove(pService.getProductById(id));
		session.setAttribute("cart", cartItems);
		return "redirect:/cart";
	}

	@SuppressWarnings("unchecked")
	public Model getSumm(Model model, HttpSession session) {
		List<Product> cartItems = (List<Product>) session.getAttribute("cart");
		int summ = 0;
		for (Product p : cartItems) {
			summ = summ + p.getPrice();
		}
		return model.addAttribute("total", summ);
	}
}