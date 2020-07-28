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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arseme
 */
@Entity
@Table(name = "contraintehoraire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contraintehoraire.findAll", query = "SELECT c FROM Contraintehoraire c"),
    @NamedQuery(name = "Contraintehoraire.findByIdContrainteHoraire", query = "SELECT c FROM Contraintehoraire c WHERE c.idContrainteHoraire = :idContrainteHoraire"),
    @NamedQuery(name = "Contraintehoraire.findByHeureDebutCours", query = "SELECT c FROM Contraintehoraire c WHERE c.heureDebutCours = :heureDebutCours"),
    @NamedQuery(name = "Contraintehoraire.findByHeureFinCours", query = "SELECT c FROM Contraintehoraire c WHERE c.heureFinCours = :heureFinCours"),
    @NamedQuery(name = "Contraintehoraire.findByDureePeriode", query = "SELECT c FROM Contraintehoraire c WHERE c.dureePeriode = :dureePeriode"),
    @NamedQuery(name = "Contraintehoraire.findByDureePause", query = "SELECT c FROM Contraintehoraire c WHERE c.dureePause = :dureePause"),
    @NamedQuery(name = "Contraintehoraire.findByHeureDebutPause", query = "SELECT c FROM Contraintehoraire c WHERE c.heureDebutPause = :heureDebutPause")})
public class Contraintehoraire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contrainte_horaire")
    private Integer idContrainteHoraire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heure_debut_cours")
    @Temporal(TemporalType.TIME)
    private Date heureDebutCours;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heure_fin_cours")
    @Temporal(TemporalType.TIME)
    private Date heureFinCours;
    @Column(name = "duree_periode")
    private Integer dureePeriode;
    @Column(name = "duree_pause")
    private Integer dureePause;
    @Column(name = "heure_debut_pause")
    @Temporal(TemporalType.TIME)
    private Date heureDebutPause;
    @OneToMany(mappedBy = "idContrainteHoraire")
    private List<Emploitemps> emploitempsList;
    @JoinColumn(name = "id_charge_production", referencedColumnName = "id_charge_production")
    @ManyToOne(optional = false)
    private Chargeproduction idChargeProduction;

    public Contraintehoraire() {
    }

    public Contraintehoraire(Integer idContrainteHoraire) {
        this.idContrainteHoraire = idContrainteHoraire;
    }

    public Contraintehoraire(Integer idContrainteHoraire, Date heureDebutCours, Date heureFinCours) {
        this.idContrainteHoraire = idContrainteHoraire;
        this.heureDebutCours = heureDebutCours;
        this.heureFinCours = heureFinCours;
    }

    public Integer getIdContrainteHoraire() {
        return idContrainteHoraire;
    }

    public void setIdContrainteHoraire(Integer idContrainteHoraire) {
        this.idContrainteHoraire = idContrainteHoraire;
    }

    public Date getHeureDebutCours() {
        return heureDebutCours;
    }

    public void setHeureDebutCours(Date heureDebutCours) {
        this.heureDebutCours = heureDebutCours;
    }

    public Date getHeureFinCours() {
        return heureFinCours;
    }

    public void setHeureFinCours(Date heureFinCours) {
        this.heureFinCours = heureFinCours;
    }

    public Integer getDureePeriode() {
        return dureePeriode;
    }

    public void setDureePeriode(Integer dureePeriode) {
        this.dureePeriode = dureePeriode;
    }

    public Integer getDureePause() {
        return dureePause;
    }

    public void setDureePause(Integer dureePause) {
        this.dureePause = dureePause;
    }

    public Date getHeureDebutPause() {
        return heureDebutPause;
    }

    public void setHeureDebutPause(Date heureDebutPause) {
        this.heureDebutPause = heureDebutPause;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContrainteHoraire != null ? idContrainteHoraire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contraintehoraire)) {
            return false;
        }
        Contraintehoraire other = (Contraintehoraire) object;
        if ((this.idContrainteHoraire == null && other.idContrainteHoraire != null) || (this.idContrainteHoraire != null && !this.idContrainteHoraire.equals(other.idContrainteHoraire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oapet.jpa.Contraintehoraire[ idContrainteHoraire=" + idContrainteHoraire + " ]";
    }
    
}
