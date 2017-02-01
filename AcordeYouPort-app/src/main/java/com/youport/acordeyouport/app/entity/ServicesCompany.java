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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis Castañeda <luis.castaneda at acorde.com.ve>
 */
@Entity
@Table(name = "services_company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicesCompany.findAll", query = "SELECT s FROM ServicesCompany s"),
    @NamedQuery(name = "ServicesCompany.findByIdServicesCompany", query = "SELECT s FROM ServicesCompany s WHERE s.idServicesCompany = :idServicesCompany")})
public class ServicesCompany implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdServices_Company")
    private Integer idServicesCompany;
    @JoinColumn(name = "Id_Company", referencedColumnName = "Id_Company")
    @ManyToOne(optional = false)
    private Company idCompany;
    @JoinColumn(name = "Id_Services", referencedColumnName = "Id_Services")
    @ManyToOne(optional = false)
    private Services idServices;

    public ServicesCompany() {
    }

    public ServicesCompany(Integer idServicesCompany) {
        this.idServicesCompany = idServicesCompany;
    }

    public Integer getIdServicesCompany() {
        return idServicesCompany;
    }

    public void setIdServicesCompany(Integer idServicesCompany) {
        this.idServicesCompany = idServicesCompany;
    }

    public Company getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Company idCompany) {
        this.idCompany = idCompany;
    }

    public Services getIdServices() {
        return idServices;
    }

    public void setIdServices(Services idServices) {
        this.idServices = idServices;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicesCompany != null ? idServicesCompany.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicesCompany)) {
            return false;
        }
        ServicesCompany other = (ServicesCompany) object;
        if ((this.idServicesCompany == null && other.idServicesCompany != null) || (this.idServicesCompany != null && !this.idServicesCompany.equals(other.idServicesCompany))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.entity.ServicesCompany[ idServicesCompany=" + idServicesCompany + " ]";
    }

}
