package co.com.drillapp.consultapp.logics;

import co.com.drillapp.consultapp.models.Mediopago;
import co.com.drillapp.consultapp.models.MediopagoPK;

public interface IMediopagoLogic {
	
	  public void save(Mediopago mediopago) throws Exception;

	  public void edit(Mediopago mediopago) throws Exception;

	  public void delete(MediopagoPK mediopagoPk) throws Exception;

	  public Mediopago getById(MediopagoPK mediopagoPk) throws Exception;

}
