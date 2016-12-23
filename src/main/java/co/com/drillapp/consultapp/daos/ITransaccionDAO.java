package co.com.drillapp.consultapp.daos;

import co.com.drillapp.consultapp.models.Transaccion;
import co.com.drillapp.consultapp.models.TransaccionPK;

public interface ITransaccionDAO {
	
	void persist(Transaccion obj);
	
	void merge(Transaccion obj);
	
	void remove(Transaccion obj);
	
	Transaccion getById(TransaccionPK obj);

}
