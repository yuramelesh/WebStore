package ua.lviv.melesh.dao;

import java.util.List;

import ua.lviv.melesh.domain.Product;

public interface ProductDao extends BaseDao<Product> {

	Product getById(Integer id);

	List<Product> getByName(String name);

}
