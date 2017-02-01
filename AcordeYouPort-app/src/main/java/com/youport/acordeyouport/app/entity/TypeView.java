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
@Table(name = "type_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeView.findAll", query = "SELECT t FROM TypeView t"),
    @NamedQuery(name = "TypeView.findByIdTypeView", query = "SELECT t FROM TypeView t WHERE t.idTypeView = :idTypeView"),
    @NamedQuery(name = "TypeView.findByNameType", query = "SELECT t FROM TypeView t WHERE t.nameType = :nameType"),
    @NamedQuery(name = "TypeView.findByDescription", query = "SELECT t FROM TypeView t WHERE t.description = :description")})
public class TypeView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Type_View")
    private Integer idTypeView;
    @Size(max = 45)
    @Column(name = "Name_Type")
    private String nameType;
    @Size(max = 300)
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeView")
    private List<View> viewList;

    public TypeView() {
    }

    public TypeView(Integer idTypeView) {
        this.idTypeView = idTypeView;
    }

    public Integer getIdTypeView() {
        return idTypeView;
    }

    public void setIdTypeView(Integer idTypeView) {
        this.idTypeView = idTypeView;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<View> getViewList() {
        return viewList;
    }

    public void setViewList(List<View> viewList) {
        this.viewList = viewList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeView != null ? idTypeView.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeView)) {
            return false;
        }
        TypeView other = (TypeView) object;
        if ((this.idTypeView == null && other.idTypeView != null) || (this.idTypeView != null && !this.idTypeView.equals(other.idTypeView))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.entity.TypeView[ idTypeView=" + idTypeView + " ]";
    }

}
