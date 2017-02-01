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
@Table(name = "sub_menu_options")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubMenuOptions.findAll", query = "SELECT s FROM SubMenuOptions s"),
    @NamedQuery(name = "SubMenuOptions.findByIdSubMenuOption", query = "SELECT s FROM SubMenuOptions s WHERE s.idSubMenuOption = :idSubMenuOption"),
    @NamedQuery(name = "SubMenuOptions.findByName", query = "SELECT s FROM SubMenuOptions s WHERE s.name = :name"),
    @NamedQuery(name = "SubMenuOptions.findByDescription", query = "SELECT s FROM SubMenuOptions s WHERE s.description = :description")})
public class SubMenuOptions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Sub_Menu_Option")
    private Integer idSubMenuOption;
    @Size(max = 100)
    @Column(name = "Name")
    private String name;
    @Size(max = 500)
    @Column(name = "Description")
    private String description;

    public SubMenuOptions() {
    }

    public SubMenuOptions(Integer idSubMenuOption) {
        this.idSubMenuOption = idSubMenuOption;
    }

    public Integer getIdSubMenuOption() {
        return idSubMenuOption;
    }

    public void setIdSubMenuOption(Integer idSubMenuOption) {
        this.idSubMenuOption = idSubMenuOption;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubMenuOption != null ? idSubMenuOption.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubMenuOptions)) {
            return false;
        }
        SubMenuOptions other = (SubMenuOptions) object;
        if ((this.idSubMenuOption == null && other.idSubMenuOption != null) || (this.idSubMenuOption != null && !this.idSubMenuOption.equals(other.idSubMenuOption))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.bean.controller.SubMenuOptions[ idSubMenuOption=" + idSubMenuOption + " ]";
    }

}
