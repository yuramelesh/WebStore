package ua.lviv.melesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ua.lviv.melesh.service.UserService;

@Controller
public class AJAXController {

	@Autowired
	private UserService uService;

}