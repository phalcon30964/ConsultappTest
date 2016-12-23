package co.com.drillapp.consultapp.daos;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

import co.com.drillapp.consultapp.models.Cliente;
import co.com.drillapp.consultapp.models.ClientePK;
import co.com.drillapp.consultapp.models.Subcategoria;

@Repository
@Scope("singleton")
public class CClienteDAO implements IClienteDAO{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void persist(Cliente obj) throws Exception {
		System.out.println("Entro a Dao persist---------------------------------------------------------------------------");
		manager.persist(obj);		
	}

	@Override
	public void merge(Cliente obj) throws Exception {
		System.out.println("Entro a Dao merge---------------------------------------------------------------------------");
		manager.merge(obj);	
	}

	@Override
	public void remove(ClientePK obj) throws Exception {
		System.out.println("Entro a Dao remove---------------------------------------------------------------------------");
		manager.remove(manager.find(Cliente.class, obj));
	}
	
	@Override
	public Cliente getById(ClientePK obj) throws Exception {
		System.out.println("Entro a Dao get---------------------------------------------------------------------------");
		return manager.find(Cliente.class, obj);
	}

	@Override
	public Cliente getByEmail(String email) throws Exception {
		Query query = manager.createNamedQuery("Cliente.findByEmail");
		query.setParameter("email", email);		
        try {
        	return (Cliente) query.getSingleResult();
		} catch (NoResultException  e) {
			return null;
		} catch (Exception i){
			throw i;
		}
	}	
	
	@Override
	public Cliente getByEmailPassword(String email, String password) throws Exception{
		Query query = manager.createNamedQuery("Cliente.findByEmailContrasena");
		query.setParameter("email", email);
        query.setParameter("password", password);
        try {
        	return (Cliente) query.getSingleResult();
		} catch (NoResultException  e) {
			throw new Exception("Usuario o contraseña incorrecta");
		} catch (Exception i){
			throw i;
		}
	}
}
