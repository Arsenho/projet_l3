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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arseme
 */
@Entity
@Table(name = "chargesuivi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chargesuivi.findAll", query = "SELECT c FROM Chargesuivi c"),
    @NamedQuery(name = "Chargesuivi.findByIdChargeSuivi", query = "SELECT c FROM Chargesuivi c WHERE c.idChargeSuivi = :idChargeSuivi"),
    @NamedQuery(name = "Chargesuivi.findByNature", query = "SELECT c FROM Chargesuivi c WHERE c.nature = :nature"),
    @NamedQuery(name = "Chargesuivi.findByDateAjout", query = "SELECT c FROM Chargesuivi c WHERE c.dateAjout = :dateAjout"),
    @NamedQuery(name = "Chargesuivi.findByDateModification", query = "SELECT c FROM Chargesuivi c WHERE c.dateModification = :dateModification")})
public class Chargesuivi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_charge_suivi")
    private Integer idChargeSuivi;
    @Size(max = 128)
    @Column(name = "nature")
    private String nature;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_ajout")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAjout;
    @Column(name = "date_modification")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @OneToMany(mappedBy = "idChargeSuivi")
    private List<Emploitemps> emploitempsList;
    @JoinColumn(name = "id_charge_production", referencedColumnName = "id_charge_production")
    @ManyToOne(optional = false)
    private Chargeproduction idChargeProduction;
    @JoinColumn(name = "id_charge_production_peut_etre_m", referencedColumnName = "id_charge_production")
    @ManyToOne
    private Chargeproduction idChargeProductionPeutEtreM;
    @JoinColumn(name = "id_filiere", referencedColumnName = "id_filiere")
    @ManyToOne(optional = false)
    private Filiere idFiliere;
    @JoinColumn(name = "email", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Utilisateur email;

    public Chargesuivi() {
    }

    public Chargesuivi(Integer idChargeSuivi) {
        this.idChargeSuivi = idChargeSuivi;
    }

    public Chargesuivi(Integer idChargeSuivi, Date dateAjout) {
        this.idChargeSuivi = idChargeSuivi;
        this.dateAjout = dateAjout;
    }

    public Integer getIdChargeSuivi() {
        return idChargeSuivi;
    }

    public void setIdChargeSuivi(Integer idChargeSuivi) {
        this.idChargeSuivi = idChargeSuivi;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
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
    public List<Emploitemps> getEmploitempsList() {
        return emploitempsList;
    }

    public void setEmploitempsList(List<Emploitemps> emploitempsList) {
        this.emploitempsList = emploitempsList;
    }

    public Chargeproduction getIdChargeProduction() {
        return idChargeProduction;
    }

    public void setIdChargeProduction(Chargeproduction idChargeProduction) {
        this.idChargeProduction = idChargeProduction;
    }

    public Chargeproduction getIdChargeProductionPeutEtreM() {
        return idChargeProductionPeutEtreM;
    }

    public void setIdChargeProductionPeutEtreM(Chargeproduction idChargeProductionPeutEtreM) {
        this.idChargeProductionPeutEtreM = idChargeProductionPeutEtreM;
    }

    public Filiere getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Filiere idFiliere) {
        this.idFiliere = idFiliere;
    }

    public Utilisateur getEmail() {
        return email;
    }

    public void setEmail(Utilisateur email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChargeSuivi != null ? idChargeSuivi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chargesuivi)) {
            return false;
        }
        Chargesuivi other = (Chargesuivi) object;
        if ((this.idChargeSuivi == null && other.idChargeSuivi != null) || (this.idChargeSuivi != null && !this.idChargeSuivi.equals(other.idChargeSuivi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oapet.jpa.Chargesuivi[ idChargeSuivi=" + idChargeSuivi + " ]";
    }
    
}
