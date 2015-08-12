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
	public String creatingProduct(Model model,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "price") Integer price,
			@RequestParam(value = "productPhoto") String photo,
			@RequestParam(value = "category") String category) {
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setCategory(category);
		product.setPhoto(photo);
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

	@RequestMapping(value = "/newProductName")
	public String newProductName(Model model,
			@RequestParam(value = "newName") String name,
			@RequestParam(value = "id") Integer id) {
		model.addAttribute("product", pService.getProductById(id));
		Product product = pService.getProductById(id);
		product.setName(name);
		pService.insertProduct(product);
		return "redirect:/productCard?id=" + id;
	}

	@RequestMapping(value = "/newProductDescription")
	public String newProductDescription(Model model,
			@RequestParam(value = "newDescription") String description,
			@RequestParam(value = "id") Integer id) {
		model.addAttribute("product", pService.getProductById(id));
		Product product = pService.getProductById(id);
		product.setDescription(description);
		pService.insertProduct(product);
		return "redirect:/productCard?id=" + id;
	}

	@RequestMapping(value = "/newProductPhoto")
	public String newProductPhoto(Model model,
			@RequestParam(value = "newPhoto") String photoUrl,
			@RequestParam(value = "id") Integer id) {
		model.addAttribute("product", pService.getProductById(id));
		Product product = pService.getProductById(id);
		product.setPhoto(photoUrl);
		pService.insertProduct(product);
		return "redirect:/productCard?id=" + id;
	}

	@RequestMapping(value = "/editingCategory")
	public String editingCategory(Model model,
			@RequestParam(value = "newCategory") String category,
			@RequestParam(value = "id") Integer id) {
		model.addAttribute("product", pService.getProductById(id));
		Product product = pService.getProductById(id);
		product.setCategory(category);
		pService.insertProduct(product);
		return "redirect:/productCard?id=" + id;
	}

	@RequestMapping(value = "/newProductPrice")
	public String newProductPrice(Model model,
			@RequestParam(value = "newPrice") Integer price,
			@RequestParam(value = "id") Integer id) {
		model.addAttribute("product", pService.getProductById(id));
		Product product = pService.getProductById(id);
		product.setPrice(price);
		pService.insertProduct(product);
		return "redirect:/productCard?id=" + id;
	}

	@RequestMapping(value = "/productProfile")
	public String productProfile(Model model,
			@RequestParam(value = "id") Integer id) {
		model.addAttribute("product", pService.getProductById(id));
		model.addAttribute("photos", phService.getByProductId(id));
		return "productProfile";
	}
}