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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arseme
 */
@Entity
@Table(name = "chargeproduction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chargeproduction.findAll", query = "SELECT c FROM Chargeproduction c"),
    @NamedQuery(name = "Chargeproduction.findByIdChargeProduction", query = "SELECT c FROM Chargeproduction c WHERE c.idChargeProduction = :idChargeProduction"),
    @NamedQuery(name = "Chargeproduction.findByDateAjout", query = "SELECT c FROM Chargeproduction c WHERE c.dateAjout = :dateAjout"),
    @NamedQuery(name = "Chargeproduction.findByDateModofication", query = "SELECT c FROM Chargeproduction c WHERE c.dateModofication = :dateModofication")})
public class Chargeproduction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_charge_production")
    private Integer idChargeProduction;
    @Column(name = "date_ajout")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAjout;
    @Column(name = "date_modofication")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModofication;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idChargeProduction")
    private List<Emploitemps> emploitempsList;
    @OneToMany(mappedBy = "idChargeProductionAjoute")
    private List<Chargeproduction> chargeproductionList;
    @JoinColumn(name = "id_charge_production_ajoute", referencedColumnName = "id_charge_production")
    @ManyToOne
    private Chargeproduction idChargeProductionAjoute;
    @OneToMany(mappedBy = "idChargeProductionPeutEtreM")
    private List<Chargeproduction> chargeproductionList1;
    @JoinColumn(name = "id_charge_production_peut_etre_m", referencedColumnName = "id_charge_production")
    @ManyToOne
    private Chargeproduction idChargeProductionPeutEtreM;
    @JoinColumn(name = "email", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Utilisateur email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idChargeProduction")
    private List<Contraintehoraire> contraintehoraireList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idChargeProduction")
    private List<Chargesuivi> chargesuiviList;
    @OneToMany(mappedBy = "idChargeProductionPeutEtreM")
    private List<Chargesuivi> chargesuiviList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idChargeProduction")
    private List<Enseignant> enseignantList;
    @OneToMany(mappedBy = "idChargeProductionModifier")
    private List<Enseignant> enseignantList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idChargeProduction")
    private List<Cours> coursList;

    public Chargeproduction() {
    }

    public Chargeproduction(Integer idChargeProduction) {
        this.idChargeProduction = idChargeProduction;
    }

    public Integer getIdChargeProduction() {
        return idChargeProduction;
    }

    public void setIdChargeProduction(Integer idChargeProduction) {
        this.idChargeProduction = idChargeProduction;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Date getDateModofication() {
        return dateModofication;
    }

    public void setDateModofication(Date dateModofication) {
        this.dateModofication = dateModofication;
    }

    @XmlTransient
    public List<Emploitemps> getEmploitempsList() {
        return emploitempsList;
    }

    public void setEmploitempsList(List<Emploitemps> emploitempsList) {
        this.emploitempsList = emploitempsList;
    }

    @XmlTransient
    public List<Chargeproduction> getChargeproductionList() {
        return chargeproductionList;
    }

    public void setChargeproductionList(List<Chargeproduction> chargeproductionList) {
        this.chargeproductionList = chargeproductionList;
    }

    public Chargeproduction getIdChargeProductionAjoute() {
        return idChargeProductionAjoute;
    }

    public void setIdChargeProductionAjoute(Chargeproduction idChargeProductionAjoute) {
        this.idChargeProductionAjoute = idChargeProductionAjoute;
    }

    @XmlTransient
    public List<Chargeproduction> getChargeproductionList1() {
        return chargeproductionList1;
    }

    public void setChargeproductionList1(List<Chargeproduction> chargeproductionList1) {
        this.chargeproductionList1 = chargeproductionList1;
    }

    public Chargeproduction getIdChargeProductionPeutEtreM() {
        return idChargeProductionPeutEtreM;
    }

    public void setIdChargeProductionPeutEtreM(Chargeproduction idChargeProductionPeutEtreM) {
        this.idChargeProductionPeutEtreM = idChargeProductionPeutEtreM;
    }

    public Utilisateur getEmail() {
        return email;
    }

    public void setEmail(Utilisateur email) {
        this.email = email;
    }

    @XmlTransient
    public List<Contraintehoraire> getContraintehoraireList() {
        return contraintehoraireList;
    }

    public void setContraintehoraireList(List<Contraintehoraire> contraintehoraireList) {
        this.contraintehoraireList = contraintehoraireList;
    }

    @XmlTransient
    public List<Chargesuivi> getChargesuiviList() {
        return chargesuiviList;
    }

    public void setChargesuiviList(List<Chargesuivi> chargesuiviList) {
        this.chargesuiviList = chargesuiviList;
    }

    @XmlTransient
    public List<Chargesuivi> getChargesuiviList1() {
        return chargesuiviList1;
    }

    public void setChargesuiviList1(List<Chargesuivi> chargesuiviList1) {
        this.chargesuiviList1 = chargesuiviList1;
    }

    @XmlTransient
    public List<Enseignant> getEnseignantList() {
        return enseignantList;
    }

    public void setEnseignantList(List<Enseignant> enseignantList) {
        this.enseignantList = enseignantList;
    }

    @XmlTransient
    public List<Enseignant> getEnseignantList1() {
        return enseignantList1;
    }

    public void setEnseignantList1(List<Enseignant> enseignantList1) {
        this.enseignantList1 = enseignantList1;
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
        hash += (idChargeProduction != null ? idChargeProduction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chargeproduction)) {
            return false;
        }
        Chargeproduction other = (Chargeproduction) object;
        if ((this.idChargeProduction == null && other.idChargeProduction != null) || (this.idChargeProduction != null && !this.idChargeProduction.equals(other.idChargeProduction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oapet.jpa.Chargeproduction[ idChargeProduction=" + idChargeProduction + " ]";
    }
    
}
