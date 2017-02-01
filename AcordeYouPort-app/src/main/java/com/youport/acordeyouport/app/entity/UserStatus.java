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
@Table(name = "user_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserStatus.findAll", query = "SELECT u FROM UserStatus u"),
    @NamedQuery(name = "UserStatus.findByIdUserStatus", query = "SELECT u FROM UserStatus u WHERE u.idUserStatus = :idUserStatus"),
    @NamedQuery(name = "UserStatus.findByStatusName", query = "SELECT u FROM UserStatus u WHERE u.statusName = :statusName"),
    @NamedQuery(name = "UserStatus.findByEnabled", query = "SELECT u FROM UserStatus u WHERE u.enabled = :enabled")})
public class UserStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_User_Status")
    private Integer idUserStatus;
    @Size(max = 45)
    @Column(name = "StatusName")
    private String statusName;
    @Column(name = "Enabled")
    private Boolean enabled;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUserStatus")
    private List<User> userList;

    public UserStatus() {
    }

    public UserStatus(Integer idUserStatus) {
        this.idUserStatus = idUserStatus;
    }

    public Integer getIdUserStatus() {
        return idUserStatus;
    }

    public void setIdUserStatus(Integer idUserStatus) {
        this.idUserStatus = idUserStatus;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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
        hash += (idUserStatus != null ? idUserStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserStatus)) {
            return false;
        }
        UserStatus other = (UserStatus) object;
        if ((this.idUserStatus == null && other.idUserStatus != null) || (this.idUserStatus != null && !this.idUserStatus.equals(other.idUserStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.entity.UserStatus[ idUserStatus=" + idUserStatus + " ]";
    }

}
