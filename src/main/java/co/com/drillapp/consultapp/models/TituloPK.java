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
public class TituloPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7238137960967001505L;
	@Basic(optional = false)
	@Column(name = "tipo_documento")
	private String tipoDocumento;
	@Basic(optional = false)
	@Column(name = "numero_documento")
	private String numeroDocumento;
	@Basic(optional = false)
	@Column(name = "id_subcategoria")
	private int idSubcategoria;
	@Basic(optional = false)
	@Column(name = "id_categoria")
	private int idCategoria;

	public TituloPK() {
	}

	public TituloPK(String tipoDocumento, String numeroDocumento, int idSubcategoria, int idCategoria) {
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.idSubcategoria = idSubcategoria;
		this.idCategoria = idCategoria;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
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
		hash += (tipoDocumento != null ? tipoDocumento.hashCode() : 0);
		hash += (numeroDocumento != null ? numeroDocumento.hashCode() : 0);
		hash += (int) idSubcategoria;
		hash += (int) idCategoria;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof TituloPK)) {
			return false;
		}
		TituloPK other = (TituloPK) object;
		if ((this.tipoDocumento == null && other.tipoDocumento != null)
				|| (this.tipoDocumento != null && !this.tipoDocumento.equals(other.tipoDocumento))) {
			return false;
		}
		if ((this.numeroDocumento == null && other.numeroDocumento != null)
				|| (this.numeroDocumento != null && !this.numeroDocumento.equals(other.numeroDocumento))) {
			return false;
		}
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
		return "javaapplication12.TituloPK[ tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento
				+ ", idSubcategoria=" + idSubcategoria + ", idCategoria=" + idCategoria + " ]";
	}

}
