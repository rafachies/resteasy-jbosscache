package org.rafael.cachespike.dao;

import java.util.Collection;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.rafael.cachespike.entity.CarEntity;
import org.rafael.cachespike.entity.GenericEntity;

public class GenericDAOBean<Clazz extends GenericEntity> implements GenericDAO<Clazz> {

	@PersistenceContext(unitName="punit")
	private EntityManager entityManager;
	
	@Override
	public void insert(Clazz entity) {
		entityManager.persist(entity);
	}

	@Override
	public Clazz update(Clazz entity) {
		return entityManager.merge(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Clazz findSingle(String queryString, Map<String, Object> parameters) {
		Query query = entityManager.createQuery(queryString);
		for (String parameterKey : parameters.keySet()) {
			query.setParameter(parameterKey, parameters.get(parameterKey));
		}
		return (Clazz) query.getSingleResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Clazz findSingleWithCache(String queryString, Map<String, Object> parameters) {
		Query query = entityManager.createQuery(queryString);
		query.setHint("org.hibernate.cacheable", "true");
		for (String parameterKey : parameters.keySet()) {
			query.setParameter(parameterKey, parameters.get(parameterKey));
		}
		return (Clazz) query.getSingleResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<Clazz> find(String queryString, Map<String, Object> parameters) {
		Query query = entityManager.createQuery(queryString);
		for (String parameterKey : parameters.keySet()) {
			query.setParameter(parameterKey, parameters.get(parameterKey));
		}
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<Clazz> findWithCache(String queryString, Map<String, Object> parameters) {
		Query query = entityManager.createQuery(queryString);
		query.setHint("org.hibernate.cacheable", "true");
		for (String parameterKey : parameters.keySet()) {
			query.setParameter(parameterKey, parameters.get(parameterKey));
		}
		return query.getResultList();
	}
	
	@Override
	public Collection<Clazz> findAll() { 
		entityManager.createQuery("select obj from CarEntity" ).getResultList();
		return null;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Clazz findById(Long id) {
		return (Clazz) entityManager.find(CarEntity.class, id);
	}

}
