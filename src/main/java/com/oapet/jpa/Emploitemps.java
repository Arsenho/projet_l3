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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arseme
 */
@Entity
@Table(name = "emploitemps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emploitemps.findAll", query = "SELECT e FROM Emploitemps e"),
    @NamedQuery(name = "Emploitemps.findByIdEmploiTemps", query = "SELECT e FROM Emploitemps e WHERE e.idEmploiTemps = :idEmploiTemps"),
    @NamedQuery(name = "Emploitemps.findByDateDebut", query = "SELECT e FROM Emploitemps e WHERE e.dateDebut = :dateDebut"),
    @NamedQuery(name = "Emploitemps.findByDateFin", query = "SELECT e FROM Emploitemps e WHERE e.dateFin = :dateFin"),
    @NamedQuery(name = "Emploitemps.findByDateCreation", query = "SELECT e FROM Emploitemps e WHERE e.dateCreation = :dateCreation"),
    @NamedQuery(name = "Emploitemps.findByDateValidation", query = "SELECT e FROM Emploitemps e WHERE e.dateValidation = :dateValidation")})
public class Emploitemps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_emploi_temps")
    private Integer idEmploiTemps;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_debut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "date_validation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateValidation;
    @JoinColumn(name = "id_charge_production", referencedColumnName = "id_charge_production")
    @ManyToOne(optional = false)
    private Chargeproduction idChargeProduction;
    @JoinColumn(name = "id_charge_suivi", referencedColumnName = "id_charge_suivi")
    @ManyToOne
    private Chargesuivi idChargeSuivi;
    @JoinColumn(name = "id_contrainte_horaire", referencedColumnName = "id_contrainte_horaire")
    @ManyToOne
    private Contraintehoraire idContrainteHoraire;
    @JoinColumn(name = "id_filiere", referencedColumnName = "id_filiere")
    @ManyToOne
    private Filiere idFiliere;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmploiTemps")
    private List<Periode> periodeList;

    public Emploitemps() {
    }

    public Emploitemps(Integer idEmploiTemps) {
        this.idEmploiTemps = idEmploiTemps;
    }

    public Emploitemps(Integer idEmploiTemps, Date dateDebut, Date dateFin) {
        this.idEmploiTemps = idEmploiTemps;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Integer getIdEmploiTemps() {
        return idEmploiTemps;
    }

    public void setIdEmploiTemps(Integer idEmploiTemps) {
        this.idEmploiTemps = idEmploiTemps;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(Date dateValidation) {
        this.dateValidation = dateValidation;
    }

    public Chargeproduction getIdChargeProduction() {
        return idChargeProduction;
    }

    public void setIdChargeProduction(Chargeproduction idChargeProduction) {
        this.idChargeProduction = idChargeProduction;
    }

    public Chargesuivi getIdChargeSuivi() {
        return idChargeSuivi;
    }

    public void setIdChargeSuivi(Chargesuivi idChargeSuivi) {
        this.idChargeSuivi = idChargeSuivi;
    }

    public Contraintehoraire getIdContrainteHoraire() {
        return idContrainteHoraire;
    }

    public void setIdContrainteHoraire(Contraintehoraire idContrainteHoraire) {
        this.idContrainteHoraire = idContrainteHoraire;
    }

    public Filiere getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Filiere idFiliere) {
        this.idFiliere = idFiliere;
    }

    @XmlTransient
    public List<Periode> getPeriodeList() {
        return periodeList;
    }

    public void setPeriodeList(List<Periode> periodeList) {
        this.periodeList = periodeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmploiTemps != null ? idEmploiTemps.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emploitemps)) {
            return false;
        }
        Emploitemps other = (Emploitemps) object;
        if ((this.idEmploiTemps == null && other.idEmploiTemps != null) || (this.idEmploiTemps != null && !this.idEmploiTemps.equals(other.idEmploiTemps))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oapet.jpa.Emploitemps[ idEmploiTemps=" + idEmploiTemps + " ]";
    }
    
}
