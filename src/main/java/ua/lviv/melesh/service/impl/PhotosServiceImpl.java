package ua.lviv.melesh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.melesh.dao.PhotosDao;
import ua.lviv.melesh.domain.Photos;
import ua.lviv.melesh.service.PhotosService;

@Service
public class PhotosServiceImpl implements PhotosService {

	@Autowired
	private PhotosDao dao;

	public void insertPhotos(Photos photos) {
		dao.create(photos);

	}

	public void deleteProduct(Photos photos) {
		dao.delete(photos);

	}

	public List<Photos> getByProductId(Integer id) {
		return dao.getByProductId(id);
	}

	public Photos getPhotoById(Integer id) {
		return dao.getById(id);
	}

}
