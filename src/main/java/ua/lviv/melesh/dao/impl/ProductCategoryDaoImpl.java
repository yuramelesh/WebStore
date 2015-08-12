package ua.lviv.melesh.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ua.lviv.melesh.dao.ProductCategoryDao;
import ua.lviv.melesh.domain.ProductCategory;

@Repository
public class ProductCategoryDaoImpl extends BaseDaoImpl<ProductCategory>
		implements ProductCategoryDao {

	@Transactional
	public ProductCategory getByName(String name) {
		return (ProductCategory) getEm()
				.createNamedQuery("ProductCategory.findByName")
				.setParameter("name", name).getSingleResult();
	}

	@Transactional
	public ProductCategory getById(Integer id) {
		return (ProductCategory) getEm()
				.createNamedQuery("ProductCategory.findById")
				.setParameter("id", id).getSingleResult();
	}

}