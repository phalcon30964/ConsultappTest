/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.drillapp.consultapp.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ollic
 */
@Entity
@Table(name = "subcategoria")
@XmlRootElement
@NamedQueries({ 
		@NamedQuery(name = "Subcategoria.findAll", query = "SELECT s FROM Subcategoria s"),
		@NamedQuery(name = "Subcategoria.findByIdSubcategoria", query = "SELECT s FROM Subcategoria s WHERE s.subcategoriaPK.idSubcategoria = :idSubcategoria"),
		@NamedQuery(name = "Subcategoria.findByNombreSubcategoria", query = "SELECT s FROM Subcategoria s WHERE s.nombreSubcategoria = :nombreSubcategoria"),
		@NamedQuery(name = "Subcategoria.findByIdCategoria", query = "SELECT s FROM Subcategoria s WHERE s.subcategoriaPK.idCategoria = :idCategoria") })
public class Subcategoria implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected SubcategoriaPK subcategoriaPK;
	@Basic(optional = false)
	@Column(name = "nombre_subcategoria")
	private String nombreSubcategoria;
	@Basic(optional = false)
	@Lob
	@Column(name = "descripcion")
	private String descripcion;
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Categoria categoria;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "subcategoria")
	private List<Titulo> tituloList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idSubcategoria")
	private List<Consulta> consultaList;

	public Subcategoria() {
	}

	public Subcategoria(SubcategoriaPK subcategoriaPK) {
		this.subcategoriaPK = subcategoriaPK;
	}

	public Subcategoria(SubcategoriaPK subcategoriaPK, String nombreSubcategoria, String descripcion) {
		this.subcategoriaPK = subcategoriaPK;
		this.nombreSubcategoria = nombreSubcategoria;
		this.descripcion = descripcion;
	}

	public Subcategoria(int idSubcategoria, int idCategoria) {
		this.subcategoriaPK = new SubcategoriaPK(idSubcategoria, idCategoria);
	}

	public SubcategoriaPK getSubcategoriaPK() {
		return subcategoriaPK;
	}

	public void setSubcategoriaPK(SubcategoriaPK subcategoriaPK) {
		this.subcategoriaPK = subcategoriaPK;
	}

	public String getNombreSubcategoria() {
		return nombreSubcategoria;
	}

	public void setNombreSubcategoria(String nombreSubcategoria) {
		this.nombreSubcategoria = nombreSubcategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@XmlTransient
	public List<Titulo> getTituloList() {
		return tituloList;
	}

	public void setTituloList(List<Titulo> tituloList) {
		this.tituloList = tituloList;
	}

	@XmlTransient
	public List<Consulta> getConsultaList() {
		return consultaList;
	}

	public void setConsultaList(List<Consulta> consultaList) {
		this.consultaList = consultaList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (subcategoriaPK != null ? subcategoriaPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Subcategoria)) {
			return false;
		}
		Subcategoria other = (Subcategoria) object;
		if ((this.subcategoriaPK == null && other.subcategoriaPK != null)
				|| (this.subcategoriaPK != null && !this.subcategoriaPK.equals(other.subcategoriaPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication12.Subcategoria[ subcategoriaPK=" + subcategoriaPK + " ]";
	}

}
