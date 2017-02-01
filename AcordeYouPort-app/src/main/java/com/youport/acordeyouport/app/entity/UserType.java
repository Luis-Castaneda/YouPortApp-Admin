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
@Table(name = "user_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserType.findAll", query = "SELECT u FROM UserType u"),
    @NamedQuery(name = "UserType.findByIdUserType", query = "SELECT u FROM UserType u WHERE u.idUserType = :idUserType"),
    @NamedQuery(name = "UserType.findByType", query = "SELECT u FROM UserType u WHERE u.type = :type"),
    @NamedQuery(name = "UserType.findByDescription", query = "SELECT u FROM UserType u WHERE u.description = :description")})
public class UserType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_User_Type")
    private Integer idUserType;
    @Size(max = 45)
    @Column(name = "Type")
    private String type;
    @Size(max = 100)
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUserType")
    private List<User> userList;

    public UserType() {
    }

    public UserType(Integer idUserType) {
        this.idUserType = idUserType;
    }

    public Integer getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(Integer idUserType) {
        this.idUserType = idUserType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserType != null ? idUserType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserType)) {
            return false;
        }
        UserType other = (UserType) object;
        if ((this.idUserType == null && other.idUserType != null) || (this.idUserType != null && !this.idUserType.equals(other.idUserType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.entity.UserType[ idUserType=" + idUserType + " ]";
    }

}
