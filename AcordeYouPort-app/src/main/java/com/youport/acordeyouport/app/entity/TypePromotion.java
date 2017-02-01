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
@Table(name = "type_promotion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypePromotion.findAll", query = "SELECT t FROM TypePromotion t"),
    @NamedQuery(name = "TypePromotion.findByIdTypePromotion", query = "SELECT t FROM TypePromotion t WHERE t.idTypePromotion = :idTypePromotion"),
    @NamedQuery(name = "TypePromotion.findByName", query = "SELECT t FROM TypePromotion t WHERE t.name = :name"),
    @NamedQuery(name = "TypePromotion.findByDescription", query = "SELECT t FROM TypePromotion t WHERE t.description = :description")})
public class TypePromotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Type_Promotion")
    private Integer idTypePromotion;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @Size(max = 400)
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypePromotion")
    private List<Promotion> promotionList;

    public TypePromotion() {
    }

    public TypePromotion(Integer idTypePromotion) {
        this.idTypePromotion = idTypePromotion;
    }

    public Integer getIdTypePromotion() {
        return idTypePromotion;
    }

    public void setIdTypePromotion(Integer idTypePromotion) {
        this.idTypePromotion = idTypePromotion;
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

    @XmlTransient
    public List<Promotion> getPromotionList() {
        return promotionList;
    }

    public void setPromotionList(List<Promotion> promotionList) {
        this.promotionList = promotionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypePromotion != null ? idTypePromotion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypePromotion)) {
            return false;
        }
        TypePromotion other = (TypePromotion) object;
        if ((this.idTypePromotion == null && other.idTypePromotion != null) || (this.idTypePromotion != null && !this.idTypePromotion.equals(other.idTypePromotion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.bean.controller.TypePromotion[ idTypePromotion=" + idTypePromotion + " ]";
    }

}
