package co.com.drillapp.consultapp.logics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.drillapp.consultapp.daos.ICategoriaDAO;
import co.com.drillapp.consultapp.daos.ISubcategoriaDAO;
import co.com.drillapp.consultapp.models.Subcategoria;
import co.com.drillapp.consultapp.models.SubcategoriaPK;

@Service
@Scope("singleton")
public class CSubcategoriaLogic implements ISubcategoriaLogic {

	@Autowired
	private ISubcategoriaDAO subcategoriaDAO;
	@Autowired
	private ICategoriaDAO categoriaDAO;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void save(Subcategoria subcategoria) throws Exception {
		System.out.println("Entro a logic---------------------------------------------------------------------------");
		validarSubCategoria(subcategoria);
		if (validarSiExisteSubCategoria(subcategoria)) {
			throw new Exception("Ya existe Subcategoria");
		}
		subcategoriaDAO.persist(subcategoria);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void edit(Subcategoria subcategoria) throws Exception {
		System.out.println("Entro a logic---------------------------------------------------------------------------");
		validarSubCategoria(subcategoria);
		if (!validarSiExisteSubCategoria(subcategoria)) {
			throw new Exception("No existe Subcategoria");
		}
		subcategoriaDAO.merge(subcategoria);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(SubcategoriaPK subcategoriaPK) throws Exception {
		System.out.println("Entro a logic---------------------------------------------------------------------------");
		if (subcategoriaPK == null || getById(subcategoriaPK) == null) {
			throw new Exception("No existe Subcategoria");
		}
		subcategoriaDAO.remove(subcategoriaPK);
	}

	@Override
	@Transactional(readOnly = true)
	public Subcategoria getById(SubcategoriaPK subcategoriaPK) throws Exception {
		System.out.println("Entro a logic---------------------------------------------------------------------------");
		if (subcategoriaPK == null) {
			throw new Exception("No existe Subcategoria");
		}
		return subcategoriaDAO.getById(subcategoriaPK);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Subcategoria> getByIdCategoria(int idCat) throws Exception {
		System.out.println("Entro a logic---------------------------------------------------------------------------");
	if (categoriaDAO.getById(idCat) == null) {
			throw new Exception("No existe categoria");
		}
		return subcategoriaDAO.getByIdCategoria(idCat);
	}

	private void validarSubCategoria(Subcategoria subcategoria) throws Exception {
		if(subcategoria==null || 
				subcategoria.getSubcategoriaPK() == null ||
				subcategoria.getDescripcion() == null ||
				subcategoria.getDescripcion().isEmpty() ||
				subcategoria.getNombreSubcategoria() == null ||
				subcategoria.getNombreSubcategoria().isEmpty()){
			throw new Exception("Subcategoria invalida");
			}
		}

	private boolean validarSiExisteSubCategoria(Subcategoria subcategoria) throws Exception {
		return getById(subcategoria.getSubcategoriaPK())!=null;
	}

}
