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
		List<Product> products = pService.getAllProducts();
		Product product1 = products.get(1);
		model.addAttribute("product1", product1);
		Product product2 = products.get(2);
		model.addAttribute("product2", product2);
		Product product3 = products.get(3);
		model.addAttribute("product3", product3);
		Product product4 = products.get(4);
		model.addAttribute("product4", product4);
		Product product5 = products.get(5);
		model.addAttribute("product5", product5);
		Product product6 = products.get(6);
		model.addAttribute("product6", product6);
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