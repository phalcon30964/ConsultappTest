package co.com.drillapp.consultapp.daos;

import co.com.drillapp.consultapp.models.CalificacionProfesional;
import co.com.drillapp.consultapp.models.CalificacionProfesionalPK;

public interface ICalificacionProfesionalDAO {
	
	void persist(CalificacionProfesional obj);
	
	void merge(CalificacionProfesional obj);
	
	void remove(CalificacionProfesional obj);
	
	CalificacionProfesional getById(CalificacionProfesionalPK obj);

}
