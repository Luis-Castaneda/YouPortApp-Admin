/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youport.acordeyouport.app.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Luis Castañeda <luis.castaneda at acorde.com.ve>
 */
@Embeddable
public class MenuOptionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Id_Menu")
    private int idMenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_View")
    private int idView;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_Menu_type")
    private int idMenutype;

    public MenuOptionPK() {
    }

    public MenuOptionPK(int idMenu, int idView, int idMenutype) {
        this.idMenu = idMenu;
        this.idView = idView;
        this.idMenutype = idMenutype;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getIdView() {
        return idView;
    }

    public void setIdView(int idView) {
        this.idView = idView;
    }

    public int getIdMenutype() {
        return idMenutype;
    }

    public void setIdMenutype(int idMenutype) {
        this.idMenutype = idMenutype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMenu;
        hash += (int) idView;
        hash += (int) idMenutype;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuOptionPK)) {
            return false;
        }
        MenuOptionPK other = (MenuOptionPK) object;
        if (this.idMenu != other.idMenu) {
            return false;
        }
        if (this.idView != other.idView) {
            return false;
        }
        if (this.idMenutype != other.idMenutype) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.entity.MenuOptionPK[ idMenu=" + idMenu + ", idView=" + idView + ", idMenutype=" + idMenutype + " ]";
    }

}
