package ua.lviv.melesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.melesh.service.PhotosService;

@Controller
public class PhotoController {

	@Autowired
	private PhotosService pService;

	@RequestMapping(value = "/photo")
	public String setPhoto(Model model, @RequestParam(value = "id") Integer productId) {

		model.addAttribute("photos", pService.getByProductId(productId));

		return "photo?id=" + productId;
	}

}
