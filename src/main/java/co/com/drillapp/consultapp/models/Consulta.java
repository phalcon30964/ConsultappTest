/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.drillapp.consultapp.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "consulta")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Consulta.findAll", query = "SELECT c FROM Consulta c"),
		@NamedQuery(name = "Consulta.findByIdConsulta", query = "SELECT c FROM Consulta c WHERE c.idConsulta = :idConsulta"),
		@NamedQuery(name = "Consulta.findByFechaHora", query = "SELECT c FROM Consulta c WHERE c.fechaHora = :fechaHora"),
		@NamedQuery(name = "Consulta.findByDescripcion", query = "SELECT c FROM Consulta c WHERE c.descripcion = :descripcion"),
		@NamedQuery(name = "Consulta.findByDuracion", query = "SELECT c FROM Consulta c WHERE c.duracion = :duracion") })
public class Consulta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "id_consulta")
	private Integer idConsulta;
	@Basic(optional = false)
	@Column(name = "fecha_hora")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHora;
	@Basic(optional = false)
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "duracion")
	private Integer duracion;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "consulta")
	private CalificacionCliente calificacionCliente;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "consulta")
	private List<Archivo> archivoList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "consulta")
	private List<Transaccion> transaccionList;
	@JoinColumns({ @JoinColumn(name = "identificacion_cliente", referencedColumnName = "identificacion"),
			@JoinColumn(name = "tipo_identificacion_cliente", referencedColumnName = "tipo_identificacion") })
	@ManyToOne(optional = false)
	private Cliente cliente;
	@JoinColumns({ @JoinColumn(name = "identificacion_profesional", referencedColumnName = "identificacion"),
			@JoinColumn(name = "tipo_identificacion_profesional", referencedColumnName = "tipo_identificacion") })
	@ManyToOne(optional = false)
	private Profesional profesional;
	@ManyToOne(optional = false)
	@JoinColumns({ @JoinColumn(name = "id_subcategoria", referencedColumnName = "id_subcategoria"),
			@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria") })
	private Subcategoria idSubcategoria;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "consulta")
	private CalificacionProfesional calificacionProfesional;

	public Consulta() {
	}

	public Consulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Consulta(Integer idConsulta, Date fechaHora, String descripcion) {
		this.idConsulta = idConsulta;
		this.fechaHora = fechaHora;
		this.descripcion = descripcion;
	}

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	@XmlTransient
	public CalificacionCliente getcalificacionCliente() {
		return calificacionCliente;
	}

	public void setcalificacionCliente(CalificacionCliente calificacionCliente) {
		this.calificacionCliente = calificacionCliente;
	}

	@XmlTransient
	public List<Archivo> getArchivoList() {
		return archivoList;
	}

	public void setArchivoList(List<Archivo> archivoList) {
		this.archivoList = archivoList;
	}

	@XmlTransient
	public List<Transaccion> getTransaccionList() {
		return transaccionList;
	}

	public void setTransaccionList(List<Transaccion> transaccionList) {
		this.transaccionList = transaccionList;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	public Subcategoria getIdSubcategoria() {
		return idSubcategoria;
	}

	public void setIdSubcategoria(Subcategoria idSubcategoria) {
		this.idSubcategoria = idSubcategoria;
	}

	@XmlTransient
	public CalificacionProfesional getcalificacionProfesional() {
		return calificacionProfesional;
	}

	public void setcalificacionProfesional(CalificacionProfesional calificacionProfesional) {
		this.calificacionProfesional = calificacionProfesional;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idConsulta != null ? idConsulta.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Consulta)) {
			return false;
		}
		Consulta other = (Consulta) object;
		if ((this.idConsulta == null && other.idConsulta != null)
				|| (this.idConsulta != null && !this.idConsulta.equals(other.idConsulta))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication12.Consulta[ idConsulta=" + idConsulta + " ]";
	}

}
