package co.com.drillapp.consultapp.logics;

import co.com.drillapp.consultapp.models.CalificacionCliente;
import co.com.drillapp.consultapp.models.CalificacionClientePK;

public interface ICalificacionClienteLogic {
	
	void persist(CalificacionCliente obj);
	
	void merge(CalificacionCliente obj);
	
	void remove(CalificacionCliente obj);
	
	CalificacionCliente getById(CalificacionClientePK obj);

}
