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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arseme
 */
@Entity
@Table(name = "periode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periode.findAll", query = "SELECT p FROM Periode p"),
    @NamedQuery(name = "Periode.findByIdPeriode", query = "SELECT p FROM Periode p WHERE p.idPeriode = :idPeriode"),
    @NamedQuery(name = "Periode.findByHeureDebut", query = "SELECT p FROM Periode p WHERE p.heureDebut = :heureDebut"),
    @NamedQuery(name = "Periode.findByHeureFin", query = "SELECT p FROM Periode p WHERE p.heureFin = :heureFin"),
    @NamedQuery(name = "Periode.findByIdEmploiTemps", query = "SELECT p FROM Periode p WHERE p.idEmploiTemps = :idEmploiTemps"),
    @NamedQuery(name = "Periode.findByTypeCours", query = "SELECT p FROM Periode p WHERE p.typeCours = :typeCours"),
    @NamedQuery(name = "Periode.findByEffectivite", query = "SELECT p FROM Periode p WHERE p.effectivite = :effectivite"),
    @NamedQuery(name = "Periode.findByJour", query = "SELECT p FROM Periode p WHERE p.jour = :jour")})
public class Periode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_periode")
    private Integer idPeriode;
    @Column(name = "heure_debut")
    @Temporal(TemporalType.TIME)
    private Date heureDebut;
    @Column(name = "heure_fin")
    @Temporal(TemporalType.TIME)
    private Date heureFin;
    @Size(max = 128)
    @Column(name = "type_cours")
    private String typeCours;
    @Column(name = "effectivite")
    private Boolean effectivite;
    @Size(max = 2147483647)
    @Column(name = "jour")
    private String jour;
    @JoinColumn(name = "code_cours", referencedColumnName = "code_cours")
    @ManyToOne
    private Cours codeCours;
    @JoinColumn(name = "id_emploi_temps", referencedColumnName = "id_emploi_temps")
    @ManyToOne(optional = false)
    private Emploitemps idEmploiTemps;

    public Periode() {
    }

    public Periode(Integer idPeriode) {
        this.idPeriode = idPeriode;
    }

    public Integer getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(Integer idPeriode) {
        this.idPeriode = idPeriode;
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

    public String getTypeCours() {
        return typeCours;
    }

    public void setTypeCours(String typeCours) {
        this.typeCours = typeCours;
    }

    public Boolean getEffectivite() {
        return effectivite;
    }

    public void setEffectivite(Boolean effectivite) {
        this.effectivite = effectivite;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeriode != null ? idPeriode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periode)) {
            return false;
        }
        Periode other = (Periode) object;
        if ((this.idPeriode == null && other.idPeriode != null) || (this.idPeriode != null && !this.idPeriode.equals(other.idPeriode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oapet.jpa.Periode[ idPeriode=" + idPeriode + " ]";
    }
    
}
