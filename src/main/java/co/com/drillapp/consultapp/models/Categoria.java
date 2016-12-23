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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({ 
		@NamedQuery(name = "Categoria.findLength", query = "SELECT count(c) FROM Categoria c"),
		@NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
		@NamedQuery(name = "Categoria.findByIdCategoria", query = "SELECT c FROM Categoria c WHERE c.idCategoria = :idCategoria"),
		@NamedQuery(name = "Categoria.findByNombreCategoria", query = "SELECT c FROM Categoria c WHERE c.nombreCategoria = :nombreCategoria") })
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "id_categoria")
	private Integer idCategoria;
	@Basic(optional = false)
	@Column(name = "nombre_categoria")
	private String nombreCategoria;
	@Basic(optional = false)
	@Lob
	@Column(name = "descripcion")
	private String descripcion;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
	private List<Subcategoria> subcategoriaList;

	public Categoria() {
	}

	public Categoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Categoria(Integer idCategoria, String nombreCategoria, String descripcion) {
		this.idCategoria = idCategoria;
		this.nombreCategoria = nombreCategoria;
		this.descripcion = descripcion;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@XmlTransient
	public List<Subcategoria> getSubcategoriaList() {
		return subcategoriaList;
	}

	public void setSubcategoriaList(List<Subcategoria> subcategoriaList) {
		this.subcategoriaList = subcategoriaList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idCategoria != null ? idCategoria.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Categoria)) {
			return false;
		}
		Categoria other = (Categoria) object;
		if ((this.idCategoria == null && other.idCategoria != null)
				|| (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication12.Categoria[ idCategoria=" + idCategoria + " ]";
	}

}
