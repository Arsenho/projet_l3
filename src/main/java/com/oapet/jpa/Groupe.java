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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Arseme
 */
@Entity
@Table(name = "groupe")
@NamedQueries({
    @NamedQuery(name = "Groupe.findAll", query = "SELECT g FROM Groupe g"),
    @NamedQuery(name = "Groupe.findByIdGroupe", query = "SELECT g FROM Groupe g WHERE g.idGroupe = :idGroupe"),
    @NamedQuery(name = "Groupe.findByNomGroupe", query = "SELECT g FROM Groupe g WHERE g.nomGroupe = :nomGroupe")})
public class Groupe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id_groupe")
    private int idGroupe;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "nom_groupe")
    private String nomGroupe;
    @JoinTable(name = "users_appartenir_group", joinColumns = {
        @JoinColumn(name = "nom_groupe", referencedColumnName = "nom_groupe")}, inverseJoinColumns = {
        @JoinColumn(name = "email", referencedColumnName = "email")})
    @ManyToMany
    private List<Utilisateur> utilisateurList;

    public Groupe() {
    }

    public Groupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public Groupe(String nomGroupe, int idGroupe) {
        this.nomGroupe = nomGroupe;
        this.idGroupe = idGroupe;
    }

    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public List<Utilisateur> getUtilisateurList() {
        return utilisateurList;
    }

    public void setUtilisateurList(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomGroupe != null ? nomGroupe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupe)) {
            return false;
        }
        Groupe other = (Groupe) object;
        if ((this.nomGroupe == null && other.nomGroupe != null) || (this.nomGroupe != null && !this.nomGroupe.equals(other.nomGroupe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oapet.jpa.Groupe[ nomGroupe=" + nomGroupe + " ]";
    }
    
}
