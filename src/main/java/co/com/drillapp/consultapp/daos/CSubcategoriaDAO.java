package co.com.drillapp.consultapp.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.com.drillapp.consultapp.models.Categoria;
import co.com.drillapp.consultapp.models.Subcategoria;
import co.com.drillapp.consultapp.models.SubcategoriaPK;

@Repository
@Scope("singleton")
public class CSubcategoriaDAO implements ISubcategoriaDAO {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void persist(Subcategoria obj) {
		System.out.println("Entro a Dao---------------------------------------------------------------------------");
		manager.persist(obj);		
	}

	@Override
	public void merge(Subcategoria obj) {
		System.out.println("Entro a Dao---------------------------------------------------------------------------");
		manager.merge(obj);		
	}

	@Override
	public void remove(SubcategoriaPK obj) {
		System.out.println("Entro a Dao---------------------------------------------------------------------------");
		manager.remove(manager.find(Subcategoria.class, obj));		
	}

	@Override
	public Subcategoria getById(SubcategoriaPK obj) {
		System.out.println("Entro a Dao---------------------------------------------------------------------------");
		return manager.find(Subcategoria.class, obj);
	}
	
	@Override
	public List<Subcategoria> getByIdCategoria(int idCat) {
		System.out.println("Entro a Dao---------------------------------------------------------------------------");
		Query query = manager.createNamedQuery("Subcategoria.findByIdCategoria");
		query.setParameter("idCategoria", idCat);
		List<Subcategoria> resultado = query.getResultList();
		return (resultado.size() > 0) ? resultado : null;
	}

}
