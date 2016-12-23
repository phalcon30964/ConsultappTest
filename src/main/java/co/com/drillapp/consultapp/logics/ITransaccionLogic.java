package co.com.drillapp.consultapp.logics;

import co.com.drillapp.consultapp.models.Transaccion;
import co.com.drillapp.consultapp.models.TransaccionPK;

public interface ITransaccionLogic {
	
	void persist(Transaccion obj);
	
	void merge(Transaccion obj);
	
	void remove(Transaccion obj);
	
	Transaccion getById(TransaccionPK obj);

}
