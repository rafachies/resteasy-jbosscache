package org.rafael.cachespike.resource;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.rafael.cachespike.dao.CarDAO;
import org.rafael.cachespike.dao.CarDAOBean;
import org.rafael.cachespike.entity.CarEntity;
import org.rafael.cachespike.util.ServiceLocator;

@Path("/resource/car")
public class CarResource {

	@POST
	public Response insert(CarEntity carEntity) {
		CarDAO carDAO =  (CarDAO) ServiceLocator.lookupLocal(CarDAOBean.class);	
		carDAO.insert(carEntity);
		return Response.ok().build();
	}
	
	@POST
	@Path("/{id}/update")
	public Response update(@PathParam("id") Long id, CarEntity carEntity) {
		CarDAO carDAO =  (CarDAO) ServiceLocator.lookupLocal(CarDAOBean.class);	
		CarEntity carFound = carDAO.findById(id);
		carFound.setModel(carEntity.getModel());
		carFound.setColor(carEntity.getColor());
		carDAO.update(carFound);
		return Response.ok().build();
	}
	
	@GET
	@Path("/{model}")
	public Response find(@PathParam("model") String model) {
		CarDAO carDAO =  (CarDAO) ServiceLocator.lookupLocal(CarDAOBean.class);	
		CarEntity carEntity = new CarEntity();
		carEntity.setModel(model);
		Collection<CarEntity> result = carDAO.findByModel(carEntity);
		return Response.ok(result).build();
	}
}
