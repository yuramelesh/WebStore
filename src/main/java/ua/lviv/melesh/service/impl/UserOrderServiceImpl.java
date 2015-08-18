package ua.lviv.melesh.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.melesh.dao.UserOrderDao;
import ua.lviv.melesh.domain.UserOrder;
import ua.lviv.melesh.service.UserOrderService;

@Service
public class UserOrderServiceImpl implements UserOrderService {

	@Autowired
	private UserOrderDao dao;

	@Transactional
	public void insertUserOrder(UserOrder userOrder) {
		dao.create(userOrder);

	}

	public void deleteUserOrder(UserOrder userOrder) {
		dao.delete(userOrder);

	}

	public List<UserOrder> getAllUserOrders() {
		return dao.findAll();
	}

}
