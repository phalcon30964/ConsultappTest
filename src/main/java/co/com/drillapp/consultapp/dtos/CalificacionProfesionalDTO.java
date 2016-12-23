/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.drillapp.consultapp.dtos;

public class CalificacionProfesionalDTO {
	
	private String identificacionProfesional;
	
	private String tipoIdentificacionProfesional;

	private int idConsulta;
	
	private double calificacion;

	public CalificacionProfesionalDTO() {
		super();
	}

	public String getIdentificacionProfesional() {
		return identificacionProfesional;
	}

	public void setIdentificacionProfesional(String identificacionProfesional) {
		this.identificacionProfesional = identificacionProfesional;
	}

	public String getTipoIdentificacionProfesional() {
		return tipoIdentificacionProfesional;
	}

	public void setTipoIdentificacionProfesional(String tipoIdentificacionProfesional) {
		this.tipoIdentificacionProfesional = tipoIdentificacionProfesional;
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	
	

}
