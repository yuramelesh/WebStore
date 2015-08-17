package ua.lviv.melesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}