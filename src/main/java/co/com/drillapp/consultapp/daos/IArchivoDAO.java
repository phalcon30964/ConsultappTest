package co.com.drillapp.consultapp.daos;

import co.com.drillapp.consultapp.models.Archivo;
import co.com.drillapp.consultapp.models.ArchivoPK;

public interface IArchivoDAO {
	
	void persist(Archivo obj);
	
	void merge(Archivo obj);
	
	void remove(Archivo obj);
	
	Archivo getById(ArchivoPK obj);
		
}
