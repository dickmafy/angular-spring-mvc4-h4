/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.spring.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DIEGO
 */
@Entity
public class SeguridadPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long pkPersona;
    private String apellMate;
    private String apellpate;
    private String codigoid;
    private Integer estaCivi;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechModi;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechNaci;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechRegi;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal fkCompany;
    private Boolean gene;
    private String nomb;
    private String ubigNaci;
    
    @XmlAttribute
    @XmlTransient
    @JoinColumn(name = "pkPersona", referencedColumnName = "pkPerfil", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SeguridadPerfil seguridadPerfil;
    
	public Long getPkPersona() {
		return pkPersona;
	}
	public void setPkPersona(Long pkPersona) {
		this.pkPersona = pkPersona;
	}
	public String getApellMate() {
		return apellMate;
	}
	public void setApellMate(String apellMate) {
		this.apellMate = apellMate;
	}
	public String getApellpate() {
		return apellpate;
	}
	public void setApellpate(String apellpate) {
		this.apellpate = apellpate;
	}
	public String getCodigoid() {
		return codigoid;
	}
	public void setCodigoid(String codigoid) {
		this.codigoid = codigoid;
	}
	public Integer getEstaCivi() {
		return estaCivi;
	}
	public void setEstaCivi(Integer estaCivi) {
		this.estaCivi = estaCivi;
	}
	public Date getFechModi() {
		return fechModi;
	}
	public void setFechModi(Date fechModi) {
		this.fechModi = fechModi;
	}
	public Date getFechNaci() {
		return fechNaci;
	}
	public void setFechNaci(Date fechNaci) {
		this.fechNaci = fechNaci;
	}
	public Date getFechRegi() {
		return fechRegi;
	}
	public void setFechRegi(Date fechRegi) {
		this.fechRegi = fechRegi;
	}
	public BigDecimal getFkCompany() {
		return fkCompany;
	}
	public void setFkCompany(BigDecimal fkCompany) {
		this.fkCompany = fkCompany;
	}
	public Boolean getGene() {
		return gene;
	}
	public void setGene(Boolean gene) {
		this.gene = gene;
	}
	public String getNomb() {
		return nomb;
	}
	public void setNomb(String nomb) {
		this.nomb = nomb;
	}
	public String getUbigNaci() {
		return ubigNaci;
	}
	public void setUbigNaci(String ubigNaci) {
		this.ubigNaci = ubigNaci;
	}
	public SeguridadPerfil getSeguridadPerfil() {
		return seguridadPerfil;
	}
	public void setSeguridadPerfil(SeguridadPerfil seguridadPerfil) {
		this.seguridadPerfil = seguridadPerfil;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
