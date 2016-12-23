package co.com.drillapp.consultapp.daos;

import co.com.drillapp.consultapp.models.Consulta;

public interface IConsultaDAO {
	
	void persist(Consulta obj);
	
	void merge(Consulta obj);
	
	void remove(Consulta obj);
	
	Consulta getById(Integer obj);

}
