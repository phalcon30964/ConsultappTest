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
@Table(name = "transaccion")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t"),
		@NamedQuery(name = "Transaccion.findByIdentificacionProfesional", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.identificacionProfesional = :identificacionProfesional"),
		@NamedQuery(name = "Transaccion.findByTipoIdentificacionProfesional", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.tipoIdentificacionProfesional = :tipoIdentificacionProfesional"),
		@NamedQuery(name = "Transaccion.findByNumeroTarjeta", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.numeroTarjeta = :numeroTarjeta"),
		@NamedQuery(name = "Transaccion.findByIdentificacionCliente", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.identificacionCliente = :identificacionCliente"),
		@NamedQuery(name = "Transaccion.findByTipoIdentificacionCliente", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.tipoIdentificacionCliente = :tipoIdentificacionCliente"),
		@NamedQuery(name = "Transaccion.findByCosto", query = "SELECT t FROM Transaccion t WHERE t.costo = :costo"),
		@NamedQuery(name = "Transaccion.findByStatus", query = "SELECT t FROM Transaccion t WHERE t.status = :status"),
		@NamedQuery(name = "Transaccion.findByIdConsulta", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.idConsulta = :idConsulta") })
public class Transaccion implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected TransaccionPK transaccionPK;
	@Basic(optional = false)
	@Column(name = "costo")
	private double costo;
	@Basic(optional = false)
	@Column(name = "status")
	private String status;
	@JoinColumn(name = "id_consulta", referencedColumnName = "id_consulta", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Consulta consulta;
	@JoinColumns({
			@JoinColumn(name = "numero_tarjeta", referencedColumnName = "numero_tarjeta", insertable = false, updatable = false),
			@JoinColumn(name = "identificacion_cliente", referencedColumnName = "identificacion_cliente", insertable = false, updatable = false),
			@JoinColumn(name = "tipo_identificacion_cliente", referencedColumnName = "tipo_identificacion_cliente", insertable = false, updatable = false) })
	@OneToOne(optional = false)
	private Mediopago mediopago;
	@JoinColumns({
			@JoinColumn(name = "identificacion_profesional", referencedColumnName = "identificacion", insertable = false, updatable = false),
			@JoinColumn(name = "tipo_identificacion_profesional", referencedColumnName = "tipo_identificacion", insertable = false, updatable = false) })
	@ManyToOne(optional = false)
	private Profesional profesional;

	public Transaccion() {
	}

	public Transaccion(TransaccionPK transaccionPK) {
		this.transaccionPK = transaccionPK;
	}

	public Transaccion(TransaccionPK transaccionPK, double costo, String status) {
		this.transaccionPK = transaccionPK;
		this.costo = costo;
		this.status = status;
	}

	public Transaccion(String identificacionProfesional, String tipoIdentificacionProfesional, String numeroTarjeta,
			String identificacionCliente, String tipoIdentificacionCliente, int idConsulta) {
		this.transaccionPK = new TransaccionPK(identificacionProfesional, tipoIdentificacionProfesional, numeroTarjeta,
				identificacionCliente, tipoIdentificacionCliente, idConsulta);
	}

	public TransaccionPK getTransaccionPK() {
		return transaccionPK;
	}

	public void setTransaccionPK(TransaccionPK transaccionPK) {
		this.transaccionPK = transaccionPK;
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

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Mediopago getMediopago() {
		return mediopago;
	}

	public void setMediopago(Mediopago mediopago) {
		this.mediopago = mediopago;
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
		hash += (transaccionPK != null ? transaccionPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Transaccion)) {
			return false;
		}
		Transaccion other = (Transaccion) object;
		if ((this.transaccionPK == null && other.transaccionPK != null)
				|| (this.transaccionPK != null && !this.transaccionPK.equals(other.transaccionPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication12.Transaccion[ transaccionPK=" + transaccionPK + " ]";
	}

}
