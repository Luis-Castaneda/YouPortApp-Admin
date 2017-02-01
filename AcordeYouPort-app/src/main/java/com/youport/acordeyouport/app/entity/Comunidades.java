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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ivan Silva <isilva at Acorde>
 */
@Entity
@Table(name = "comunidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comunidades.findAll", query = "SELECT c FROM Comunidades c")
    , @NamedQuery(name = "Comunidades.findByIdComunidad", query = "SELECT c FROM Comunidades c WHERE c.idComunidad = :idComunidad")
    , @NamedQuery(name = "Comunidades.findByNombre", query = "SELECT c FROM Comunidades c WHERE c.nombre = :nombre")})
public class Comunidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_comunidad")
    private Short idComunidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;

    public Comunidades() {
    }

    public Comunidades(Short idComunidad) {
        this.idComunidad = idComunidad;
    }

    public Comunidades(Short idComunidad, String nombre) {
        this.idComunidad = idComunidad;
        this.nombre = nombre;
    }

    public Short getIdComunidad() {
        return idComunidad;
    }

    public void setIdComunidad(Short idComunidad) {
        this.idComunidad = idComunidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComunidad != null ? idComunidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comunidades)) {
            return false;
        }
        Comunidades other = (Comunidades) object;
        if ((this.idComunidad == null && other.idComunidad != null) || (this.idComunidad != null && !this.idComunidad.equals(other.idComunidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.entity.Comunidades[ idComunidad=" + idComunidad + " ]";
    }
    
}
