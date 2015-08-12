package ua.lviv.melesh.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.melesh.dao.ProductCategoryDao;
import ua.lviv.melesh.domain.ProductCategory;
import ua.lviv.melesh.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Autowired
	private ProductCategoryDao dao;

	@Transactional
	public void insertProductCategory(ProductCategory productCategory) {
		dao.create(productCategory);
	}

	public void deleteProductCategory(ProductCategory productCategory) {
		dao.delete(productCategory);
	}

	public List<ProductCategory> getAllProductCategory() {
		return dao.findAll();
	}

	public ProductCategory getProductCategoryByName(String name) {
		return dao.getByName(name);
	}

	public ProductCategory getProductCategoryById(Integer id) {
		return dao.getById(id);
	}

}