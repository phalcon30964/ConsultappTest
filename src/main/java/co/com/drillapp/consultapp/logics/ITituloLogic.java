package co.com.drillapp.consultapp.logics;

import co.com.drillapp.consultapp.models.Titulo;
import co.com.drillapp.consultapp.models.TituloPK;

public interface ITituloLogic {
	
	void persist(Titulo obj);
	
	void merge(Titulo obj);
	
	void remove(Titulo obj);
	
	Titulo getById(TituloPK obj);

}
