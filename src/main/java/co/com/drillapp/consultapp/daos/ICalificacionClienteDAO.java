package co.com.drillapp.consultapp.daos;

import co.com.drillapp.consultapp.models.CalificacionCliente;
import co.com.drillapp.consultapp.models.CalificacionClientePK;

public interface ICalificacionClienteDAO {
	
	void persist(CalificacionCliente obj);
	
	void merge(CalificacionCliente obj);
	
	void remove(CalificacionCliente obj);
	
	CalificacionCliente getById(CalificacionClientePK obj);

}
