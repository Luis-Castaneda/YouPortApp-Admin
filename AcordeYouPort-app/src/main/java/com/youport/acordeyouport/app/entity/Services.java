/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youport.acordeyouport.app.entity;

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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis Castañeda <luis.castaneda at acorde.com.ve>
 */
@Entity
@Table(name = "services")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Services.findAll", query = "SELECT s FROM Services s"),
    @NamedQuery(name = "Services.findByIdServices", query = "SELECT s FROM Services s WHERE s.idServices = :idServices"),
    @NamedQuery(name = "Services.findByNameServices", query = "SELECT s FROM Services s WHERE s.nameServices = :nameServices"),
    @NamedQuery(name = "Services.findByEnabled", query = "SELECT s FROM Services s WHERE s.enabled = :enabled")})
public class Services implements Serializable {
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Services")
    private Integer idServices;
    @Size(max = 100)
    @Column(name = "Name_Services")
    private String nameServices;
    @Size(max = 30)
    @Column(name = "Description_Short")
    private String descriptionShort;
    @Size(max = 300)
    @Column(name = "Description_Long")
    private String descriptionLong;
    @Size(max = 100)
    @Column(name = "Url_Image")
    private String urlImage;
    @Column(name = "Enabled")
    private Boolean enabled;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServices")
    private List<ServicesCompany> servicesCompanyList;

    public Services() {
    }

    public Services(Integer idServices) {
        this.idServices = idServices;
    }

    public Integer getIdServices() {
        return idServices;
    }

    public void setIdServices(Integer idServices) {
        this.idServices = idServices;
    }

    public String getNameServices() {
        return nameServices;
    }

    public void setNameServices(String nameServices) {
        this.nameServices = nameServices;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @XmlTransient
    public List<ServicesCompany> getServicesCompanyList() {
        return servicesCompanyList;
    }

    public void setServicesCompanyList(List<ServicesCompany> servicesCompanyList) {
        this.servicesCompanyList = servicesCompanyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServices != null ? idServices.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Services)) {
            return false;
        }
        Services other = (Services) object;
        if ((this.idServices == null && other.idServices != null) || (this.idServices != null && !this.idServices.equals(other.idServices))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.entity.Services[ idServices=" + idServices + " ]";
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    public String getDescriptionLong() {
        return descriptionLong;
    }

    public void setDescriptionLong(String descriptionLong) {
        this.descriptionLong = descriptionLong;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

}
