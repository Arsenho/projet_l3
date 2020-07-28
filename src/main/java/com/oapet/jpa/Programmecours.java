/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oapet.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Arseme
 */
@Entity
@Table(name = "programmecours")
@NamedQueries({
    @NamedQuery(name = "Programmecours.findAll", query = "SELECT p FROM Programmecours p"),
    @NamedQuery(name = "Programmecours.findByIdProgrammeCours", query = "SELECT p FROM Programmecours p WHERE p.idProgrammeCours = :idProgrammeCours")})
public class Programmecours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_programme_cours")
    private Integer idProgrammeCours;
    @JoinColumn(name = "code_cours", referencedColumnName = "code_cours")
    @OneToOne(optional = false)
    private Cours codeCours;
    @JoinColumn(name = "id_filiere", referencedColumnName = "id_filiere")
    @OneToOne(optional = false)
    private Filiere idFiliere;

    public Programmecours() {
    }

    public Programmecours(Integer idProgrammeCours) {
        this.idProgrammeCours = idProgrammeCours;
    }

    public Integer getIdProgrammeCours() {
        return idProgrammeCours;
    }

    public void setIdProgrammeCours(Integer idProgrammeCours) {
        this.idProgrammeCours = idProgrammeCours;
    }

    public Cours getCodeCours() {
        return codeCours;
    }

    public void setCodeCours(Cours codeCours) {
        this.codeCours = codeCours;
    }

    public Filiere getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Filiere idFiliere) {
        this.idFiliere = idFiliere;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProgrammeCours != null ? idProgrammeCours.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programmecours)) {
            return false;
        }
        Programmecours other = (Programmecours) object;
        if ((this.idProgrammeCours == null && other.idProgrammeCours != null) || (this.idProgrammeCours != null && !this.idProgrammeCours.equals(other.idProgrammeCours))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oapet.jpa.Programmecours[ idProgrammeCours=" + idProgrammeCours + " ]";
    }
    
}
