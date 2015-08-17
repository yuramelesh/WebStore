package ua.lviv.melesh.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import ua.lviv.melesh.dao.UserOrderDao;
import ua.lviv.melesh.domain.UserOrder;
import ua.lviv.melesh.service.UserOrderService;

public class UserOrderServiceImpl implements UserOrderService {

	@Autowired
	private UserOrderDao dao;

	@Transactional
	public void insertUserOrder(UserOrder userOrder) {
		dao.create(userOrder);

	}

}
