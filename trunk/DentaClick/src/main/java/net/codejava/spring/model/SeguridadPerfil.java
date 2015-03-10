/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.spring.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 *
 * @author DIEGO
 */
@Entity
@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL) 
public class SeguridadPerfil implements Serializable {
	private static final long		serialVersionUID	= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long					pkPerfil;
	private Integer					esta;
	private String					nomb;
	
	@XmlAttribute
    @XmlTransient
	@OneToMany(mappedBy = "fkPerfil")
	private List<SeguridadUsuario>	seguridadUsuarioList;
	
	@XmlAttribute
    @XmlTransient
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "seguridadPerfil")
	private SeguridadPersona		seguridadPersona;

	public Long getPkPerfil() {
		return pkPerfil;
	}

	public void setPkPerfil(Long pkPerfil) {
		this.pkPerfil = pkPerfil;
	}

	public Integer getEsta() {
		return esta;
	}

	public void setEsta(Integer esta) {
		this.esta = esta;
	}

	public String getNomb() {
		return nomb;
	}

	public void setNomb(String nomb) {
		this.nomb = nomb;
	}

	public List<SeguridadUsuario> getSeguridadUsuarioList() {
		return seguridadUsuarioList;
	}

	public void setSeguridadUsuarioList(List<SeguridadUsuario> seguridadUsuarioList) {
		this.seguridadUsuarioList = seguridadUsuarioList;
	}

	public SeguridadPersona getSeguridadPersona() {
		return seguridadPersona;
	}

	public void setSeguridadPersona(SeguridadPersona seguridadPersona) {
		this.seguridadPersona = seguridadPersona;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
