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
public class SubcategoriaPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2553891753857669563L;
	@Basic(optional = false)
	@Column(name = "id_subcategoria")
	private int idSubcategoria;
	@Basic(optional = false)
	@Column(name = "id_categoria")
	private int idCategoria;

	public SubcategoriaPK() {
	}

	public SubcategoriaPK(int idSubcategoria, int idCategoria) {
		this.idSubcategoria = idSubcategoria;
		this.idCategoria = idCategoria;
	}

	public int getIdSubcategoria() {
		return idSubcategoria;
	}

	public void setIdSubcategoria(int idSubcategoria) {
		this.idSubcategoria = idSubcategoria;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (int) idSubcategoria;
		hash += (int) idCategoria;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof SubcategoriaPK)) {
			return false;
		}
		SubcategoriaPK other = (SubcategoriaPK) object;
		if (this.idSubcategoria != other.idSubcategoria) {
			return false;
		}
		if (this.idCategoria != other.idCategoria) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication12.SubcategoriaPK[ idSubcategoria=" + idSubcategoria + ", idCategoria=" + idCategoria
				+ " ]";
	}

}
