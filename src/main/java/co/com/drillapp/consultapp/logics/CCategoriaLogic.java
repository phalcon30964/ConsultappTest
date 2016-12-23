package co.com.drillapp.consultapp.logics;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.drillapp.consultapp.daos.ICategoriaDAO;
import co.com.drillapp.consultapp.models.Categoria;
import co.com.drillapp.consultapp.models.Mediopago;

@Service
@Scope("singleton")
public class CCategoriaLogic implements ICategoriaLogic{
	
	@Autowired
	private ICategoriaDAO categoriaDAO;

	
	/**
	 * Metodo que permite persistir una categoria en la base de datos. Se debe validar y se debe generar un id unico. 
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void save(Categoria categoria) throws Exception {
		System.out.println("Entro a logic---------------------------------------------------------------------------");
		validarCategoria(categoria);
		if(validarSiExisteCategoria(categoria)){
			throw new Exception("Ya existe categoria");
		}
		categoriaDAO.persist(categoria);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void edit(Categoria categoria) throws Exception {
		System.out.println("Entro a logic---------------------------------------------------------------------------");
		validarCategoria(categoria);
		if(!validarSiExisteCategoria(categoria)){
			throw new Exception("No existe categoria");
		}
		categoriaDAO.merge(categoria);
	}
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer idCategoria) throws Exception {
		System.out.println("Entro a logic---------------------------------------------------------------------------");
		if(getById(idCategoria)==null){
			throw new Exception("No existe categoria");
		}
		categoriaDAO.removeById(idCategoria);
	}

	@Override
	@Transactional(readOnly = true)
	public Categoria getById(Integer idCategoria) {
		System.out.println("Entro a logic---------------------------------------------------------------------------");
		return categoriaDAO.getById(idCategoria);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Categoria> getAll() {
		System.out.println("Entro a logic---------------------------------------------------------------------------");
		return categoriaDAO.getAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long getLength() {
		System.out.println("Entro a logic---------------------------------------------------------------------------");
		return categoriaDAO.getLength();
	}

	private void validarCategoria(Categoria categoria) throws Exception {
		if(categoria==null || categoria.getNombreCategoria()==null||categoria.getNombreCategoria().isEmpty()){
			throw new Exception("Categoria invalida");
		}
		
	}
	
	private boolean validarSiExisteCategoria(Categoria categoria) throws Exception{
		return (getById(categoria.getIdCategoria()))!=null;
	}
	


}
