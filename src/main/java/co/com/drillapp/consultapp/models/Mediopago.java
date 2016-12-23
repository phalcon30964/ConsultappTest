/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.drillapp.consultapp.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ollic
 */
@Entity
@Table(name = "mediopago")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Mediopago.findAll", query = "SELECT m FROM Mediopago m"),
		@NamedQuery(name = "Mediopago.findByNumeroTarjeta", query = "SELECT m FROM Mediopago m WHERE m.mediopagoPK.numeroTarjeta = :numeroTarjeta"),
		@NamedQuery(name = "Mediopago.findByFechaCaducidad", query = "SELECT m FROM Mediopago m WHERE m.fechaCaducidad = :fechaCaducidad"),
		@NamedQuery(name = "Mediopago.findByCodigoSeguridad", query = "SELECT m FROM Mediopago m WHERE m.codigoSeguridad = :codigoSeguridad"),
		@NamedQuery(name = "Mediopago.findByIdentificacionCliente", query = "SELECT m FROM Mediopago m WHERE m.mediopagoPK.identificacionCliente = :identificacionCliente"),
		@NamedQuery(name = "Mediopago.findByTipoIdentificacionCliente", query = "SELECT m FROM Mediopago m WHERE m.mediopagoPK.tipoIdentificacionCliente = :tipoIdentificacionCliente") })
public class Mediopago implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected MediopagoPK mediopagoPK;
	@Basic(optional = false)
	@Column(name = "fecha_caducidad")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCaducidad;
	@Basic(optional = false)
	@Column(name = "codigo_seguridad")
	private String codigoSeguridad;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "mediopago")
	private Transaccion transaccion;
	@JoinColumns({
			@JoinColumn(name = "identificacion_cliente", referencedColumnName = "identificacion", insertable = false, updatable = false),
			@JoinColumn(name = "tipo_identificacion_cliente", referencedColumnName = "tipo_identificacion", insertable = false, updatable = false) })
	@ManyToOne(optional = false)
	private Cliente cliente;

	public Mediopago() {
	}

	public Mediopago(MediopagoPK mediopagoPK) {
		this.mediopagoPK = mediopagoPK;
	}

	public Mediopago(MediopagoPK mediopagoPK, Date fechaCaducidad, String codigoSeguridad) {
		this.mediopagoPK = mediopagoPK;
		this.fechaCaducidad = fechaCaducidad;
		this.codigoSeguridad = codigoSeguridad;
	}

	public Mediopago(String numeroTarjeta, String identificacionCliente, String tipoIdentificacionCliente) {
		this.mediopagoPK = new MediopagoPK(numeroTarjeta, identificacionCliente, tipoIdentificacionCliente);
	}

	public MediopagoPK getMediopagoPK() {
		return mediopagoPK;
	}

	public void setMediopagoPK(MediopagoPK mediopagoPK) {
		this.mediopagoPK = mediopagoPK;
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

	@XmlTransient
	public Transaccion gettransaccion() {
		return transaccion;
	}

	public void settransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (mediopagoPK != null ? mediopagoPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Mediopago)) {
			return false;
		}
		Mediopago other = (Mediopago) object;
		if ((this.mediopagoPK == null && other.mediopagoPK != null)
				|| (this.mediopagoPK != null && !this.mediopagoPK.equals(other.mediopagoPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication12.Mediopago[ mediopagoPK=" + mediopagoPK + " ]";
	}

}
