/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.drillapp.consultapp.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ollic
 */
@Embeddable
public class MediopagoPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5582849429999261496L;
	@Basic(optional = false)
	@Column(name = "numero_tarjeta")
	private String numeroTarjeta;
	@Basic(optional = false)
	@Column(name = "identificacion_cliente")
	private String identificacionCliente;
	@Basic(optional = false)
	@Column(name = "tipo_identificacion_cliente")
	private String tipoIdentificacionCliente;

	public MediopagoPK() {
	}

	public MediopagoPK(String numeroTarjeta, String identificacionCliente, String tipoIdentificacionCliente) {
		this.numeroTarjeta = numeroTarjeta;
		this.identificacionCliente = identificacionCliente;
		this.tipoIdentificacionCliente = tipoIdentificacionCliente;
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

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (numeroTarjeta != null ? numeroTarjeta.hashCode() : 0);
		hash += (identificacionCliente != null ? identificacionCliente.hashCode() : 0);
		hash += (tipoIdentificacionCliente != null ? tipoIdentificacionCliente.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof MediopagoPK)) {
			return false;
		}
		MediopagoPK other = (MediopagoPK) object;
		if ((this.numeroTarjeta == null && other.numeroTarjeta != null)
				|| (this.numeroTarjeta != null && !this.numeroTarjeta.equals(other.numeroTarjeta))) {
			return false;
		}
		if ((this.identificacionCliente == null && other.identificacionCliente != null)
				|| (this.identificacionCliente != null
						&& !this.identificacionCliente.equals(other.identificacionCliente))) {
			return false;
		}
		if ((this.tipoIdentificacionCliente == null && other.tipoIdentificacionCliente != null)
				|| (this.tipoIdentificacionCliente != null
						&& !this.tipoIdentificacionCliente.equals(other.tipoIdentificacionCliente))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication12.MediopagoPK[ numeroTarjeta=" + numeroTarjeta + ", identificacionCliente="
				+ identificacionCliente + ", tipoIdentificacionCliente=" + tipoIdentificacionCliente + " ]";
	}

}
