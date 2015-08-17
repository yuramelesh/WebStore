package ua.lviv.melesh.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.melesh.dao.ProductDao;
import ua.lviv.melesh.domain.Product;
import ua.lviv.melesh.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao dao;

	@Transactional
	public void insertProduct(Product product) {
		dao.create(product);
	}

	public List<Product> getAllProducts() {
		return dao.findAll();
	}

	public List<Product> getProductByName(String name) {
		return dao.getByName(name);
	}

	public Product getProductById(Integer id) {
		return dao.getById(id);
	}

	public void deleteProduct(Product product) {
		dao.delete(product);
	}

	public List<Product> getProductByCategory(String category) {
		return dao.getByCategory(category);
	}

	public List<Product> getFourResult(Integer index) {
		return dao.getFourResult(index);
	}

}