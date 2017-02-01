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
@Table(name = "section_company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SectionCompany.findAll", query = "SELECT s FROM SectionCompany s"),
    @NamedQuery(name = "SectionCompany.findByIdSectionCompany", query = "SELECT s FROM SectionCompany s WHERE s.idSectionCompany = :idSectionCompany"),
    @NamedQuery(name = "SectionCompany.findByParagraph", query = "SELECT s FROM SectionCompany s WHERE s.paragraph = :paragraph"),
})
public class SectionCompany implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Section_Company")
    private Integer idSectionCompany;
    @Size(max = 8000)
    @Column(name = "Paragraph")
    private String paragraph;
    @JoinColumn(name = "Id_Company", referencedColumnName = "Id_Company")
    @ManyToOne(optional = false)
    private Company idCompany;
    @JoinColumn(name = "Id_Section", referencedColumnName = "Id_Section")
    @ManyToOne(optional = false)
    private SectionMenuCompany idSection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSectionCompany")
    private List<AttachmentFile> attachmentFileList;

    public SectionCompany() {
    }

    public SectionCompany(Integer idSectionCompany) {
        this.idSectionCompany = idSectionCompany;
    }

    public Integer getIdSectionCompany() {
        return idSectionCompany;
    }

    public void setIdSectionCompany(Integer idSectionCompany) {
        this.idSectionCompany = idSectionCompany;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

  
    public Company getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Company idCompany) {
        this.idCompany = idCompany;
    }

    public SectionMenuCompany getIdSection() {
        return idSection;
    }

    public void setIdSection(SectionMenuCompany idSection) {
        this.idSection = idSection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSectionCompany != null ? idSectionCompany.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SectionCompany)) {
            return false;
        }
        SectionCompany other = (SectionCompany) object;
        if ((this.idSectionCompany == null && other.idSectionCompany != null) || (this.idSectionCompany != null && !this.idSectionCompany.equals(other.idSectionCompany))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youport.acordeyouport.app.entity.SectionCompany[ idSectionCompany=" + idSectionCompany + " ]";
    }

    @XmlTransient
    public List<AttachmentFile> getAttachmentFileList() {
        return attachmentFileList;
    }

    public void setAttachmentFileList(List<AttachmentFile> attachmentFileList) {
        this.attachmentFileList = attachmentFileList;
    }

}
