package co.com.drillapp.consultapp.logics;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.com.drillapp.consultapp.models.Consulta;

@Service
@Scope("singleton")
public class CConsultaLogic implements IConsultaLogic{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void persist(Consulta obj) {
		manager.persist(obj);		
	}

	@Override
	public void merge(Consulta obj) {
		manager.merge(obj);		
	}

	@Override
	public void remove(Consulta obj) {
		manager.remove(obj);	
	}

	@Override
	public Consulta getById(Integer obj) {
		return manager.find(Consulta.class, obj);
	}

}
