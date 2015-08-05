package ua.lviv.melesh.dao;

import java.util.List;

import ua.lviv.melesh.domain.User;

public interface UserDao extends BaseDao<User> {

	User getById(Integer id);

	List<User> getByName(String name);

}
