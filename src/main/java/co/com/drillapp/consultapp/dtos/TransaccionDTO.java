/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.drillapp.consultapp.dtos;

public class TransaccionDTO {

	private double costo;
	
	private String status;
	
	private String identificacionProfesional;
	
	private String tipoIdentificacionProfesional;
	
	private String numeroTarjeta;
	
	private String identificacionCliente;
	
	private String tipoIdentificacionCliente;
	
	private int idConsulta;

	public TransaccionDTO() {
		super();
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getIdentificacionCliente() {
		return identificacionCliente;
	}

	public void setIdentificacionCliente(String identificacionCliente) {
		this.identificacionCliente = identificacionCliente;
	}

	public String getTipoIdentificacionCliente() {
		return tipoIdentificacionCliente;
	}

	public void setTipoIdentificacionCliente(String tipoIdentificacionCliente) {
		this.tipoIdentificacionCliente = tipoIdentificacionCliente;
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	
	

}
