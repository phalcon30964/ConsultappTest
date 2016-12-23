package co.com.drillapp.consultapp.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.com.drillapp.consultapp.models.Transaccion;
import co.com.drillapp.consultapp.models.TransaccionPK;

@Repository
@Scope("singleton")
public class CTransaccionDAO implements ITransaccionDAO {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void persist(Transaccion obj) {
		manager.persist(obj);		
	}

	@Override
	public void merge(Transaccion obj) {
		manager.merge(obj);		
	}

	@Override
	public void remove(Transaccion obj) {
		manager.remove(obj);		
	}

	@Override
	public Transaccion getById(TransaccionPK obj) {
		return manager.find(Transaccion.class, obj);
	}

}
