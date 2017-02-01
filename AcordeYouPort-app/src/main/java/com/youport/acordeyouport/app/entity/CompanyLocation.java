/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youport.acordeyouport.app.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ivan Silva <isilva at Acorde>
 */
@Entity
@Table(name = "company_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompanyLocation.findAll", query = "SELECT c FROM CompanyLocation c")
    , @NamedQuery(name = "CompanyLocation.findByIdCompanyLocation", query = "SELECT c FROM CompanyLocation c WHERE c.idCompanyLocation = :idCompanyLocation")
    , @NamedQuery(name = "CompanyLocation.findByLatitud", query = "SELECT c FROM CompanyLocation c WHERE c.latitud = :latitud")
    , @NamedQuery(name = "CompanyLocation.findByLongitud", query = "SELECT c FROM CompanyLocation c WHERE c.longitud = :longitud")
    , @NamedQuery(name = "CompanyLocation.findByPrincipal", query = "SELECT c FROM CompanyLocation c WHERE c.principal = :principal")})
public class CompanyLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_company_location")
    private Integer idCompanyLocation;
    @Size(max = 15)
    @Column(name = "latitud")
    private String latitud;
    @Size(max = 15)
    @Column(name = "longitud")
    private String longitud;
    @Column(name = "principal")
    private Integer principal;
    @JoinColumn(name = "id_company", referencedColumnName = "Id_Company")
    @ManyToOne(optional = false)
    private Company idCompany;
    @JoinColumn(name = "id_provincia", referencedColumnName = "id_provincia")
    @ManyToOne(optional = false)
    private Provincias idProvincia;

    public CompanyLocation() {
    }

    public CompanyLocation(Integer idCompanyLocation) {
        this.idCompanyLocation = idCompanyLocation;
    }

    public Integer getIdCompanyLocation() {
        return idCompanyLocation;
    }

    public void setIdCompanyLocation(Integer idCompanyLocation) {
        this.idCompanyLocation = idCompanyLocation;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public Integer getPrincipal() {
        return principal;
    }

    public void setPrincipal(Integer principal) {
        this.principal = principal;
    }

    public Company getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Company idCompany) {
        this.idCompany = idCompany;
    }

    public Provincias getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Provincias idProvincia) {
        this.idProvincia = idProvincia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompanyLocation != null ? idCompanyLocation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyLocation)) {
            return false;
        }
        CompanyLocation other = (CompanyLocation) object;
        if ((this.idCompanyLocation == null && other.idCompanyLocation != null) || (this.idCompanyLocation != null && !this.idCompanyLocation.equals(other.idCompanyLocation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.entity.CompanyLocation[ idCompanyLocation=" + idCompanyLocation + " ]";
    }
    
}
