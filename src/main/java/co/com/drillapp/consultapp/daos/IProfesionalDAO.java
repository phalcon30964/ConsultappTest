package co.com.drillapp.consultapp.daos;

import co.com.drillapp.consultapp.models.Profesional;
import co.com.drillapp.consultapp.models.ProfesionalPK;

public interface IProfesionalDAO {
	
	void persist(Profesional obj);
	
	void merge(Profesional obj);
	
	void remove(Profesional obj);
	
	Profesional getById(ProfesionalPK obj);

}
