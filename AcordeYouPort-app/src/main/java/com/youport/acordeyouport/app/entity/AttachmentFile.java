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
@Table(name = "attachment_file")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttachmentFile.findAll", query = "SELECT a FROM AttachmentFile a"),
    @NamedQuery(name = "AttachmentFile.findByIdAttachmentFile", query = "SELECT a FROM AttachmentFile a WHERE a.idAttachmentFile = :idAttachmentFile"),
    @NamedQuery(name = "AttachmentFile.findByNameFile", query = "SELECT a FROM AttachmentFile a WHERE a.nameFile = :nameFile"),
    @NamedQuery(name = "AttachmentFile.findByPathFile", query = "SELECT a FROM AttachmentFile a WHERE a.pathFile = :pathFile"),
    @NamedQuery(name = "AttachmentFile.findByExtentionFile", query = "SELECT a FROM AttachmentFile a WHERE a.extentionFile = :extentionFile"),
    @NamedQuery(name = "AttachmentFile.findByDescription", query = "SELECT a FROM AttachmentFile a WHERE a.description = :description")})
public class AttachmentFile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Attachment_File")
    private Integer idAttachmentFile;
    @Size(max = 45)
    @Column(name = "Name_File")
    private String nameFile;
    @Size(max = 200)
    @Column(name = "Path_File")
    private String pathFile;
    @Size(max = 45)
    @Column(name = "Extention_File")
    private String extentionFile;
    @Size(max = 300)
    @Column(name = "Description")
    private String description;
    @Size(max = 45)
    @Column(name = "File_Size")
    private String fileSize;
    @JoinColumn(name = "Id_Section_Company", referencedColumnName = "Id_Section_Company")
    @ManyToOne(optional = false )
    private SectionCompany idSectionCompany;

    public AttachmentFile() {
    }

    public AttachmentFile(Integer idAttachmentFile) {
        this.idAttachmentFile = idAttachmentFile;
    }

    public Integer getIdAttachmentFile() {
        return idAttachmentFile;
    }

    public void setIdAttachmentFile(Integer idAttachmentFile) {
        this.idAttachmentFile = idAttachmentFile;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public String getExtentionFile() {
        return extentionFile;
    }

    public void setExtentionFile(String extentionFile) {
        this.extentionFile = extentionFile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SectionCompany getIdSectionCompany() {
        return idSectionCompany;
    }

    public void setIdSectionCompany(SectionCompany idSectionCompany) {
        this.idSectionCompany = idSectionCompany;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAttachmentFile != null ? idAttachmentFile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttachmentFile)) {
            return false;
        }
        AttachmentFile other = (AttachmentFile) object;
        if ((this.idAttachmentFile == null && other.idAttachmentFile != null) || (this.idAttachmentFile != null && !this.idAttachmentFile.equals(other.idAttachmentFile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.entity.AttachmentFile[ idAttachmentFile=" + idAttachmentFile + " ]";
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

}
