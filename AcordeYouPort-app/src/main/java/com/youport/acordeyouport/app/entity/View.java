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
@Table(name = "view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "View.findAll", query = "SELECT v FROM View v"),
    @NamedQuery(name = "View.findByIdView", query = "SELECT v FROM View v WHERE v.idView = :idView"),
    @NamedQuery(name = "View.findByName", query = "SELECT v FROM View v WHERE v.name = :name"),
    @NamedQuery(name = "View.findByUrl", query = "SELECT v FROM View v WHERE v.url = :url"),
    @NamedQuery(name = "View.findByIdTypeView", query = "SELECT v FROM View v WHERE v.typeView = :typeView")})
public class View implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_View")
    private Integer idView;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @Size(max = 45)
    @Column(name = "Url")
    private String url;
    @JoinColumn(name = "Id_Type_View", referencedColumnName = "Id_Type_View")
    @ManyToOne(optional = false)
    private TypeView typeView;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "view")
    private List<MenuOption> menuOptionList;

    public View() {
    }

    public View(Integer idView) {
        this.idView = idView;
    }

    public Integer getIdView() {
        return idView;
    }

    public void setIdView(Integer idView) {
        this.idView = idView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TypeView getTypeView() {
        return typeView;
    }

    public void setTypeView(TypeView typeView) {
        this.typeView = typeView;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idView != null ? idView.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof View)) {
            return false;
        }
        View other = (View) object;
        if ((this.idView == null && other.idView != null) || (this.idView != null && !this.idView.equals(other.idView))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.entity.View[ viewPK=" + idView + " ]";
    }

    @XmlTransient
    public List<MenuOption> getMenuOptionList() {
        return menuOptionList;
    }

    public void setMenuOptionList(List<MenuOption> menuOptionList) {
        this.menuOptionList = menuOptionList;
    }

}
