/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oapet.jpa;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom"),
    @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom"),
    @NamedQuery(name = "Utilisateur.findByTelephone", query = "SELECT u FROM Utilisateur u WHERE u.telephone = :telephone"),
    @NamedQuery(name = "Utilisateur.findByEmail", query = "SELECT u FROM Utilisateur u WHERE u.email = :email"),
    @NamedQuery(name = "Utilisateur.findByUsername", query = "SELECT u FROM Utilisateur u WHERE u.username = :username"),
    @NamedQuery(name = "Utilisateur.findByPassword", query = "SELECT u FROM Utilisateur u WHERE u.password = :password")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 128)
    @Column(name = "nom")
    private String nom;
    @Size(max = 128)
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "telephone")
    private BigInteger telephone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "email")
    private String email;
    @Size(max = 128)
    @Column(name = "username")
    private String username;
    @Size(max = 128)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "email")
    private List<Chargeproduction> chargeproductionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "email")
    private List<Chargesuivi> chargesuiviList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "email")
    private List<Enseignant> enseignantList;

    public Utilisateur() {
    }

    public Utilisateur(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public BigInteger getTelephone() {
        return telephone;
    }

    public void setTelephone(BigInteger telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<Chargeproduction> getChargeproductionList() {
        return chargeproductionList;
    }

    public void setChargeproductionList(List<Chargeproduction> chargeproductionList) {
        this.chargeproductionList = chargeproductionList;
    }

    @XmlTransient
    public List<Chargesuivi> getChargesuiviList() {
        return chargesuiviList;
    }

    public void setChargesuiviList(List<Chargesuivi> chargesuiviList) {
        this.chargesuiviList = chargesuiviList;
    }

    @XmlTransient
    public List<Enseignant> getEnseignantList() {
        return enseignantList;
    }

    public void setEnseignantList(List<Enseignant> enseignantList) {
        this.enseignantList = enseignantList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oapet.jpa.Utilisateur[ email=" + email + " ]";
    }
    
}
