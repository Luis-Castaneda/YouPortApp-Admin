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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis Castañeda <luis.castaneda at acorde.com.ve>
 */
@Entity
@Table(name = "configuration_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConfigurationMaster.findAll", query = "SELECT c FROM ConfigurationMaster c"),
    @NamedQuery(name = "ConfigurationMaster.findByIdConfigurationMaster", query = "SELECT c FROM ConfigurationMaster c WHERE c.idConfigurationMaster = :idConfigurationMaster"),
    @NamedQuery(name = "ConfigurationMaster.findByNameParameter", query = "SELECT c FROM ConfigurationMaster c WHERE c.nameParameter = :nameParameter"),
    @NamedQuery(name = "ConfigurationMaster.findByValueParameter", query = "SELECT c FROM ConfigurationMaster c WHERE c.valueParameter = :valueParameter"),
    @NamedQuery(name = "ConfigurationMaster.findByDescription", query = "SELECT c FROM ConfigurationMaster c WHERE c.description = :description")})
public class ConfigurationMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Configuration_Master")
    private Integer idConfigurationMaster;
    @Size(max = 80)
    @Column(name = "Name_Parameter")
    private String nameParameter;
    @Size(max = 80)
    @Column(name = "Value_Parameter")
    private String valueParameter;
    @Size(max = 300)
    @Column(name = "Description")
    private String description;

    public ConfigurationMaster() {
    }

    public ConfigurationMaster(Integer idConfigurationMaster) {
        this.idConfigurationMaster = idConfigurationMaster;
    }

    public Integer getIdConfigurationMaster() {
        return idConfigurationMaster;
    }

    public void setIdConfigurationMaster(Integer idConfigurationMaster) {
        this.idConfigurationMaster = idConfigurationMaster;
    }

    public String getNameParameter() {
        return nameParameter;
    }

    public void setNameParameter(String nameParameter) {
        this.nameParameter = nameParameter;
    }

    public String getValueParameter() {
        return valueParameter;
    }

    public void setValueParameter(String valueParameter) {
        this.valueParameter = valueParameter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConfigurationMaster != null ? idConfigurationMaster.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfigurationMaster)) {
            return false;
        }
        ConfigurationMaster other = (ConfigurationMaster) object;
        if ((this.idConfigurationMaster == null && other.idConfigurationMaster != null) || (this.idConfigurationMaster != null && !this.idConfigurationMaster.equals(other.idConfigurationMaster))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.entity.ConfigurationMaster[ idConfigurationMaster=" + idConfigurationMaster + " ]";
    }

}
