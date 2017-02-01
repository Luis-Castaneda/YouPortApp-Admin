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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis Castañeda <luis.castaneda at acorde.com.ve>
 */
@Entity
@Table(name = "contact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
    @NamedQuery(name = "Contact.findByIdContact", query = "SELECT c FROM Contact c WHERE c.idContact = :idContact"),
    @NamedQuery(name = "Contact.findByNameContact", query = "SELECT c FROM Contact c WHERE c.nameContact = :nameContact"),
    @NamedQuery(name = "Contact.findByPhoneContact", query = "SELECT c FROM Contact c WHERE c.phoneContact = :phoneContact"),
    @NamedQuery(name = "Contact.findByAddressContact", query = "SELECT c FROM Contact c WHERE c.addressContact = :addressContact"),
    @NamedQuery(name = "Contact.findByEmailContact", query = "SELECT c FROM Contact c WHERE c.emailContact = :emailContact"),
    @NamedQuery(name = "Contact.findByFax", query = "SELECT c FROM Contact c WHERE c.fax = :fax"),
    @NamedQuery(name = "Contact.findByWebSite", query = "SELECT c FROM Contact c WHERE c.webSite = :webSite")})
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Contact")
    private Integer idContact;
    @Size(max = 45)
    @Column(name = "Name_Contact")
    private String nameContact;
    @Size(max = 45)
    @Column(name = "Phone_Contact")
    private String phoneContact;
    @Size(max = 300)
    @Column(name = "Address_Contact")
    private String addressContact;
    @Size(max = 60)
    @Column(name = "Email_Contact")
    private String emailContact;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "Fax")
    private String fax;
    @Size(max = 100)
    @Column(name = "Web_Site")
    private String webSite;
    @JoinColumn(name = "Id_Company", referencedColumnName = "Id_Company")
    @ManyToOne(optional = false)
    private Company idCompany;

    public Contact() {
    }

    public Contact(Integer idContact) {
        this.idContact = idContact;
    }

    public Integer getIdContact() {
        return idContact;
    }

    public void setIdContact(Integer idContact) {
        this.idContact = idContact;
    }

    public String getNameContact() {
        return nameContact;
    }

    public void setNameContact(String nameContact) {
        this.nameContact = nameContact;
    }

    public String getPhoneContact() {
        return phoneContact;
    }

    public void setPhoneContact(String phoneContact) {
        this.phoneContact = phoneContact;
    }

    public String getAddressContact() {
        return addressContact;
    }

    public void setAddressContact(String addressContact) {
        this.addressContact = addressContact;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Company getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Company idCompany) {
        this.idCompany = idCompany;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContact != null ? idContact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.idContact == null && other.idContact != null) || (this.idContact != null && !this.idContact.equals(other.idContact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.entity.Contact[ idContact=" + idContact + " ]";
    }

}
