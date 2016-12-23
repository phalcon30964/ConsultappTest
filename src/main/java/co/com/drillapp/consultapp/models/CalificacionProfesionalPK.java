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
public class CalificacionProfesionalPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -194808338543100692L;
	@Basic(optional = false)
	@Column(name = "identificacion_profesional")
	private String identificacionProfesional;
	@Basic(optional = false)
	@Column(name = "tipo_identificacion_profesional")
	private String tipoIdentificacionProfesional;
	@Basic(optional = false)
	@Column(name = "id_consulta")
	private int idConsulta;

	public CalificacionProfesionalPK() {
	}

	public CalificacionProfesionalPK(String identificacionProfesional, String tipoIdentificacionProfesional,
			int idConsulta) {
		this.identificacionProfesional = identificacionProfesional;
		this.tipoIdentificacionProfesional = tipoIdentificacionProfesional;
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
		hash += (int) idConsulta;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof CalificacionProfesionalPK)) {
			return false;
		}
		CalificacionProfesionalPK other = (CalificacionProfesionalPK) object;
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
		if (this.idConsulta != other.idConsulta) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication12.CalificacionProfesionalPK[ identificacionProfesional=" + identificacionProfesional
				+ ", tipoIdentificacionProfesional=" + tipoIdentificacionProfesional + ", idConsulta=" + idConsulta
				+ " ]";
	}

}
