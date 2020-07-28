/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oapet.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arseme
 */
@Entity
@Table(name = "enseignant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enseignant.findAll", query = "SELECT e FROM Enseignant e"),
    @NamedQuery(name = "Enseignant.findByIdEnseignant", query = "SELECT e FROM Enseignant e WHERE e.idEnseignant = :idEnseignant"),
    @NamedQuery(name = "Enseignant.findByDateAjout", query = "SELECT e FROM Enseignant e WHERE e.dateAjout = :dateAjout"),
    @NamedQuery(name = "Enseignant.findByDateModification", query = "SELECT e FROM Enseignant e WHERE e.dateModification = :dateModification")})
public class Enseignant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_enseignant")
    private Integer idEnseignant;
    @Column(name = "date_ajout")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAjout;
    @Column(name = "date_modification")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @JoinTable(name = "enseignant_appartenir_filiere", joinColumns = {
        @JoinColumn(name = "id_enseignant", referencedColumnName = "id_enseignant")}, inverseJoinColumns = {
        @JoinColumn(name = "id_filiere", referencedColumnName = "id_filiere")})
    @ManyToMany
    private List<Filiere> filiereList;
    @JoinColumn(name = "id_charge_production", referencedColumnName = "id_charge_production")
    @ManyToOne(optional = false)
    private Chargeproduction idChargeProduction;
    @JoinColumn(name = "id_charge_production_modifier", referencedColumnName = "id_charge_production")
    @ManyToOne
    private Chargeproduction idChargeProductionModifier;
    @JoinColumn(name = "email", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Utilisateur email;
    @OneToMany(mappedBy = "idEnseignant")
    private List<Cours> coursList;

    public Enseignant() {
    }

    public Enseignant(Integer idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public Integer getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Integer idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    @XmlTransient
    public List<Filiere> getFiliereList() {
        return filiereList;
    }

    public void setFiliereList(List<Filiere> filiereList) {
        this.filiereList = filiereList;
    }

    public Chargeproduction getIdChargeProduction() {
        return idChargeProduction;
    }

    public void setIdChargeProduction(Chargeproduction idChargeProduction) {
        this.idChargeProduction = idChargeProduction;
    }

    public Chargeproduction getIdChargeProductionModifier() {
        return idChargeProductionModifier;
    }

    public void setIdChargeProductionModifier(Chargeproduction idChargeProductionModifier) {
        this.idChargeProductionModifier = idChargeProductionModifier;
    }

    public Utilisateur getEmail() {
        return email;
    }

    public void setEmail(Utilisateur email) {
        this.email = email;
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
        hash += (idEnseignant != null ? idEnseignant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enseignant)) {
            return false;
        }
        Enseignant other = (Enseignant) object;
        if ((this.idEnseignant == null && other.idEnseignant != null) || (this.idEnseignant != null && !this.idEnseignant.equals(other.idEnseignant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oapet.jpa.Enseignant[ idEnseignant=" + idEnseignant + " ]";
    }
    
}
