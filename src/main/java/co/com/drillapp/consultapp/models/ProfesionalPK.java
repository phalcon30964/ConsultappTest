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
public class ProfesionalPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7642924154591962757L;
	@Basic(optional = false)
	@Column(name = "identificacion")
	private String identificacion;
	@Basic(optional = false)
	@Column(name = "tipo_identificacion")
	private String tipoIdentificacion;

	public ProfesionalPK() {
	}

	public ProfesionalPK(String identificacion, String tipoIdentificacion) {
		this.identificacion = identificacion;
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (identificacion != null ? identificacion.hashCode() : 0);
		hash += (tipoIdentificacion != null ? tipoIdentificacion.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProfesionalPK)) {
			return false;
		}
		ProfesionalPK other = (ProfesionalPK) object;
		if ((this.identificacion == null && other.identificacion != null)
				|| (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
			return false;
		}
		if ((this.tipoIdentificacion == null && other.tipoIdentificacion != null)
				|| (this.tipoIdentificacion != null && !this.tipoIdentificacion.equals(other.tipoIdentificacion))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication12.ProfesionalPK[ identificacion=" + identificacion + ", tipoIdentificacion="
				+ tipoIdentificacion + " ]";
	}

}
