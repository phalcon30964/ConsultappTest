package co.com.drillapp.consultapp.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.com.drillapp.consultapp.models.Consulta;

@Repository
@Scope("singleton")
public class CConsultaDAO implements IConsultaDAO{
	
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
