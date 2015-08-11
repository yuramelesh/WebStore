package ua.lviv.melesh.dao;

import ua.lviv.melesh.domain.User;

public interface UserDao extends BaseDao<User> {

	User getById(Integer id);

	User getByName(String name);

}
