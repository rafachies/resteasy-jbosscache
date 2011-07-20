package org.rafael.cachespike.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import org.rafael.cachespike.entity.CarEntity;

@Stateless
public class CarDAOBean extends GenericDAOBean<CarEntity> implements CarDAO {

	private static final String MODEL_PARAMETER = "modelParameter";

	private static final String FIND_BY_MODEL = 
		"select obj from " + CarEntity.class.getName() + " obj" + 
		" where obj.model = :" + MODEL_PARAMETER;

	public Collection<CarEntity> findByModel(CarEntity carEntity) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(MODEL_PARAMETER, carEntity.getModel());
		return findWithCache(FIND_BY_MODEL, parameters );
	}
}
