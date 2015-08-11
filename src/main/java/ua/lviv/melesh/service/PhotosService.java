package ua.lviv.melesh.service;

import java.util.List;

import ua.lviv.melesh.domain.Photos;

public interface PhotosService {

	void insertPhotos(Photos photos);

	void deletePhotos(Photos photos);

	List<Photos> getByProductId(Integer id);

	Photos getPhotoById(Integer id);
}
