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
	public List<Photos> getByProductId(Integer id) {
		return getEm().createNamedQuery("Photos.findByProductId").setParameter("id", id).getResultList();
	}

	@Transactional
	public Photos getById(Integer id) {
		return (Photos) getEm().createNamedQuery("Product.findById").setParameter("id", id).getSingleResult();
	}

}
