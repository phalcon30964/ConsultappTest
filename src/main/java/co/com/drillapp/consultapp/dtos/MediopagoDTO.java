/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.drillapp.consultapp.dtos;

import java.util.Date;

public class MediopagoDTO {
	
	private String tipoMedioPago;//falta agregarla

	private Date fechaCaducidad;
	
	private String codigoSeguridad; //maximo 5
	
	private String numeroTarjeta;
	
	private String identificacionCliente;
	
	private String tipoIdentificacionCliente;
	
	
	public MediopagoDTO() {
		super();
	}


	public String getTipoMedioPago() {
		return tipoMedioPago;
	}


	public void setTipoMedioPago(String tipoMedioPago) {
		this.tipoMedioPago = tipoMedioPago;
	}


	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}


	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}


	public String getCodigoSeguridad() {
		return codigoSeguridad;
	}


	public void setCodigoSeguridad(String codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
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

}
