package co.com.drillapp.consultapp.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.com.drillapp.consultapp.models.Mediopago;
import co.com.drillapp.consultapp.models.MediopagoPK;

@Repository
@Scope("singleton")
public class CMediopagoDAO implements IMediopagoDAO {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void persist(Mediopago obj)throws Exception {
		System.out.println("Entro a Dao save---------------------------------------------------------------------------");
		manager.persist(obj);		
	}

	@Override
	public void merge(Mediopago obj)throws Exception {
		System.out.println("Entro a Dao edit---------------------------------------------------------------------------");
		manager.merge(obj);
	}

	@Override
	public void remove(MediopagoPK obj)throws Exception {
		System.out.println("Entro a Dao remove---------------------------------------------------------------------------");
		manager.remove(manager.find(Mediopago.class, obj));		
	}

	@Override
	public Mediopago getById(MediopagoPK obj)throws Exception {
		System.out.println("Entro a Dao get---------------------------------------------------------------------------");
		return manager.find(Mediopago.class, obj);
	}


}
