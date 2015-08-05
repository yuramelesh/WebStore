package ua.lviv.melesh.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.melesh.dao.UserDao;
import ua.lviv.melesh.domain.User;
import ua.lviv.melesh.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	@Transactional
	public void insertUser(User user) {
		dao.create(user);
	}

	public List<User> getAllUsers() {
		return dao.findAll();
	}

	public List<User> getUserByName(String name) {
		return dao.getByName(name);
	}

	public User getUserById(Integer id) {
		return dao.getById(id);
	}

}