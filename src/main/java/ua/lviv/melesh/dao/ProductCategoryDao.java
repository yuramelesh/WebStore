package ua.lviv.melesh.dao;

import ua.lviv.melesh.domain.ProductCategory;

public interface ProductCategoryDao extends BaseDao<ProductCategory> {

	ProductCategory getById(Integer id);

	ProductCategory getByName(String name);

}
