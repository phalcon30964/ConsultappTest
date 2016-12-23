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
public class ArchivoPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7997955215969369760L;
	@Basic(optional = false)
	@Column(name = "url_archivo")
	private String urlArchivo;
	@Basic(optional = false)
	@Column(name = "id_consulta")
	private int idConsulta;

	public ArchivoPK() {
	}

	public ArchivoPK(String urlArchivo, int idConsulta) {
		this.urlArchivo = urlArchivo;
		this.idConsulta = idConsulta;
	}

	public String getUrlArchivo() {
		return urlArchivo;
	}

	public void setUrlArchivo(String urlArchivo) {
		this.urlArchivo = urlArchivo;
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (urlArchivo != null ? urlArchivo.hashCode() : 0);
		hash += (int) idConsulta;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ArchivoPK)) {
			return false;
		}
		ArchivoPK other = (ArchivoPK) object;
		if ((this.urlArchivo == null && other.urlArchivo != null)
				|| (this.urlArchivo != null && !this.urlArchivo.equals(other.urlArchivo))) {
			return false;
		}
		if (this.idConsulta != other.idConsulta) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication12.ArchivoPK[ urlArchivo=" + urlArchivo + ", idConsulta=" + idConsulta + " ]";
	}

}
