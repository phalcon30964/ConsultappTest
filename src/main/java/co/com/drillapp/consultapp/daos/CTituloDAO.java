package co.com.drillapp.consultapp.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.com.drillapp.consultapp.models.Titulo;
import co.com.drillapp.consultapp.models.TituloPK;

@Repository
@Scope("singleton")
public class CTituloDAO implements ITituloDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void persist(Titulo obj) {
		manager.persist(obj);
	}

	@Override
	public void merge(Titulo obj) {
		manager.merge(obj);		
	}

	@Override
	public void remove(Titulo obj) {
		manager.remove(obj);		
	}

	@Override
	public Titulo getById(TituloPK obj) {
		return manager.find(Titulo.class, obj);
	}

}
