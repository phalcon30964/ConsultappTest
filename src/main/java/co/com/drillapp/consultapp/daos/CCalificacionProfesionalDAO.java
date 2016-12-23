package co.com.drillapp.consultapp.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.com.drillapp.consultapp.models.CalificacionProfesional;
import co.com.drillapp.consultapp.models.CalificacionProfesionalPK;

@Repository
@Scope("singleton")
public class CCalificacionProfesionalDAO implements ICalificacionProfesionalDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void persist(CalificacionProfesional obj) {
		manager.persist(obj);
	}

	@Override
	public void merge(CalificacionProfesional obj) {
		manager.merge(obj);
	}

	@Override
	public void remove(CalificacionProfesional obj) {
		manager.remove(obj);
	}

	@Override
	public CalificacionProfesional getById(CalificacionProfesionalPK obj) {
		return manager.find(CalificacionProfesional.class, obj);
	}

}
