package ua.lviv.melesh.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ua.lviv.melesh.dao.UserDao;
import ua.lviv.melesh.domain.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Transactional
	public User getByName(String name) {
		return (User) getEm().createNamedQuery("User.findByName").setParameter("name", name).getSingleResult();
	}

	@Transactional
	public User getById(Integer id) {
		return (User) getEm().createNamedQuery("User.findById").setParameter("id", id).getSingleResult();
	}

}
