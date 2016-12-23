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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Cliente.findByEmailContrasena", query = "SELECT c FROM Cliente c WHERE c.email = :email AND c.password = :password"), 
		@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
		@NamedQuery(name = "Cliente.findByIdentificacion", query = "SELECT c FROM Cliente c WHERE c.clientePK.identificacion = :identificacion"),
		@NamedQuery(name = "Cliente.findByTipoIdentificacion", query = "SELECT c FROM Cliente c WHERE c.clientePK.tipoIdentificacion = :tipoIdentificacion"),
		@NamedQuery(name = "Cliente.findByEstado", query = "SELECT c FROM Cliente c WHERE c.estado = :estado"),
		@NamedQuery(name = "Cliente.findByNombres", query = "SELECT c FROM Cliente c WHERE c.nombres = :nombres"),
		@NamedQuery(name = "Cliente.findByApellidos", query = "SELECT c FROM Cliente c WHERE c.apellidos = :apellidos"),
		@NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email"),
		@NamedQuery(name = "Cliente.findByPassword", query = "SELECT c FROM Cliente c WHERE c.password = :password"),
		@NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono"),
		@NamedQuery(name = "Cliente.findByFechaNacimiento", query = "SELECT c FROM Cliente c WHERE c.fechaNacimiento = :fechaNacimiento"),
		@NamedQuery(name = "Cliente.findByUrlFoto", query = "SELECT c FROM Cliente c WHERE c.urlFoto = :urlFoto") })
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected ClientePK clientePK;
	@Basic(optional = false)
	@Column(name = "estado")
	private String estado;
	@Basic(optional = false)
	@Column(name = "nombres")
	private String nombres;
	@Basic(optional = false)
	@Column(name = "apellidos")
	private String apellidos;
	@Basic(optional = false)
	@Column(name = "email")
	private String email;
	@Basic(optional = false)
	@Column(name = "password")
	private String password;
	@Basic(optional = false)
	@Column(name = "telefono")
	private String telefono;
	@Basic(optional = false)
	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaNacimiento;
	@Basic(optional = false)
	@Column(name = "url_foto")
	private String urlFoto;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<CalificacionCliente> calificacionClienteList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<Consulta> consultaList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<Mediopago> mediopagoList;

	public Cliente() {
	}

	public Cliente(ClientePK clientePK) {
		this.clientePK = clientePK;
	}

	public Cliente(ClientePK clientePK, String estado, String nombres, String apellidos, String email, String password,
			String telefono, Date fechaNacimiento, String urlFoto) {
		this.clientePK = clientePK;
		this.estado = estado;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.urlFoto = urlFoto;
	}

	public Cliente(String identificacion, String tipoIdentificacion) {
		this.clientePK = new ClientePK(identificacion, tipoIdentificacion);
	}

	public ClientePK getClientePK() {
		return clientePK;
	}

	public void setClientePK(ClientePK clientePK) {
		this.clientePK = clientePK;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	@XmlTransient
	public List<CalificacionCliente> getCalificacionClienteList() {
		return calificacionClienteList;
	}

	public void setCalificacionClienteList(List<CalificacionCliente> calificacionClienteList) {
		this.calificacionClienteList = calificacionClienteList;
	}

	@XmlTransient
	public List<Consulta> getConsultaList() {
		return consultaList;
	}

	public void setConsultaList(List<Consulta> consultaList) {
		this.consultaList = consultaList;
	}

	@XmlTransient
	public List<Mediopago> getMediopagoList() {
		return mediopagoList;
	}

	public void setMediopagoList(List<Mediopago> mediopagoList) {
		this.mediopagoList = mediopagoList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (clientePK != null ? clientePK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Cliente)) {
			return false;
		}
		Cliente other = (Cliente) object;
		if ((this.clientePK == null && other.clientePK != null)
				|| (this.clientePK != null && !this.clientePK.equals(other.clientePK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication12.Cliente[ clientePK=" + clientePK + " ]";
	}

}
