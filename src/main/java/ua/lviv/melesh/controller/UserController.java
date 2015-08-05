package ua.lviv.melesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.melesh.domain.User;
import ua.lviv.melesh.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService uService;

	@RequestMapping(value = "/userList")
	public String getAllUsers(Model model) {
		List<User> users = uService.getAllUsers();
		model.addAttribute("users", users);
		return "userList";
	}

	@RequestMapping(value = "/registration")
	public String creatingPage() {
		return "registration";
	}

	@RequestMapping(value = "/userList", method = RequestMethod.POST)
	public String creatingUser(Model model,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "password") Integer password) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		uService.insertUser(user);
		return "redirect:/userList";
	}

	@RequestMapping(value = "/editPage")
	public String editUsers(Model model, @RequestParam(value = "id") Integer id) {
		model.addAttribute("user", uService.getUserById(id));
		return "editPage";

	}

	@RequestMapping(value = "/editingName")
	public String editingUserName(Model model,
			@RequestParam(value = "id") Integer id,
			@RequestParam(value = "newName") String name) {
		model.addAttribute("user", uService.getUserById(id));
		User user = uService.getUserById(id);
		user.setName(name);
		uService.insertUser(user);
		return "redirect:/editPage?id=" + id;
	}

	@RequestMapping(value = "/editingEmail")
	public String editingUserEmail(Model model,
			@RequestParam(value = "id") Integer id,
			@RequestParam(value = "newEmail") String email) {
		model.addAttribute("user", uService.getUserById(id));
		User user = uService.getUserById(id);
		user.setEmail(email);
		uService.insertUser(user);
		return "redirect:/editPage?id=" + id;
	}
	
	@RequestMapping(value = "/editingPassword")
	public String editingUserPassword(Model model,
			@RequestParam(value = "id") Integer id,
			@RequestParam(value = "newPassword") Integer password) {
		model.addAttribute("user", uService.getUserById(id));
		User user = uService.getUserById(id);
		user.setPassword(password);
		uService.insertUser(user);
		return "redirect:/editPage?id=" + id;
	}
}