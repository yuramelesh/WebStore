package ua.lviv.melesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.lviv.melesh.domain.User;
import ua.lviv.melesh.domain.UserOrder;
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
			@RequestParam(value = "password") String password) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setRole("ROLE_USER");
		user.setActive(true);
		user.setPassword(password);
		uService.insertUser(user);
		return "redirect:/userList";
	}

	@RequestMapping(value = "/editPage")
	public String editUsers(Model model, @RequestParam(value = "id") Integer id) {
		model.addAttribute("user", uService.getUserById(id));
		return "editPage";

	}

	// @Secured({"ROLE_ADMIN"})
	@RequestMapping(value = "/newUserName", method = RequestMethod.POST)
	public @ResponseBody String setUserName(@RequestParam String name,
			@RequestParam Integer id) {
		User user = uService.getUserById(id);
		user.setName(name);
		uService.insertUser(user);
		return name;

	}

	@RequestMapping(value = "/newUserEmail", method = RequestMethod.POST)
	public @ResponseBody String setUserEmail(@RequestParam String email,
			@RequestParam Integer id) {
		User user = uService.getUserById(id);
		user.setEmail(email);
		uService.insertUser(user);
		return email;

	}

	@RequestMapping(value = "/newUserPhoto", method = RequestMethod.POST)
	public @ResponseBody String setUserPhoto(@RequestParam String photo,
			@RequestParam Integer id) {
		User user = uService.getUserById(id);
		user.setPhotoUrl(photo);
		uService.insertUser(user);
		return photo;

	}

	@RequestMapping(value = "/newUserPassword", method = RequestMethod.POST)
	public @ResponseBody String setUserPassword(@RequestParam String password,
			@RequestParam Integer id) {
		User user = uService.getUserById(id);
		user.setPassword(password);
		uService.insertUser(user);
		return password;

	}

	@RequestMapping(value = "/newUserStatus", method = RequestMethod.POST)
	public @ResponseBody String setUserStatus(@RequestParam Integer id) {
		User user = uService.getUserById(id);
		String msg;
		if (user.getActive() == true) {
			user.setActive(false);
			uService.insertUser(user);
			msg = "Non active";
		} else {
			user.setActive(true);
			uService.insertUser(user);
			msg = "Active";
		}
		return msg;
	}

	@RequestMapping(value = "/newUserRole", method = RequestMethod.POST)
	public @ResponseBody String setUserRole(@RequestParam Integer id) {
		User user = uService.getUserById(id);
		String role;
		if (user.getRole().equals("ROLE_USER")) {
			user.setRole("ROLE_ADMIN");
			uService.insertUser(user);
			role = "ROLE_ADMIN";
		} else {
			user.setRole("ROLE_USER");
			uService.insertUser(user);
			role = "ROLE_USER";
		}
		return role;
	}

	@RequestMapping(value = "/removeUser")
	public String removeUser(Model model, @RequestParam(value = "id") Integer id) {
		User user = uService.getUserById(id);
		uService.deleteUser(user);
		return "redirect:/userList";
	}

	@RequestMapping(value = "/profile")
	public String profilePage(Model model,
			@RequestParam(value = "name") String name) {
		User user = uService.getUserByName(name);
		List<UserOrder> list = user.getUserOrder();
		System.out.println(list);
		model.addAttribute("user", user);
		model.addAttribute("orders", list);
		return "profile";
	}
}