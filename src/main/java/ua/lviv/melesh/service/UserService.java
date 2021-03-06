package ua.lviv.melesh.service;

import java.util.List;

import ua.lviv.melesh.domain.User;

public interface UserService {
	void insertUser(User user);

	void deleteUser(User user);

	List<User> getAllUsers();

	User getUserByName(String name);

	User getUserById(Integer id);

}
