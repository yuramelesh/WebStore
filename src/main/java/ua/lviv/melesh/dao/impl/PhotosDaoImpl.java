package ua.lviv.melesh.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ua.lviv.melesh.dao.PhotosDao;
import ua.lviv.melesh.domain.Photos;

@Repository
public class PhotosDaoImpl extends BaseDaoImpl<Photos> implements PhotosDao {

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Photos> getByProductId(Integer productId) {
		return getEm().createNamedQuery("Photos.findByProductId").setParameter("product_id", productId).getResultList();
	}

	@Transactional
	public Photos getById(Integer id) {
		return (Photos) getEm().createNamedQuery("Photos.findById").setParameter("id", id).getSingleResult();
	}

}
