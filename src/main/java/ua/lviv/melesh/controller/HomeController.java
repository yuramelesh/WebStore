package ua.lviv.melesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.melesh.domain.Product;
import ua.lviv.melesh.service.ProductService;

@Controller
public class HomeController {
	@Autowired
	private ProductService pService;

	@RequestMapping(value = "/welcome")
	public String getAllProducts(Model model) {
		List<Product> products = (pService.getAllProducts()).subList(0, 5);
		model.addAttribute("products", products);
		return "welcome";
	}

	@RequestMapping(value = "/cart")
	public String cart(Model model) {
		return "cart";
	}

	@RequestMapping(value = "/toCart")
	public String cart(Model model, @RequestParam(value = "id") Integer id) {
		Product product = pService.getProductById(id);
		model.addAttribute("product", product);
		return "cart";
	}
}