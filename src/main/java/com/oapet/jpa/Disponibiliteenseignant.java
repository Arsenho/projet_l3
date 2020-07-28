/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oapet.jpa;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Arseme
 */
@Entity
@Table(name = "disponibiliteenseignant")
@NamedQueries({
    @NamedQuery(name = "Disponibiliteenseignant.findAll", query = "SELECT d FROM Disponibiliteenseignant d"),
    @NamedQuery(name = "Disponibiliteenseignant.findByIdDisoinibilite", query = "SELECT d FROM Disponibiliteenseignant d WHERE d.idDisoinibilite = :idDisoinibilite"),
    @NamedQuery(name = "Disponibiliteenseignant.findByJour", query = "SELECT d FROM Disponibiliteenseignant d WHERE d.jour = :jour"),
    @NamedQuery(name = "Disponibiliteenseignant.findByHeureDebut", query = "SELECT d FROM Disponibiliteenseignant d WHERE d.heureDebut = :heureDebut"),
    @NamedQuery(name = "Disponibiliteenseignant.findByHeureFin", query = "SELECT d FROM Disponibiliteenseignant d WHERE d.heureFin = :heureFin")})
public class Disponibiliteenseignant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_disoinibilite")
    private Integer idDisoinibilite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jour")
    @Temporal(TemporalType.DATE)
    private Date jour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heure_debut")
    @Temporal(TemporalType.TIME)
    private Date heureDebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heure_fin")
    @Temporal(TemporalType.TIME)
    private Date heureFin;
    @JoinColumn(name = "code_cours", referencedColumnName = "code_cours")
    @ManyToOne(optional = false)
    private Cours codeCours;
    @JoinColumn(name = "id_emploi_temps", referencedColumnName = "id_emploi_temps")
    @ManyToOne(optional = false)
    private Emploitemps idEmploiTemps;
    @JoinColumn(name = "id_enseignant", referencedColumnName = "id_enseignant")
    @ManyToOne(optional = false)
    private Enseignant idEnseignant;

    public Disponibiliteenseignant() {
    }

    public Disponibiliteenseignant(Integer idDisoinibilite) {
        this.idDisoinibilite = idDisoinibilite;
    }

    public Disponibiliteenseignant(Integer idDisoinibilite, Date jour, Date heureDebut, Date heureFin) {
        this.idDisoinibilite = idDisoinibilite;
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public Integer getIdDisoinibilite() {
        return idDisoinibilite;
    }

    public void setIdDisoinibilite(Integer idDisoinibilite) {
        this.idDisoinibilite = idDisoinibilite;
    }

    public Date getJour() {
        return jour;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }

    public Cours getCodeCours() {
        return codeCours;
    }

    public void setCodeCours(Cours codeCours) {
        this.codeCours = codeCours;
    }

    public Emploitemps getIdEmploiTemps() {
        return idEmploiTemps;
    }

    public void setIdEmploiTemps(Emploitemps idEmploiTemps) {
        this.idEmploiTemps = idEmploiTemps;
    }

    public Enseignant getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Enseignant idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDisoinibilite != null ? idDisoinibilite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disponibiliteenseignant)) {
            return false;
        }
        Disponibiliteenseignant other = (Disponibiliteenseignant) object;
        if ((this.idDisoinibilite == null && other.idDisoinibilite != null) || (this.idDisoinibilite != null && !this.idDisoinibilite.equals(other.idDisoinibilite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oapet.jpa.Disponibiliteenseignant[ idDisoinibilite=" + idDisoinibilite + " ]";
    }
    
}
