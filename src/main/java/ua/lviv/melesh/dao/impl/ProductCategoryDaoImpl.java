package ua.lviv.melesh.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ua.lviv.melesh.dao.ProductCategoryDao;
import ua.lviv.melesh.domain.ProductCategory;

@Repository
public class ProductCategoryDaoImpl extends BaseDaoImpl<ProductCategory> implements ProductCategoryDao {

	@SuppressWarnings("unchecked")
	@Transactional
	public List<ProductCategory> getByName(String name) {
		return getEm().createNamedQuery("ProductCategory.findByName").setParameter("name", name).getResultList();
	}

	@Transactional
	public ProductCategory getById(Integer id) {
		return (ProductCategory) getEm().createNamedQuery("ProductCategory.findById").setParameter("id", id).getSingleResult();
	}

}