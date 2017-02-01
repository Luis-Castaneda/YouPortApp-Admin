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
@Table(name = "theme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Theme.findAll", query = "SELECT t FROM Theme t"),
    @NamedQuery(name = "Theme.findByIdTheme", query = "SELECT t FROM Theme t WHERE t.idTheme = :idTheme"),
    @NamedQuery(name = "Theme.findByNameTheme", query = "SELECT t FROM Theme t WHERE t.nameTheme = :nameTheme"),
    @NamedQuery(name = "Theme.findByDescription", query = "SELECT t FROM Theme t WHERE t.description = :description"),
    @NamedQuery(name = "Theme.findByUrlLogoBanner", query = "SELECT t FROM Theme t WHERE t.urlLogoBanner = :urlLogoBanner"),
    @NamedQuery(name = "Theme.findByUrlLogoFooter", query = "SELECT t FROM Theme t WHERE t.urlLogoFooter = :urlLogoFooter"),
    @NamedQuery(name = "Theme.findByColorPreference", query = "SELECT t FROM Theme t WHERE t.colorPreference = :colorPreference"),
    @NamedQuery(name = "Theme.findByEnabled", query = "SELECT t FROM Theme t WHERE t.enabled = :enabled"),
    @NamedQuery(name = "Theme.findByUrlBackground", query = "SELECT t FROM Theme t WHERE t.urlBackground = :urlBackground")})
public class Theme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdTheme")
    private Integer idTheme;
    @Size(max = 45)
    @Column(name = "NameTheme")
    private String nameTheme;
    @Size(max = 100)
    @Column(name = "Description")
    private String description;
    @Size(max = 200)
    @Column(name = "Url_Logo_Banner")
    private String urlLogoBanner;
    @Size(max = 200)
    @Column(name = "Url_Logo_Footer")
    private String urlLogoFooter;
    @Size(max = 45)
    @Column(name = "Color_Preference")
    private String colorPreference;
    @Column(name = "Enabled")
    private Boolean enabled;
    @Size(max = 200)
    @Column(name = "Url_Background")
    private String urlBackground;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTheme")
    private List<Company> companyList;

    public Theme() {
    }

    public Theme(Integer idTheme) {
        this.idTheme = idTheme;
    }

    public Integer getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(Integer idTheme) {
        this.idTheme = idTheme;
    }

    public String getNameTheme() {
        return nameTheme;
    }

    public void setNameTheme(String nameTheme) {
        this.nameTheme = nameTheme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlLogoBanner() {
        return urlLogoBanner;
    }

    public void setUrlLogoBanner(String urlLogoBanner) {
        this.urlLogoBanner = urlLogoBanner;
    }

    public String getUrlLogoFooter() {
        return urlLogoFooter;
    }

    public void setUrlLogoFooter(String urlLogoFooter) {
        this.urlLogoFooter = urlLogoFooter;
    }

    public String getColorPreference() {
        return colorPreference;
    }

    public void setColorPreference(String colorPreference) {
        this.colorPreference = colorPreference;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getUrlBackground() {
        return urlBackground;
    }

    public void setUrlBackground(String urlBackground) {
        this.urlBackground = urlBackground;
    }

    @XmlTransient
    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTheme != null ? idTheme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theme)) {
            return false;
        }
        Theme other = (Theme) object;
        if ((this.idTheme == null && other.idTheme != null) || (this.idTheme != null && !this.idTheme.equals(other.idTheme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.entity.Theme[ idTheme=" + idTheme + " ]";
    }

}
