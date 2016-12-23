package co.com.drillapp.consultapp.daos;

import java.util.List;

import co.com.drillapp.consultapp.models.Categoria;

public interface ICategoriaDAO {
	
	public void persist(Categoria obj);
	
	public void merge(Categoria obj);
	
	public void removeById(Integer obj);
	
	public Categoria getById(Integer obj);
	
	public List<Categoria> getAll();
	
	public Long getLength();

}
