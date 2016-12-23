package co.com.drillapp.consultapp.logics;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import co.com.drillapp.consultapp.models.Archivo;
import co.com.drillapp.consultapp.models.ArchivoPK;

@Service
@Scope("singleton")
public class CArchivoLogic implements IArchivoLogic {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void persist(Archivo obj) {
		manager.persist(obj);
	}

	@Override
	public void merge(Archivo obj) {
		manager.merge(obj);
	}

	@Override
	public void remove(Archivo obj) {
		manager.remove(obj);
	}

	@Override
	public Archivo getById(ArchivoPK obj) {
		return 	manager.find(Archivo.class, obj);
	}
	
}
