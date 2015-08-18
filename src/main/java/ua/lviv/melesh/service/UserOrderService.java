package ua.lviv.melesh.service;

import java.util.List;

import ua.lviv.melesh.domain.UserOrder;

public interface UserOrderService {

	void insertUserOrder(UserOrder userOrder);

	void deleteUserOrder(UserOrder userOrder);

	List<UserOrder> getAllUserOrders();

}
