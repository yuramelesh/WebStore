package ua.lviv.melesh.service;

import java.util.List;

import ua.lviv.melesh.domain.ProductCategory;

public interface ProductCategoryService {
	void insertProductCategory(ProductCategory productCategory);
	
	void deleteProductCategory(ProductCategory productCategory);

	List<ProductCategory> getAllProductCategory();

	List<ProductCategory> getProductCategoryByName(String name);

	ProductCategory getProductCategoryById(Integer id);

}