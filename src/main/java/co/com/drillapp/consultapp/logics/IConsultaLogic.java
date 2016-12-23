package co.com.drillapp.consultapp.logics;

import co.com.drillapp.consultapp.models.Consulta;

public interface IConsultaLogic {
	
	void persist(Consulta obj);
	
	void merge(Consulta obj);
	
	void remove(Consulta obj);
	
	Consulta getById(Integer obj);

}
