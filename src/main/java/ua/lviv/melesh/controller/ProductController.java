package ua.lviv.melesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.lviv.melesh.domain.Product;
import ua.lviv.melesh.domain.ProductCategory;
import ua.lviv.melesh.service.PhotosService;
import ua.lviv.melesh.service.ProductCategoryService;
import ua.lviv.melesh.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService pService;
	@Autowired
	private PhotosService phService;
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
	public String creatingProduct(
			Model model,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "price") Integer price,
			@RequestParam(value = "productPhoto") String photo,
			@RequestParam(value = "category") String category,
			@RequestParam(value = "productDescription") String productDescription) {
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setCategory(category);
		product.setPhoto(photo);
		product.setDescription(productDescription);
		pService.insertProduct(product);
		return "redirect:/products";
	}

	@RequestMapping(value = "/removeProduct")
	public String removeProduct(Model model,
			@RequestParam(value = "id") Integer id) {
		Product product = pService.getProductById(id);
		pService.deleteProduct(product);
		return "redirect:/products";
	}

	@RequestMapping(value = "/productCard")
	public String editProduct(Model model,
			@RequestParam(value = "id") Integer id) {
		List<ProductCategory> productCategory = cService
				.getAllProductCategory();
		model.addAttribute("productCategory", productCategory);
		model.addAttribute("product", pService.getProductById(id));
		return "productCard";

	}

	@RequestMapping(value = "/productProfile")
	public String productProfile(Model model,
			@RequestParam(value = "id") Integer id) {
		model.addAttribute("product", pService.getProductById(id));
		model.addAttribute("photos", phService.getByProductId(id));
		return "productProfile";
	}

	@RequestMapping(value = "/newProductName", method = RequestMethod.POST)
	public @ResponseBody String setProductName(@RequestParam String name,
			@RequestParam Integer id) {
		Product product = pService.getProductById(id);
		product.setName(name);
		pService.insertProduct(product);
		return name;
	}

	@RequestMapping(value = "/newProductPrice", method = RequestMethod.POST)
	public @ResponseBody String setProductPrice(@RequestParam Integer price,
			@RequestParam Integer id) {
		Product product = pService.getProductById(id);
		product.setPrice(price);
		pService.insertProduct(product);
		return price.toString();
	}

	@RequestMapping(value = "/newProductCategory", method = RequestMethod.POST)
	public @ResponseBody String setProductCategory(
			@RequestParam String category, @RequestParam Integer id) {
		Product product = pService.getProductById(id);
		product.setCategory(category);
		pService.insertProduct(product);
		return category.toString();
	}

	@RequestMapping(value = "/newProductPhoto", method = RequestMethod.POST)
	public @ResponseBody String setProductPhoto(@RequestParam String photo,
			@RequestParam Integer id) {
		Product product = pService.getProductById(id);
		product.setPhoto(photo);
		pService.insertProduct(product);
		return photo;
	}

	@RequestMapping(value = "/newProductDescription", method = RequestMethod.POST)
	public @ResponseBody String setProductDescription(
			@RequestParam String description, @RequestParam Integer id) {
		Product product = pService.getProductById(id);
		product.setDescription(description);
		pService.insertProduct(product);
		return description;
	}

}