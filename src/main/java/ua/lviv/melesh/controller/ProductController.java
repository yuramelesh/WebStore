package ua.lviv.melesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.melesh.domain.Product;
import ua.lviv.melesh.domain.ProductCategory;
import ua.lviv.melesh.domain.User;
import ua.lviv.melesh.service.ProductCategoryService;
import ua.lviv.melesh.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService pService;

	@Autowired
	private ProductCategoryService cService;

	@RequestMapping(value = "/products")
	public String getAllProducts(Model model) {
		List<Product> products = pService.getAllProducts();
		model.addAttribute("products", products);
		return "products";
	}

	@RequestMapping(value = "/addProduct")
	public String creatingPage(Model model) {
		List<ProductCategory> productCategory = cService
				.getAllProductCategory();
		model.addAttribute("productCategory", productCategory);
		return "addProduct";
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String creatingProduct(Model model,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "price") Integer price,
			@RequestParam(value = "category") String category) {
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setCategory(category);
		pService.insertProduct(product);
		return "redirect:/products";
	}

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

	@RequestMapping(value = "/removeProduct")
	public String removeProduct(Model model,
			@RequestParam(value = "id") Integer id) {
		Product product = pService.getProductById(id);
		pService.deleteProduct(product);
		return "redirect:/products";
	}

	@RequestMapping(value = "/productCard")
	public String editProduct(Model model, @RequestParam(value = "id") Integer id) {
		model.addAttribute("product", pService.getProductById(id));
		return "productCard";

	}

	@RequestMapping(value = "/editingProductName")
	public String editingProductName(Model model,
			@RequestParam(value = "id") Integer id,
			@RequestParam(value = "newName") String name) {
		model.addAttribute("product", pService.getProductById(id));
		Product product = pService.getProductById(id);
		product.setName(name);
		pService.insertProduct(product);
		return "redirect:/editingProductName?id=" + id;
	}
}