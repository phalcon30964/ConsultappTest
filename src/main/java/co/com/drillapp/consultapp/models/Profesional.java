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
@Table(name = "profesional")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Profesional.findAll", query = "SELECT p FROM Profesional p"),
		@NamedQuery(name = "Profesional.findByIdentificacion", query = "SELECT p FROM Profesional p WHERE p.profesionalPK.identificacion = :identificacion"),
		@NamedQuery(name = "Profesional.findByTipoIdentificacion", query = "SELECT p FROM Profesional p WHERE p.profesionalPK.tipoIdentificacion = :tipoIdentificacion"),
		@NamedQuery(name = "Profesional.findByEstado", query = "SELECT p FROM Profesional p WHERE p.estado = :estado"),
		@NamedQuery(name = "Profesional.findByNombres", query = "SELECT p FROM Profesional p WHERE p.nombres = :nombres"),
		@NamedQuery(name = "Profesional.findByApellidos", query = "SELECT p FROM Profesional p WHERE p.apellidos = :apellidos"),
		@NamedQuery(name = "Profesional.findByEmail", query = "SELECT p FROM Profesional p WHERE p.email = :email"),
		@NamedQuery(name = "Profesional.findByTelefono", query = "SELECT p FROM Profesional p WHERE p.telefono = :telefono"),
		@NamedQuery(name = "Profesional.findByFechaNacimiento", query = "SELECT p FROM Profesional p WHERE p.fechaNacimiento = :fechaNacimiento"),
		@NamedQuery(name = "Profesional.findByPais", query = "SELECT p FROM Profesional p WHERE p.pais = :pais"),
		@NamedQuery(name = "Profesional.findByPassword", query = "SELECT p FROM Profesional p WHERE p.password = :password"),
		@NamedQuery(name = "Profesional.findByUrlFoto", query = "SELECT p FROM Profesional p WHERE p.urlFoto = :urlFoto"),
		@NamedQuery(name = "Profesional.findByNombreBanco", query = "SELECT p FROM Profesional p WHERE p.nombreBanco = :nombreBanco"),
		@NamedQuery(name = "Profesional.findByNumeroCuenta", query = "SELECT p FROM Profesional p WHERE p.numeroCuenta = :numeroCuenta"),
		@NamedQuery(name = "Profesional.findByTipoCuenta", query = "SELECT p FROM Profesional p WHERE p.tipoCuenta = :tipoCuenta"),
		@NamedQuery(name = "Profesional.findByCostoPreferido", query = "SELECT p FROM Profesional p WHERE p.costoPreferido = :costoPreferido"),
		@NamedQuery(name = "Profesional.findByTipoMoneda", query = "SELECT p FROM Profesional p WHERE p.tipoMoneda = :tipoMoneda") })
public class Profesional implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected ProfesionalPK profesionalPK;
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
	@Column(name = "telefono")
	private String telefono;
	@Basic(optional = false)
	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaNacimiento;
	@Basic(optional = false)
	@Column(name = "pais")
	private String pais;
	@Basic(optional = false)
	@Column(name = "password")
	private String password;
	@Basic(optional = false)
	@Column(name = "url_foto")
	private String urlFoto;
	@Basic(optional = false)
	@Column(name = "nombre_banco")
	private String nombreBanco;
	@Basic(optional = false)
	@Column(name = "numero_cuenta")
	private String numeroCuenta;
	@Basic(optional = false)
	@Column(name = "tipo_cuenta")
	private String tipoCuenta;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "costo_preferido")
	private Double costoPreferido;
	@Column(name = "tipo_moneda")
	private String tipoMoneda;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "profesional")
	private List<Transaccion> transaccionList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "profesional")
	private List<Titulo> tituloList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "profesional")
	private List<Consulta> consultaList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "profesional")
	private List<CalificacionProfesional> calificacionProfesionalList;

	public Profesional() {
	}

	public Profesional(ProfesionalPK profesionalPK) {
		this.profesionalPK = profesionalPK;
	}

	public Profesional(ProfesionalPK profesionalPK, String estado, String nombres, String apellidos, String email,
			String telefono, Date fechaNacimiento, String pais, String password, String urlFoto, String nombreBanco,
			String numeroCuenta, String tipoCuenta) {
		this.profesionalPK = profesionalPK;
		this.estado = estado;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.pais = pais;
		this.password = password;
		this.urlFoto = urlFoto;
		this.nombreBanco = nombreBanco;
		this.numeroCuenta = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
	}

	public Profesional(String identificacion, String tipoIdentificacion) {
		this.profesionalPK = new ProfesionalPK(identificacion, tipoIdentificacion);
	}

	public ProfesionalPK getProfesionalPK() {
		return profesionalPK;
	}

	public void setProfesionalPK(ProfesionalPK profesionalPK) {
		this.profesionalPK = profesionalPK;
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public String getNombreBanco() {
		return nombreBanco;
	}

	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Double getCostoPreferido() {
		return costoPreferido;
	}

	public void setCostoPreferido(Double costoPreferido) {
		this.costoPreferido = costoPreferido;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	@XmlTransient
	public List<Transaccion> getTransaccionList() {
		return transaccionList;
	}

	public void setTransaccionList(List<Transaccion> transaccionList) {
		this.transaccionList = transaccionList;
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

	@XmlTransient
	public List<CalificacionProfesional> getCalificacionProfesionalList() {
		return calificacionProfesionalList;
	}

	public void setCalificacionProfesionalList(List<CalificacionProfesional> calificacionProfesionalList) {
		this.calificacionProfesionalList = calificacionProfesionalList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (profesionalPK != null ? profesionalPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Profesional)) {
			return false;
		}
		Profesional other = (Profesional) object;
		if ((this.profesionalPK == null && other.profesionalPK != null)
				|| (this.profesionalPK != null && !this.profesionalPK.equals(other.profesionalPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication12.Profesional[ profesionalPK=" + profesionalPK + " ]";
	}

}
