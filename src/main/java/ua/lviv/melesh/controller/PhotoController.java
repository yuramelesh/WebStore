package ua.lviv.melesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.melesh.domain.Photos;
import ua.lviv.melesh.service.PhotosService;
import ua.lviv.melesh.service.ProductService;

@Controller
public class PhotoController {

	@Autowired
	private PhotosService pService;
	@Autowired
	private ProductService prService;

	@RequestMapping(value = "/photo")
	public String photo(Model model, @RequestParam(value = "id") Integer productId) {
		// model.addAttribute("photos", pService.getByProductId(productId));
		// model.addAttribute("id", productId);
		return "photo";
	}

	@RequestMapping(value = "/addPhoto")
	public String photoAdding(Model model, @RequestParam(value = "id") Integer productId) {
		model.addAttribute("product", prService.getProductById(productId));
		model.addAttribute("id", productId);
		return "addPhoto";
	}

	@RequestMapping(value = "/addingPhoto")
	public String addPhoto(Model model, @RequestParam(value = "id") Integer productId, @RequestParam(value = "photoUrl") String url) {
		model.addAttribute("photos", pService.getByProductId(productId));
		model.addAttribute("product", prService.getProductById(productId));
		Photos photos = new Photos();
		photos.setProduct(prService.getProductById(productId));
		photos.setUrl(url);
		pService.insertPhotos(photos);
		return "redirect:/photo?id=" + productId;
	}

}
