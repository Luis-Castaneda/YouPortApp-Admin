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
@Table(name = "section_menu_company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SectionMenuCompany.findAll", query = "SELECT s FROM SectionMenuCompany s"),
    @NamedQuery(name = "SectionMenuCompany.findByIdSection", query = "SELECT s FROM SectionMenuCompany s WHERE s.idSection = :idSection"),
    @NamedQuery(name = "SectionMenuCompany.findByName", query = "SELECT s FROM SectionMenuCompany s WHERE s.name = :name"),
    @NamedQuery(name = "SectionMenuCompany.findByEnabled", query = "SELECT s FROM SectionMenuCompany s WHERE s.enabled = :enabled")})
public class SectionMenuCompany implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Section")
    private Integer idSection;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @Size(max = 300)
    @Column(name = "Description")
    private String description;
    @Column(name = "Enabled")
    private Boolean enabled;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSection")
    private List<SectionCompany> sectionCompanyList;

    public SectionMenuCompany() {
    }

    public SectionMenuCompany(Integer idSection) {
        this.idSection = idSection;
    }

    public Integer getIdSection() {
        return idSection;
    }

    public void setIdSection(Integer idSection) {
        this.idSection = idSection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @XmlTransient
    public List<SectionCompany> getSectionCompanyList() {
        return sectionCompanyList;
    }

    public void setSectionCompanyList(List<SectionCompany> sectionCompanyList) {
        this.sectionCompanyList = sectionCompanyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSection != null ? idSection.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SectionMenuCompany)) {
            return false;
        }
        SectionMenuCompany other = (SectionMenuCompany) object;
        if ((this.idSection == null && other.idSection != null) || (this.idSection != null && !this.idSection.equals(other.idSection))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.entity.SectionMenuCompany[ idSection=" + idSection + " ]";
    }

}
