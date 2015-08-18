package ua.lviv.melesh.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.melesh.domain.Product;
import ua.lviv.melesh.domain.User;
import ua.lviv.melesh.domain.UserOrder;
import ua.lviv.melesh.service.ProductService;
import ua.lviv.melesh.service.UserOrderService;
import ua.lviv.melesh.service.UserService;

@Controller
public class OrderController {

	@Autowired
	private ProductService pService;

	@Autowired
	private UserService uService;

	@Autowired
	private UserOrderService uoService;

	@RequestMapping(value = "/ordering", method = RequestMethod.POST)
	public String order(Model model, HttpSession session) {
		getSumm(model, session);
		return "order";
	}

	@RequestMapping(value = "/billingAccount", method = RequestMethod.POST)
	public String billingAccount(Model model, HttpSession session,
			@RequestParam(value = "orderDescription") String descr,
			@RequestParam(value = "name") String name) {
		getSumm(model, session);
		UserOrder userOrder = new UserOrder();
		User user = uService.getUserByName(name);
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) session.getAttribute("cart");
		int summ = 0;
		for (Product p : products) {
			summ = summ + p.getPrice();
		}
		userOrder.setUser(user);
		userOrder.setDescr(descr);
		userOrder.setProducts(products);
		userOrder.setSumm(summ);
		userOrder.setStatus(true);
		Date date = new java.sql.Date(Calendar.getInstance().getTime()
				.getTime());
		userOrder.setDate(date);
		uoService.insertUserOrder(userOrder);
		session.removeAttribute("cart");
		return "orderSucces";
	}

	@RequestMapping(value = "/cart")
	public String cart(Model model, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<Product> cartItems = (List<Product>) session.getAttribute("cart");
		if (cartItems != null) {
			getSumm(model, session);
		}
		return "cart";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/toCart", method = RequestMethod.POST)
	public String cart(Model model, @RequestParam(value = "id") Integer id,
			HttpSession session) {
		List<Product> cartItems = (List<Product>) session.getAttribute("cart");
		if (cartItems == null) {
			cartItems = new ArrayList<Product>();
		}
		cartItems.add(pService.getProductById(id));
		session.setAttribute("cart", cartItems);
		getSumm(model, session);
		return "cart";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/removeFromCart")
	public String removeFromCart(Model model,
			@RequestParam(value = "id") Integer id, HttpSession session) {
		List<Product> cartItems = (List<Product>) session.getAttribute("cart");
		cartItems.remove(pService.getProductById(id));
		session.setAttribute("cart", cartItems);
		return "redirect:/cart";
	}

	@SuppressWarnings("unchecked")
	public Model getSumm(Model model, HttpSession session) {
		List<Product> cartItems = (List<Product>) session.getAttribute("cart");
		int summ = 0;
		for (Product p : cartItems) {
			summ = summ + p.getPrice();
		}
		return model.addAttribute("total", summ);
	}

}
