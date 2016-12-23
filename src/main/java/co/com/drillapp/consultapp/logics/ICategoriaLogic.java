package co.com.drillapp.consultapp.logics;

import java.util.List;

import co.com.drillapp.consultapp.models.Categoria;
import co.com.drillapp.consultapp.models.Mediopago;

public interface ICategoriaLogic {
	
	public void save(Categoria categoria) throws Exception;

	public void edit(Categoria categoria) throws Exception;
	
	public void deleteById(Integer idCategoria) throws Exception;

	public Categoria getById(Integer obj) throws Exception;

	public List<Categoria> getAll() throws Exception;

	public Long getLength();


}
