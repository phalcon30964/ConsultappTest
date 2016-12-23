package co.com.drillapp.consultapp.logics;

import co.com.drillapp.consultapp.models.Profesional;
import co.com.drillapp.consultapp.models.ProfesionalPK;

public interface IProfesionalLogic {
	
	void persist(Profesional obj);
	
	void merge(Profesional obj);
	
	void remove(Profesional obj);
	
	Profesional getById(ProfesionalPK obj);

}
