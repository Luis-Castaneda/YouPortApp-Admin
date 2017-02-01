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
@Table(name = "menu_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuType.findAll", query = "SELECT m FROM MenuType m"),
    @NamedQuery(name = "MenuType.findByIdMenutype", query = "SELECT m FROM MenuType m WHERE m.idMenutype = :idMenutype"),
    @NamedQuery(name = "MenuType.findByNameType", query = "SELECT m FROM MenuType m WHERE m.nameType = :nameType"),
    @NamedQuery(name = "MenuType.findByDescription", query = "SELECT m FROM MenuType m WHERE m.description = :description")})
public class MenuType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Menu_type")
    private Integer idMenutype;
    @Size(max = 45)
    @Column(name = "Name_Type")
    private String nameType;
    @Size(max = 200)
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuType")
    private List<MenuOption> menuOptionList;

    public MenuType() {
    }

    public MenuType(Integer idMenutype) {
        this.idMenutype = idMenutype;
    }

    public Integer getIdMenutype() {
        return idMenutype;
    }

    public void setIdMenutype(Integer idMenutype) {
        this.idMenutype = idMenutype;
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
    public List<MenuOption> getMenuOptionList() {
        return menuOptionList;
    }

    public void setMenuOptionList(List<MenuOption> menuOptionList) {
        this.menuOptionList = menuOptionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenutype != null ? idMenutype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuType)) {
            return false;
        }
        MenuType other = (MenuType) object;
        if ((this.idMenutype == null && other.idMenutype != null) || (this.idMenutype != null && !this.idMenutype.equals(other.idMenutype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.entity.MenuType[ idMenutype=" + idMenutype + " ]";
    }

}
