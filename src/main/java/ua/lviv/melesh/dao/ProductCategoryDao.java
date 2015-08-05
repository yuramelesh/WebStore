package ua.lviv.melesh.dao;

import java.util.List;

import ua.lviv.melesh.domain.ProductCategory;

public interface ProductCategoryDao extends BaseDao<ProductCategory> {

	ProductCategory getById(Integer id);

	List<ProductCategory> getByName(String name);

}
