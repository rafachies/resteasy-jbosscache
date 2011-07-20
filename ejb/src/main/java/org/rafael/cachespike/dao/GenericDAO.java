package org.rafael.cachespike.dao;

import java.util.Collection;
import java.util.Map;

import org.rafael.cachespike.entity.GenericEntity;

public interface GenericDAO<Clazz extends GenericEntity> { 

	public void insert(Clazz entity);
	public Clazz update(Clazz entity);
	public Clazz findSingle(String query, Map<String, Object> parameters);
	public Collection<Clazz> find(String query, Map<String, Object> parameters);
	public Collection<Clazz> findAll();
	public Clazz findSingleWithCache(String queryString, Map<String, Object> parameters);
	public Collection<Clazz> findWithCache(String queryString, Map<String, Object> parameters);
	public Clazz findById(Long id);
	
	
}
