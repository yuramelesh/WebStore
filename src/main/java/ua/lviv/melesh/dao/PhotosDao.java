package ua.lviv.melesh.dao;

import java.util.List;

import ua.lviv.melesh.domain.Photos;

public interface PhotosDao extends BaseDao<Photos> {

	Photos getById(Integer id);

	List<Photos> getByProductId(Integer id);

}
