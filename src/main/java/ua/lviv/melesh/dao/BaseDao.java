package ua.lviv.melesh.dao;

import java.util.List;

public interface BaseDao<T> {
	
	List<T> findAll();

	void create(T entity);
	
	void delete(T entity);

}
