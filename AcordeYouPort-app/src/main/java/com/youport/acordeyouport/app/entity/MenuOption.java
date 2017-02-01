/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youport.acordeyouport.app.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "menu_option")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuOption.findAll", query = "SELECT m FROM MenuOption m"),
    @NamedQuery(name = "MenuOption.findByIdMenu", query = "SELECT m FROM MenuOption m WHERE m.menuOptionPK.idMenu = :idMenu"),
    @NamedQuery(name = "MenuOption.findByName", query = "SELECT m FROM MenuOption m WHERE m.name = :name"),
    @NamedQuery(name = "MenuOption.findByDescriptionLong", query = "SELECT m FROM MenuOption m WHERE m.descriptionLong = :descriptionLong"),
    @NamedQuery(name = "MenuOption.findByDescriptionShort", query = "SELECT m FROM MenuOption m WHERE m.descriptionShort = :descriptionShort"),
    @NamedQuery(name = "MenuOption.findByUrlImageNormal", query = "SELECT m FROM MenuOption m WHERE m.urlImageNormal = :urlImageNormal"),
    @NamedQuery(name = "MenuOption.findByEnabled", query = "SELECT m FROM MenuOption m WHERE m.enabled = :enabled"),
    @NamedQuery(name = "MenuOption.findByIdView", query = "SELECT m FROM MenuOption m WHERE m.menuOptionPK.idView = :idView"),
    @NamedQuery(name = "MenuOption.findByIdMenutype", query = "SELECT m FROM MenuOption m WHERE m.menuOptionPK.idMenutype = :idMenutype"),
    @NamedQuery(name = "MenuOption.findByUrlImageOver", query = "SELECT m FROM MenuOption m WHERE m.urlImageOver = :urlImageOver")})
public class MenuOption implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MenuOptionPK menuOptionPK;
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
    @JoinColumn(name = "Id_View", referencedColumnName = "Id_View", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private View view;
    @JoinColumn(name = "Id_Menu_type", referencedColumnName = "Id_Menu_type", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MenuType menuType;

    public MenuOption() {
    }

    public MenuOption(MenuOptionPK menuOptionPK) {
        this.menuOptionPK = menuOptionPK;
    }

    public MenuOption(int idMenu, int idView, int idMenutype) {
        this.menuOptionPK = new MenuOptionPK(idMenu, idView, idMenutype);
    }

    public MenuOptionPK getMenuOptionPK() {
        return menuOptionPK;
    }

    public void setMenuOptionPK(MenuOptionPK menuOptionPK) {
        this.menuOptionPK = menuOptionPK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuOptionPK != null ? menuOptionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuOption)) {
            return false;
        }
        MenuOption other = (MenuOption) object;
        if ((this.menuOptionPK == null && other.menuOptionPK != null) || (this.menuOptionPK != null && !this.menuOptionPK.equals(other.menuOptionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.entity.MenuOption[ menuOptionPK=" + menuOptionPK + " ]";
    }

}
