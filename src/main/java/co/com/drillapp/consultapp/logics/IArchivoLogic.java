package co.com.drillapp.consultapp.logics;

import co.com.drillapp.consultapp.models.Archivo;
import co.com.drillapp.consultapp.models.ArchivoPK;

public interface IArchivoLogic {
	
	void persist(Archivo obj);
	
	void merge(Archivo obj);
	
	void remove(Archivo obj);
	
	Archivo getById(ArchivoPK obj);
		
}
