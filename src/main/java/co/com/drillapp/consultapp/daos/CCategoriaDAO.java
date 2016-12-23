package co.com.drillapp.consultapp.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

import co.com.drillapp.consultapp.models.Categoria;
import co.com.drillapp.consultapp.models.Cliente;

@Repository
@Scope("singleton")
public class CCategoriaDAO implements ICategoriaDAO{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void persist(Categoria obj) {
		System.out.println("Entro a Dao---------------------------------------------------------------------------");
		manager.persist(obj);
	}

	@Override
	public void merge(Categoria obj) {
		System.out.println("Entro a Dao---------------------------------------------------------------------------");
		manager.merge(obj);		
	}
	
	@Override
	public void removeById(Integer obj) {
		System.out.println("Entro a Dao---------------------------------------------------------------------------");
		manager.remove(manager.find(Categoria.class, obj));			
	}

	@Override
	public Categoria getById(Integer obj) {
		System.out.println("Entro a Dao---------------------------------------------------------------------------");
		return manager.find(Categoria.class, obj);
	}
	
	@Override
	public List<Categoria> getAll(){
		System.out.println("Entro a Dao---------------------------------------------------------------------------");
		Query query = manager.createNamedQuery("Categoria.findAll");
		List<Categoria> resultado = query.getResultList();
		return (resultado.size() > 0) ? resultado : null;
	}
	
	@Override
	public Long getLength(){
		System.out.println("Entro a Dao---------------------------------------------------------------------------");
		Query query = manager.createQuery("Categoria.findLength");
		return (Long) query.getSingleResult();
	}

}
