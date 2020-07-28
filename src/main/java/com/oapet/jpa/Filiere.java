/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oapet.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arseme
 */
@Entity
@Table(name = "filiere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filiere.findAll", query = "SELECT f FROM Filiere f"),
    @NamedQuery(name = "Filiere.findByIdFiliere", query = "SELECT f FROM Filiere f WHERE f.idFiliere = :idFiliere"),
    @NamedQuery(name = "Filiere.findByCodeFiliere", query = "SELECT f FROM Filiere f WHERE f.codeFiliere = :codeFiliere"),
    @NamedQuery(name = "Filiere.findByInstituleFiliere", query = "SELECT f FROM Filiere f WHERE f.instituleFiliere = :instituleFiliere"),
    @NamedQuery(name = "Filiere.findByNiveauFiliere", query = "SELECT f FROM Filiere f WHERE f.niveauFiliere = :niveauFiliere")})
public class Filiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_filiere")
    private Integer idFiliere;
    @Size(max = 32)
    @Column(name = "code_filiere")
    private String codeFiliere;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "institule_filiere")
    private String instituleFiliere;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "niveau_filiere")
    private String niveauFiliere;
    @ManyToMany(mappedBy = "filiereList")
    private List<Enseignant> enseignantList;
    @OneToMany(mappedBy = "idFiliere")
    private List<Emploitemps> emploitempsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFiliere")
    private List<Chargesuivi> chargesuiviList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFiliere")
    private List<Cours> coursList;

    public Filiere() {
    }

    public Filiere(Integer idFiliere) {
        this.idFiliere = idFiliere;
    }

    public Filiere(Integer idFiliere, String instituleFiliere, String niveauFiliere) {
        this.idFiliere = idFiliere;
        this.instituleFiliere = instituleFiliere;
        this.niveauFiliere = niveauFiliere;
    }

    public Integer getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Integer idFiliere) {
        this.idFiliere = idFiliere;
    }

    public String getCodeFiliere() {
        return codeFiliere;
    }

    public void setCodeFiliere(String codeFiliere) {
        this.codeFiliere = codeFiliere;
    }

    public String getInstituleFiliere() {
        return instituleFiliere;
    }

    public void setInstituleFiliere(String instituleFiliere) {
        this.instituleFiliere = instituleFiliere;
    }

    public String getNiveauFiliere() {
        return niveauFiliere;
    }

    public void setNiveauFiliere(String niveauFiliere) {
        this.niveauFiliere = niveauFiliere;
    }

    @XmlTransient
    public List<Enseignant> getEnseignantList() {
        return enseignantList;
    }

    public void setEnseignantList(List<Enseignant> enseignantList) {
        this.enseignantList = enseignantList;
    }

    @XmlTransient
    public List<Emploitemps> getEmploitempsList() {
        return emploitempsList;
    }

    public void setEmploitempsList(List<Emploitemps> emploitempsList) {
        this.emploitempsList = emploitempsList;
    }

    @XmlTransient
    public List<Chargesuivi> getChargesuiviList() {
        return chargesuiviList;
    }

    public void setChargesuiviList(List<Chargesuivi> chargesuiviList) {
        this.chargesuiviList = chargesuiviList;
    }

    @XmlTransient
    public List<Cours> getCoursList() {
        return coursList;
    }

    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFiliere != null ? idFiliere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filiere)) {
            return false;
        }
        Filiere other = (Filiere) object;
        if ((this.idFiliere == null && other.idFiliere != null) || (this.idFiliere != null && !this.idFiliere.equals(other.idFiliere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oapet.jpa.Filiere[ idFiliere=" + idFiliere + " ]";
    }
    
}
