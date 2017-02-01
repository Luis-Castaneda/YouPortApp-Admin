/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youport.acordeyouport.app.entity;

import com.youport.acordeyouport.app.entity.Company;
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
@Table(name = "promotion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p"),
    @NamedQuery(name = "Promotion.findByIdPromotion", query = "SELECT p FROM Promotion p WHERE p.idPromotion = :idPromotion"),
    @NamedQuery(name = "Promotion.findByNamePromotion", query = "SELECT p FROM Promotion p WHERE p.namePromotion = :namePromotion"),
    @NamedQuery(name = "Promotion.findByDescription", query = "SELECT p FROM Promotion p WHERE p.description = :description"),
    @NamedQuery(name = "Promotion.findByUrlImagel", query = "SELECT p FROM Promotion p WHERE p.urlImagel = :urlImagel")})
public class Promotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Promotion")
    private Integer idPromotion;
    @Size(max = 100)
    @Column(name = "Name_Promotion")
    private String namePromotion;
    @Size(max = 400)
    @Column(name = "Description")
    private String description;
    @Size(max = 100)
    @Column(name = "Url_Imagel")
    private String urlImagel;
    @JoinColumn(name = "Id_Type_Promotion", referencedColumnName = "Id_Type_Promotion")
    @ManyToOne(optional = false)
    private TypePromotion idTypePromotion;
    @JoinColumn(name = "Id_Company", referencedColumnName = "Id_Company")
    @ManyToOne(optional = false)
    private Company idCompany;

    public Promotion() {
    }

    public Promotion(Integer idPromotion) {
        this.idPromotion = idPromotion;
    }

    public Integer getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(Integer idPromotion) {
        this.idPromotion = idPromotion;
    }

    public String getNamePromotion() {
        return namePromotion;
    }

    public void setNamePromotion(String namePromotion) {
        this.namePromotion = namePromotion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImagel() {
        return urlImagel;
    }

    public void setUrlImagel(String urlImagel) {
        this.urlImagel = urlImagel;
    }

    public TypePromotion getIdTypePromotion() {
        return idTypePromotion;
    }

    public void setIdTypePromotion(TypePromotion idTypePromotion) {
        this.idTypePromotion = idTypePromotion;
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
        hash += (idPromotion != null ? idPromotion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.idPromotion == null && other.idPromotion != null) || (this.idPromotion != null && !this.idPromotion.equals(other.idPromotion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.bean.controller.Promotion[ idPromotion=" + idPromotion + " ]";
    }

}
