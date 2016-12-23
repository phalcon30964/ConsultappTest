/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.drillapp.consultapp.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ollic
 */
@Entity
@Table(name = "calificacion_profesional")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "CalificacionProfesional.findAll", query = "SELECT c FROM CalificacionProfesional c"),
		@NamedQuery(name = "CalificacionProfesional.findByIdentificacionProfesional", query = "SELECT c FROM CalificacionProfesional c WHERE c.calificacionProfesionalPK.identificacionProfesional = :identificacionProfesional"),
		@NamedQuery(name = "CalificacionProfesional.findByTipoIdentificacionProfesional", query = "SELECT c FROM CalificacionProfesional c WHERE c.calificacionProfesionalPK.tipoIdentificacionProfesional = :tipoIdentificacionProfesional"),
		@NamedQuery(name = "CalificacionProfesional.findByIdConsulta", query = "SELECT c FROM CalificacionProfesional c WHERE c.calificacionProfesionalPK.idConsulta = :idConsulta"),
		@NamedQuery(name = "CalificacionProfesional.findByCalificacion", query = "SELECT c FROM CalificacionProfesional c WHERE c.calificacion = :calificacion") })
public class CalificacionProfesional implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected CalificacionProfesionalPK calificacionProfesionalPK;
	@Basic(optional = false)
	@Column(name = "calificacion")
	private double calificacion;
	@JoinColumn(name = "id_consulta", referencedColumnName = "id_consulta", insertable = false, updatable = false)
	@OneToOne(optional = false)
	private Consulta consulta;
	@JoinColumns({
			@JoinColumn(name = "identificacion_profesional", referencedColumnName = "identificacion", insertable = false, updatable = false),
			@JoinColumn(name = "tipo_identificacion_profesional", referencedColumnName = "tipo_identificacion", insertable = false, updatable = false) })
	@ManyToOne(optional = false)
	private Profesional profesional;

	public CalificacionProfesional() {
	}

	public CalificacionProfesional(CalificacionProfesionalPK calificacionProfesionalPK) {
		this.calificacionProfesionalPK = calificacionProfesionalPK;
	}

	public CalificacionProfesional(CalificacionProfesionalPK calificacionProfesionalPK, double calificacion) {
		this.calificacionProfesionalPK = calificacionProfesionalPK;
		this.calificacion = calificacion;
	}

	public CalificacionProfesional(String identificacionProfesional, String tipoIdentificacionProfesional,
			int idConsulta) {
		this.calificacionProfesionalPK = new CalificacionProfesionalPK(identificacionProfesional,
				tipoIdentificacionProfesional, idConsulta);
	}

	public CalificacionProfesionalPK getCalificacionProfesionalPK() {
		return calificacionProfesionalPK;
	}

	public void setCalificacionProfesionalPK(CalificacionProfesionalPK calificacionProfesionalPK) {
		this.calificacionProfesionalPK = calificacionProfesionalPK;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (calificacionProfesionalPK != null ? calificacionProfesionalPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof CalificacionProfesional)) {
			return false;
		}
		CalificacionProfesional other = (CalificacionProfesional) object;
		if ((this.calificacionProfesionalPK == null && other.calificacionProfesionalPK != null)
				|| (this.calificacionProfesionalPK != null
						&& !this.calificacionProfesionalPK.equals(other.calificacionProfesionalPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication12.CalificacionProfesional[ calificacionProfesionalPK=" + calificacionProfesionalPK
				+ " ]";
	}

}
