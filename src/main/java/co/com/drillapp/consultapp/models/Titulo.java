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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ollic
 */
@Entity
@Table(name = "titulo")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Titulo.findAll", query = "SELECT t FROM Titulo t"),
		@NamedQuery(name = "Titulo.findByNombreTitulo", query = "SELECT t FROM Titulo t WHERE t.nombreTitulo = :nombreTitulo"),
		@NamedQuery(name = "Titulo.findByNivelEscolaridad", query = "SELECT t FROM Titulo t WHERE t.nivelEscolaridad = :nivelEscolaridad"),
		@NamedQuery(name = "Titulo.findByTipoDocumento", query = "SELECT t FROM Titulo t WHERE t.tituloPK.tipoDocumento = :tipoDocumento"),
		@NamedQuery(name = "Titulo.findByNumeroDocumento", query = "SELECT t FROM Titulo t WHERE t.tituloPK.numeroDocumento = :numeroDocumento"),
		@NamedQuery(name = "Titulo.findByEstado", query = "SELECT t FROM Titulo t WHERE t.estado = :estado"),
		@NamedQuery(name = "Titulo.findByIdSubcategoria", query = "SELECT t FROM Titulo t WHERE t.tituloPK.idSubcategoria = :idSubcategoria"),
		@NamedQuery(name = "Titulo.findByIdCategoria", query = "SELECT t FROM Titulo t WHERE t.tituloPK.idCategoria = :idCategoria") })
public class Titulo implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected TituloPK tituloPK;
	@Basic(optional = false)
	@Column(name = "nombre_titulo")
	private String nombreTitulo;
	@Basic(optional = false)
	@Column(name = "nivel_escolaridad")
	private String nivelEscolaridad;
	@Basic(optional = false)
	@Column(name = "estado")
	private String estado;
	@JoinColumns({ @JoinColumn(name = "identificacion_profesional", referencedColumnName = "identificacion"),
			@JoinColumn(name = "tipo_identificacion_profesional", referencedColumnName = "tipo_identificacion") })
	@ManyToOne(optional = false)
	private Profesional profesional;
	@JoinColumns({
			@JoinColumn(name = "id_subcategoria", referencedColumnName = "id_subcategoria", insertable = false, updatable = false),
			@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", insertable = false, updatable = false) })
	@ManyToOne(optional = false)
	private Subcategoria subcategoria;

	public Titulo() {
	}

	public Titulo(TituloPK tituloPK) {
		this.tituloPK = tituloPK;
	}

	public Titulo(TituloPK tituloPK, String nombreTitulo, String nivelEscolaridad, String estado) {
		this.tituloPK = tituloPK;
		this.nombreTitulo = nombreTitulo;
		this.nivelEscolaridad = nivelEscolaridad;
		this.estado = estado;
	}

	public Titulo(String tipoDocumento, String numeroDocumento, int idSubcategoria, int idCategoria) {
		this.tituloPK = new TituloPK(tipoDocumento, numeroDocumento, idSubcategoria, idCategoria);
	}

	public TituloPK getTituloPK() {
		return tituloPK;
	}

	public void setTituloPK(TituloPK tituloPK) {
		this.tituloPK = tituloPK;
	}

	public String getNombreTitulo() {
		return nombreTitulo;
	}

	public void setNombreTitulo(String nombreTitulo) {
		this.nombreTitulo = nombreTitulo;
	}

	public String getNivelEscolaridad() {
		return nivelEscolaridad;
	}

	public void setNivelEscolaridad(String nivelEscolaridad) {
		this.nivelEscolaridad = nivelEscolaridad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	public Subcategoria getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (tituloPK != null ? tituloPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Titulo)) {
			return false;
		}
		Titulo other = (Titulo) object;
		if ((this.tituloPK == null && other.tituloPK != null)
				|| (this.tituloPK != null && !this.tituloPK.equals(other.tituloPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication12.Titulo[ tituloPK=" + tituloPK + " ]";
	}

}
