package ua.lviv.melesh.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ua.lviv.melesh.dao.ProductDao;
import ua.lviv.melesh.domain.Product;

@Repository
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Product> getByName(String name) {
		return getEm().createNamedQuery("Product.findByName")
				.setParameter("name", name).getResultList();
	}

	@Transactional
	public Product getById(Integer id) {
		return (Product) getEm().createNamedQuery("Product.findById")
				.setParameter("id", id).getSingleResult();
	}

}
