package co.com.drillapp.consultapp.logics;

import java.util.List;

import co.com.drillapp.consultapp.models.Subcategoria;
import co.com.drillapp.consultapp.models.SubcategoriaPK;


public interface ISubcategoriaLogic {
	
	public void save(Subcategoria subcategoria) throws Exception;

	public void edit(Subcategoria subcategoria) throws Exception;
	
	public void deleteById(SubcategoriaPK subcategoriaPK) throws Exception;

	public Subcategoria getById(SubcategoriaPK subcategoriaPK)throws Exception;

	public List<Subcategoria> getByIdCategoria(int idCat)throws Exception;

}
