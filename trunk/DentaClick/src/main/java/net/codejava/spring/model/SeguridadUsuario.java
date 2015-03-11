/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.spring.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 *
 * @author DIEGO
 */
@Entity
@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class SeguridadUsuario implements Serializable {
	private static final long	serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	private Long				pkUsuario;
	
	private Integer				esta;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date				fechModi;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date				fechRegi;
	
	private String				nomb;
	private String				pass;

	@XmlElement
	@JoinColumn(name = "fkPerfil", referencedColumnName = "pkPerfil")
	@ManyToOne
	private SeguridadPerfil		fkPerfil;

	public Long getPkUsuario() {
		return pkUsuario;
	}

	public void setPkUsuario(Long pkUsuario) {
		this.pkUsuario = pkUsuario;
	}

	
	public Date getFechModi() {
		return fechModi;
	}

	public void setFechModi(Date fechModi) {
		this.fechModi = fechModi;
	}

	public Date getFechRegi() {
		return fechRegi;
	}

	public void setFechRegi(Date fechRegi) {
		this.fechRegi = fechRegi;
	}

	public String getNomb() {
		return nomb;
	}

	public void setNomb(String nomb) {
		this.nomb = nomb;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public SeguridadPerfil getFkPerfil() {
		return fkPerfil;
	}

	public void setFkPerfil(SeguridadPerfil fkPerfil) {
		this.fkPerfil = fkPerfil;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getEsta() {
		return esta;
	}

	public void setEsta(Integer esta) {
		this.esta = esta;
	}

}
