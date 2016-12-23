package co.com.drillapp.consultapp.daos;

import co.com.drillapp.consultapp.models.Mediopago;
import co.com.drillapp.consultapp.models.MediopagoPK;

public interface IMediopagoDAO {
	
	public void persist(Mediopago obj) throws Exception;
	
	public void merge(Mediopago obj) throws Exception;
	
	public void remove(MediopagoPK obj) throws Exception;
	
	public Mediopago getById(MediopagoPK obj) throws Exception;

}
