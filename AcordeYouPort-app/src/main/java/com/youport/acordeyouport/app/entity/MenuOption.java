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
import javax.persistence.EmbeddedId;
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
@Table(name = "menu_option")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuOption.findAll", query = "SELECT m FROM MenuOption m"),
    @NamedQuery(name = "MenuOption.findByIdMenu", query = "SELECT m FROM MenuOption m WHERE m.idMenu = :idMenu"),
    @NamedQuery(name = "MenuOption.findByName", query = "SELECT m FROM MenuOption m WHERE m.name = :name"),
    @NamedQuery(name = "MenuOption.findByDescriptionLong", query = "SELECT m FROM MenuOption m WHERE m.descriptionLong = :descriptionLong"),
    @NamedQuery(name = "MenuOption.findByDescriptionShort", query = "SELECT m FROM MenuOption m WHERE m.descriptionShort = :descriptionShort"),
    @NamedQuery(name = "MenuOption.findByUrlImageNormal", query = "SELECT m FROM MenuOption m WHERE m.urlImageNormal = :urlImageNormal"),
    @NamedQuery(name = "MenuOption.findByEnabled", query = "SELECT m FROM MenuOption m WHERE m.enabled = :enabled"),
    @NamedQuery(name = "MenuOption.findByIdView", query = "SELECT m FROM MenuOption m WHERE m.view = :view"),
    @NamedQuery(name = "MenuOption.findByIdMenutype", query = "SELECT m FROM MenuOption m WHERE m.menuType = :menuType"),
    @NamedQuery(name = "MenuOption.findByUrlImageOver", query = "SELECT m FROM MenuOption m WHERE m.urlImageOver = :urlImageOver")})
public class MenuOption implements Serializable {

   

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Menu")
    private Integer idMenu;
    @Size(max = 100)
    @Column(name = "Name")
    private String name;
    @Size(max = 200)
    @Column(name = "Description_Long")
    private String descriptionLong;
    @Size(max = 30)
    @Column(name = "Description_Short")
    private String descriptionShort;
    @Size(max = 100)
    @Column(name = "Url_Image_Normal")
    private String urlImageNormal;
    @Column(name = "Enabled")
    private Boolean enabled;
    @Size(max = 100)
    @Column(name = "Url_Image_Over")
    private String urlImageOver;
    @JoinColumn(name = "Id_View", referencedColumnName = "Id_View")
    @ManyToOne(optional = false)
    private View view;
    @JoinColumn(name = "Id_Menu_type", referencedColumnName = "Id_Menu_type")
    @ManyToOne(optional = false)
    private MenuType menuType;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMenu")
    private List<SubMenuOption> subMenuOptionList;

    public MenuOption() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptionLong() {
        return descriptionLong;
    }

    public void setDescriptionLong(String descriptionLong) {
        this.descriptionLong = descriptionLong;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    public String getUrlImageNormal() {
        return urlImageNormal;
    }

    public void setUrlImageNormal(String urlImageNormal) {
        this.urlImageNormal = urlImageNormal;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getUrlImageOver() {
        return urlImageOver;
    }

    public void setUrlImageOver(String urlImageOver) {
        this.urlImageOver = urlImageOver;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public void setMenuType(MenuType menuType) {
        this.menuType = menuType;
    }


    @XmlTransient
    public List<SubMenuOption> getSubMenuOptionList() {
        return subMenuOptionList;
    }

    public void setSubMenuOptionList(List<SubMenuOption> subMenuOptionList) {
        this.subMenuOptionList = subMenuOptionList;
    }

    public MenuOption(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuOption)) {
            return false;
        }
        MenuOption other = (MenuOption) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.entity.MenuOption[ idMenu=" + idMenu + " ]";
    }

}
