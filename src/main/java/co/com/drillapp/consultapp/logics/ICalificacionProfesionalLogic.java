package co.com.drillapp.consultapp.logics;

import co.com.drillapp.consultapp.models.CalificacionProfesional;
import co.com.drillapp.consultapp.models.CalificacionProfesionalPK;

public interface ICalificacionProfesionalLogic {
	
	void persist(CalificacionProfesional obj);
	
	void merge(CalificacionProfesional obj);
	
	void remove(CalificacionProfesional obj);
	
	CalificacionProfesional getById(CalificacionProfesionalPK obj);

}
