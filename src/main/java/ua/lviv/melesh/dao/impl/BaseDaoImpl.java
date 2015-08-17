package ua.lviv.melesh.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import ua.lviv.melesh.dao.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	private Class<?> entityClass;

	public BaseDaoImpl() {
		entityClass = getEntityClass();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return em.createQuery("From " + entityClass.getName()).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> getFourResult(Integer index) {
		return em.createQuery("From " + entityClass.getName())
				.setFirstResult(index).setMaxResults(4).getResultList();
	}

	@Transactional
	public void create(T entity) {
		em.merge(entity);
	}

	@Transactional
	public void delete(T entity) {
		em.remove(em.merge(entity));
	}

	@Transactional
	public T findById(Object id) {
		return em.find(getEntityClass(), id);
	}

	@SuppressWarnings("unchecked")
	protected final Class<T> getEntityClass() {
		final Type type = getClass().getGenericSuperclass() instanceof ParameterizedType ? getClass()
				.getGenericSuperclass() : getClass().getSuperclass()
				.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			final ParameterizedType paramType = (ParameterizedType) type;
			return (Class<T>) paramType.getActualTypeArguments()[0];
		} else
			throw new IllegalArgumentException(
					"Could not guess entity class by reflection");
	}

}