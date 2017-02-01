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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findByIdCompany", query = "SELECT c FROM Company c WHERE c.idCompany = :idCompany"),
    @NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.name = :name"),
    @NamedQuery(name = "Company.findByAddress", query = "SELECT c FROM Company c WHERE c.address = :address"),
    @NamedQuery(name = "Company.findByZipCode", query = "SELECT c FROM Company c WHERE c.zipCode = :zipCode"),
    @NamedQuery(name = "Company.findByStateProvince", query = "SELECT c FROM Company c WHERE c.stateProvince = :stateProvince"),
    @NamedQuery(name = "Company.findByCity", query = "SELECT c FROM Company c WHERE c.city = :city"),
    @NamedQuery(name = "Company.findByPhoneOfficeOne", query = "SELECT c FROM Company c WHERE c.phoneOfficeOne = :phoneOfficeOne"),
    @NamedQuery(name = "Company.findByPhoneOfficeTwo", query = "SELECT c FROM Company c WHERE c.phoneOfficeTwo = :phoneOfficeTwo")})
public class Company implements Serializable {
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Company")
    private Integer idCompany;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @Size(max = 300)
    @Column(name = "Address")
    private String address;
    @Size(max = 45)
    @Column(name = "Zip_Code")
    private String zipCode;
    @Size(max = 45)
    @Column(name = "State_Province")
    private String stateProvince;
    @Size(max = 45)
    @Column(name = "City")
    private String city;
    @Size(max = 45)
    @Column(name = "Phone_Office_One")
    private String phoneOfficeOne;
    @Size(max = 45)
    @Column(name = "Phone_Office_Two")
    private String phoneOfficeTwo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompany")
    private List<ServicesCompany> servicesCompanyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompany")
    private List<Contact> contactList;
    @JoinColumn(name = "IdTheme", referencedColumnName = "IdTheme")
    @ManyToOne(optional = false)
    private Theme idTheme;
     @Size(max = 100)
    @Column(name = "Url_Image")
    private String urlImage;
    @Size(max = 100)
    @Column(name = "Web_Site")
    private String webSite;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "Fax")
    private String fax;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompany")
    private List<SectionCompany> sectionCompanyList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompany")
    private List<Promotion> promotionList;

    @JoinColumn(name = "Id_City", referencedColumnName = "id_provincia")
    @ManyToOne(optional = false)
    private Provincias idCity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompany")
    private List<CompanyLocation> companyLocationList;

    public Company() {
    }

    public Company(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneOfficeOne() {
        return phoneOfficeOne;
    }

    public void setPhoneOfficeOne(String phoneOfficeOne) {
        this.phoneOfficeOne = phoneOfficeOne;
    }

    public String getPhoneOfficeTwo() {
        return phoneOfficeTwo;
    }

    public void setPhoneOfficeTwo(String phoneOfficeTwo) {
        this.phoneOfficeTwo = phoneOfficeTwo;
    }

    @XmlTransient
    public List<ServicesCompany> getServicesCompanyList() {
        return servicesCompanyList;
    }

    public void setServicesCompanyList(List<ServicesCompany> servicesCompanyList) {
        this.servicesCompanyList = servicesCompanyList;
    }

    @XmlTransient
    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public Theme getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(Theme idTheme) {
        this.idTheme = idTheme;
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
        hash += (idCompany != null ? idCompany.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.idCompany == null && other.idCompany != null) || (this.idCompany != null && !this.idCompany.equals(other.idCompany))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.entity.Company[ idCompany=" + idCompany + " ]";
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @XmlTransient
    public List<CompanyLocation> getCompanyLocationList() {
        return companyLocationList;
    }

    public void setCompanyLocationList(List<CompanyLocation> companyLocationList) {
        this.companyLocationList = companyLocationList;
    }

    public Provincias getIdCity() {
        return idCity;
    }

    public void setIdCity(Provincias idCity) {
        this.idCity = idCity;
    }

  
    @XmlTransient
    public List<Promotion> getPromotionList() {
        return promotionList;
    }

    public void setPromotionList(List<Promotion> promotionList) {
        this.promotionList = promotionList;
    }

}
