/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.drillapp.consultapp.models;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "archivo")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Archivo.findAll", query = "SELECT a FROM Archivo a"),
		@NamedQuery(name = "Archivo.findByUrlArchivo", query = "SELECT a FROM Archivo a WHERE a.archivoPK.urlArchivo = :urlArchivo"),
		@NamedQuery(name = "Archivo.findByIdConsulta", query = "SELECT a FROM Archivo a WHERE a.archivoPK.idConsulta = :idConsulta") })
public class Archivo implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected ArchivoPK archivoPK;
	@JoinColumn(name = "id_consulta", referencedColumnName = "id_consulta", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Consulta consulta;

	public Archivo() {
	}

	public Archivo(ArchivoPK archivoPK) {
		this.archivoPK = archivoPK;
	}

	public Archivo(String urlArchivo, int idConsulta) {
		this.archivoPK = new ArchivoPK(urlArchivo, idConsulta);
	}

	public ArchivoPK getArchivoPK() {
		return archivoPK;
	}

	public void setArchivoPK(ArchivoPK archivoPK) {
		this.archivoPK = archivoPK;
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
		hash += (archivoPK != null ? archivoPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Archivo)) {
			return false;
		}
		Archivo other = (Archivo) object;
		if ((this.archivoPK == null && other.archivoPK != null)
				|| (this.archivoPK != null && !this.archivoPK.equals(other.archivoPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication12.Archivo[ archivoPK=" + archivoPK + " ]";
	}

}
