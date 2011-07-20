package org.rafael.cachespike.dao;

import java.util.Collection;

import javax.ejb.Local;

import org.rafael.cachespike.entity.CarEntity;

@Local
public interface CarDAO extends GenericDAO<CarEntity> {
	
	public Collection<CarEntity> findByModel(CarEntity carEntity);
}
