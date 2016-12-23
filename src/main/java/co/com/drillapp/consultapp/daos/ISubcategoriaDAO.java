package co.com.drillapp.consultapp.daos;

import java.util.List;

import co.com.drillapp.consultapp.models.Subcategoria;
import co.com.drillapp.consultapp.models.SubcategoriaPK;

public interface ISubcategoriaDAO {
	
	public void persist(Subcategoria obj);
	
	public void merge(Subcategoria obj);
	
	public void remove(SubcategoriaPK obj);
	
	public Subcategoria getById(SubcategoriaPK obj);

	public List<Subcategoria> getByIdCategoria(int idCat);

}
