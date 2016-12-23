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
public class TransaccionPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5589327742037678362L;
	@Basic(optional = false)
	@Column(name = "identificacion_profesional")
	private String identificacionProfesional;
	@Basic(optional = false)
	@Column(name = "tipo_identificacion_profesional")
	private String tipoIdentificacionProfesional;
	@Basic(optional = false)
	@Column(name = "numero_tarjeta")
	private String numeroTarjeta;
	@Basic(optional = false)
	@Column(name = "identificacion_cliente")
	private String identificacionCliente;
	@Basic(optional = false)
	@Column(name = "tipo_identificacion_cliente")
	private String tipoIdentificacionCliente;
	@Basic(optional = false)
	@Column(name = "id_consulta")
	private int idConsulta;

	public TransaccionPK() {
	}

	public TransaccionPK(String identificacionProfesional, String tipoIdentificacionProfesional, String numeroTarjeta,
			String identificacionCliente, String tipoIdentificacionCliente, int idConsulta) {
		this.identificacionProfesional = identificacionProfesional;
		this.tipoIdentificacionProfesional = tipoIdentificacionProfesional;
		this.numeroTarjeta = numeroTarjeta;
		this.identificacionCliente = identificacionCliente;
		this.tipoIdentificacionCliente = tipoIdentificacionCliente;
		this.idConsulta = idConsulta;
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

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (identificacionProfesional != null ? identificacionProfesional.hashCode() : 0);
		hash += (tipoIdentificacionProfesional != null ? tipoIdentificacionProfesional.hashCode() : 0);
		hash += (numeroTarjeta != null ? numeroTarjeta.hashCode() : 0);
		hash += (identificacionCliente != null ? identificacionCliente.hashCode() : 0);
		hash += (tipoIdentificacionCliente != null ? tipoIdentificacionCliente.hashCode() : 0);
		hash += (int) idConsulta;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof TransaccionPK)) {
			return false;
		}
		TransaccionPK other = (TransaccionPK) object;
		if ((this.identificacionProfesional == null && other.identificacionProfesional != null)
				|| (this.identificacionProfesional != null
						&& !this.identificacionProfesional.equals(other.identificacionProfesional))) {
			return false;
		}
		if ((this.tipoIdentificacionProfesional == null && other.tipoIdentificacionProfesional != null)
				|| (this.tipoIdentificacionProfesional != null
						&& !this.tipoIdentificacionProfesional.equals(other.tipoIdentificacionProfesional))) {
			return false;
		}
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
		if (this.idConsulta != other.idConsulta) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication12.TransaccionPK[ identificacionProfesional=" + identificacionProfesional
				+ ", tipoIdentificacionProfesional=" + tipoIdentificacionProfesional + ", numeroTarjeta="
				+ numeroTarjeta + ", identificacionCliente=" + identificacionCliente + ", tipoIdentificacionCliente="
				+ tipoIdentificacionCliente + ", idConsulta=" + idConsulta + " ]";
	}

}
