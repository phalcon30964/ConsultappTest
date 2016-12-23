package co.com.drillapp.consultapp.daos;

import co.com.drillapp.consultapp.models.Titulo;
import co.com.drillapp.consultapp.models.TituloPK;

public interface ITituloDAO {
	
	void persist(Titulo obj);
	
	void merge(Titulo obj);
	
	void remove(Titulo obj);
	
	Titulo getById(TituloPK obj);

}
