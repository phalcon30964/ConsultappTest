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
public class CalificacionClientePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8357018039139463233L;
	@Basic(optional = false)
	@Column(name = "identificacion_cliente")
	private String identificacionCliente;
	@Basic(optional = false)
	@Column(name = "tipo_identificacion_cliente")
	private String tipoIdentificacionCliente;
	@Basic(optional = false)
	@Column(name = "id_consulta")
	private int idConsulta;

	public CalificacionClientePK() {
	}

	public CalificacionClientePK(String identificacionCliente, String tipoIdentificacionCliente, int idConsulta) {
		this.identificacionCliente = identificacionCliente;
		this.tipoIdentificacionCliente = tipoIdentificacionCliente;
		this.idConsulta = idConsulta;
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
		hash += (identificacionCliente != null ? identificacionCliente.hashCode() : 0);
		hash += (tipoIdentificacionCliente != null ? tipoIdentificacionCliente.hashCode() : 0);
		hash += (int) idConsulta;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof CalificacionClientePK)) {
			return false;
		}
		CalificacionClientePK other = (CalificacionClientePK) object;
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
		return "javaapplication12.CalificacionClientePK[ identificacionCliente=" + identificacionCliente
				+ ", tipoIdentificacionCliente=" + tipoIdentificacionCliente + ", idConsulta=" + idConsulta + " ]";
	}

}
