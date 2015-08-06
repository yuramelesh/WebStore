package ua.lviv.melesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.melesh.domain.ProductCategory;
import ua.lviv.melesh.service.ProductCategoryService;

@Controller
public class ProductCategoryController {

	@Autowired
	private ProductCategoryService cService;

	@RequestMapping(value = "/category")
	public String editCategories(Model model) {
		List<ProductCategory> productCategory = cService
				.getAllProductCategory();
		model.addAttribute("productCategory", productCategory);
		return "category";
	}

	@RequestMapping(value = "/newCategory")
	public String addCategory(Model model) {
		List<ProductCategory> productCategory = cService
				.getAllProductCategory();
		model.addAttribute("productCategory", productCategory);
		return "newCategory";
	}

	@RequestMapping(value = "/addingCategory")
	public String addingCategory(Model model,
			@RequestParam(value = "name") String name) {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setName(name);
		cService.insertProductCategory(productCategory);
		return "redirect:/category";
	}

	@RequestMapping(value = "/removeCategory")
	public String removeCategory(Model model,
			@RequestParam(value = "id") Integer id) {
		ProductCategory productCategory = cService.getProductCategoryById(id);
		cService.deleteProductCategory(productCategory);
		return "redirect:/category";
	}

}
