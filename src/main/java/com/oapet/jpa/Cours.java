/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oapet.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cours.findAll", query = "SELECT c FROM Cours c"),
    @NamedQuery(name = "Cours.findByCodeCours", query = "SELECT c FROM Cours c WHERE c.codeCours = :codeCours"),
    @NamedQuery(name = "Cours.findByInstituleCours", query = "SELECT c FROM Cours c WHERE c.instituleCours = :instituleCours"),
    @NamedQuery(name = "Cours.findByNbreHeureCm", query = "SELECT c FROM Cours c WHERE c.nbreHeureCm = :nbreHeureCm"),
    @NamedQuery(name = "Cours.findByNbreHeureTd", query = "SELECT c FROM Cours c WHERE c.nbreHeureTd = :nbreHeureTd"),
    @NamedQuery(name = "Cours.findByNbreHeureTp", query = "SELECT c FROM Cours c WHERE c.nbreHeureTp = :nbreHeureTp")})
public class Cours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "code_cours")
    private String codeCours;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "institule_cours")
    private String instituleCours;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbre_heure_cm")
    private int nbreHeureCm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbre_heure_td")
    private int nbreHeureTd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbre_heure_tp")
    private int nbreHeureTp;
    @JoinColumn(name = "id_charge_production", referencedColumnName = "id_charge_production")
    @ManyToOne(optional = false)
    private Chargeproduction idChargeProduction;
    @JoinColumn(name = "id_enseignant", referencedColumnName = "id_enseignant")
    @ManyToOne
    private Enseignant idEnseignant;
    @JoinColumn(name = "id_filiere", referencedColumnName = "id_filiere")
    @ManyToOne(optional = false)
    private Filiere idFiliere;
    @OneToMany(mappedBy = "codeCours")
    private List<Periode> periodeList;

    public Cours() {
    }

    public Cours(String codeCours) {
        this.codeCours = codeCours;
    }

    public Cours(String codeCours, String instituleCours, int nbreHeureCm, int nbreHeureTd, int nbreHeureTp) {
        this.codeCours = codeCours;
        this.instituleCours = instituleCours;
        this.nbreHeureCm = nbreHeureCm;
        this.nbreHeureTd = nbreHeureTd;
        this.nbreHeureTp = nbreHeureTp;
    }

    public String getCodeCours() {
        return codeCours;
    }

    public void setCodeCours(String codeCours) {
        this.codeCours = codeCours;
    }

    public String getInstituleCours() {
        return instituleCours;
    }

    public void setInstituleCours(String instituleCours) {
        this.instituleCours = instituleCours;
    }

    public int getNbreHeureCm() {
        return nbreHeureCm;
    }

    public void setNbreHeureCm(int nbreHeureCm) {
        this.nbreHeureCm = nbreHeureCm;
    }

    public int getNbreHeureTd() {
        return nbreHeureTd;
    }

    public void setNbreHeureTd(int nbreHeureTd) {
        this.nbreHeureTd = nbreHeureTd;
    }

    public int getNbreHeureTp() {
        return nbreHeureTp;
    }

    public void setNbreHeureTp(int nbreHeureTp) {
        this.nbreHeureTp = nbreHeureTp;
    }

    public Chargeproduction getIdChargeProduction() {
        return idChargeProduction;
    }

    public void setIdChargeProduction(Chargeproduction idChargeProduction) {
        this.idChargeProduction = idChargeProduction;
    }

    public Enseignant getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Enseignant idEnseignant) {
        this.idEnseignant = idEnseignant;
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
        hash += (codeCours != null ? codeCours.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cours)) {
            return false;
        }
        Cours other = (Cours) object;
        if ((this.codeCours == null && other.codeCours != null) || (this.codeCours != null && !this.codeCours.equals(other.codeCours))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oapet.jpa.Cours[ codeCours=" + codeCours + " ]";
    }
    
}
