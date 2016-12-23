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
@Table(name = "calificacion_cliente")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "CalificacionCliente.findAll", query = "SELECT c FROM CalificacionCliente c"),
		@NamedQuery(name = "CalificacionCliente.findByIdentificacionCliente", query = "SELECT c FROM CalificacionCliente c WHERE c.calificacionClientePK.identificacionCliente = :identificacionCliente"),
		@NamedQuery(name = "CalificacionCliente.findByTipoIdentificacionCliente", query = "SELECT c FROM CalificacionCliente c WHERE c.calificacionClientePK.tipoIdentificacionCliente = :tipoIdentificacionCliente"),
		@NamedQuery(name = "CalificacionCliente.findByIdConsulta", query = "SELECT c FROM CalificacionCliente c WHERE c.calificacionClientePK.idConsulta = :idConsulta"),
		@NamedQuery(name = "CalificacionCliente.findByCalificacion", query = "SELECT c FROM CalificacionCliente c WHERE c.calificacion = :calificacion") })
public class CalificacionCliente implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected CalificacionClientePK calificacionClientePK;
	@Basic(optional = false)
	@Column(name = "calificacion")
	private double calificacion;
	@JoinColumns({
			@JoinColumn(name = "identificacion_cliente", referencedColumnName = "identificacion", insertable = false, updatable = false),
			@JoinColumn(name = "tipo_identificacion_cliente", referencedColumnName = "tipo_identificacion", insertable = false, updatable = false) })
	@ManyToOne(optional = false)
	private Cliente cliente;
	@JoinColumn(name = "id_consulta", referencedColumnName = "id_consulta", insertable = false, updatable = false)
	@OneToOne(optional = false)
	private Consulta consulta;

	public CalificacionCliente() {
	}

	public CalificacionCliente(CalificacionClientePK calificacionClientePK) {
		this.calificacionClientePK = calificacionClientePK;
	}

	public CalificacionCliente(CalificacionClientePK calificacionClientePK, double calificacion) {
		this.calificacionClientePK = calificacionClientePK;
		this.calificacion = calificacion;
	}

	public CalificacionCliente(String identificacionCliente, String tipoIdentificacionCliente, int idConsulta) {
		this.calificacionClientePK = new CalificacionClientePK(identificacionCliente, tipoIdentificacionCliente,
				idConsulta);
	}

	public CalificacionClientePK getCalificacionClientePK() {
		return calificacionClientePK;
	}

	public void setCalificacionClientePK(CalificacionClientePK calificacionClientePK) {
		this.calificacionClientePK = calificacionClientePK;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (calificacionClientePK != null ? calificacionClientePK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof CalificacionCliente)) {
			return false;
		}
		CalificacionCliente other = (CalificacionCliente) object;
		if ((this.calificacionClientePK == null && other.calificacionClientePK != null)
				|| (this.calificacionClientePK != null
						&& !this.calificacionClientePK.equals(other.calificacionClientePK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication12.CalificacionCliente[ calificacionClientePK=" + calificacionClientePK + " ]";
	}

}
