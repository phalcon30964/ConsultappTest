package co.com.drillapp.consultapp.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.com.drillapp.consultapp.models.CalificacionCliente;
import co.com.drillapp.consultapp.models.CalificacionClientePK;

@Repository
@Scope("singleton")
public class CCalificacionClienteDAO implements ICalificacionClienteDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void persist(CalificacionCliente obj) {
		manager.persist(obj);
	}

	@Override
	public void merge(CalificacionCliente obj) {
		manager.merge(obj);
	}

	@Override
	public void remove(CalificacionCliente obj) {
		manager.remove(obj);
	}

	@Override
	public CalificacionCliente getById(CalificacionClientePK obj) {
		return manager.find(CalificacionCliente.class, obj);
	}

}
