package co.com.drillapp.consultapp.logics;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.com.drillapp.consultapp.models.Profesional;
import co.com.drillapp.consultapp.models.ProfesionalPK;

@Repository
@Scope("singleton")
public class CProfesionalLogic implements IProfesionalLogic {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void persist(Profesional obj) {
		manager.persist(obj);
		
	}

	@Override
	public void merge(Profesional obj) {
		manager.merge(obj);
		
	}

	@Override
	public void remove(Profesional obj) {
		manager.remove(obj);		
	}

	@Override
	public Profesional getById(ProfesionalPK obj) {
		return manager.find(Profesional.class, obj);
	}

}
