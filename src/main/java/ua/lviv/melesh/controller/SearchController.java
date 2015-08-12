package ua.lviv.melesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.melesh.domain.Product;
import ua.lviv.melesh.service.PhotosService;
import ua.lviv.melesh.service.ProductCategoryService;
import ua.lviv.melesh.service.ProductService;

@Controller
public class SearchController {
	@Autowired
	private ProductService pService;
	@Autowired
	private PhotosService phService;
	@Autowired
	private ProductCategoryService cService;

	@RequestMapping(value = "/search")
	public String getAllProducts(Model model,
			@RequestParam(value = "category") String category) {
		List<Product> products = pService.getProductByCategory(category);
		model.addAttribute("products", products);
		return "search";
	}

	@RequestMapping(value = "/searching")
	public String productSearch(Model model,
			@RequestParam(value = "name") String name) {
		List<Product> products = pService.getProductByName(name);
		model.addAttribute("products", products);
		return "search";
	}
}
