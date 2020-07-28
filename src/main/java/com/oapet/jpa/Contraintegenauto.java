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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Arseme
 */
@Entity
@Table(name = "contraintegenauto")
@NamedQueries({
    @NamedQuery(name = "Contraintegenauto.findAll", query = "SELECT c FROM Contraintegenauto c"),
    @NamedQuery(name = "Contraintegenauto.findByIdContainteGenAuto", query = "SELECT c FROM Contraintegenauto c WHERE c.idContainteGenAuto = :idContainteGenAuto"),
    @NamedQuery(name = "Contraintegenauto.findByPrioriteFifo", query = "SELECT c FROM Contraintegenauto c WHERE c.prioriteFifo = :prioriteFifo"),
    @NamedQuery(name = "Contraintegenauto.findByPrioriteRetardCm", query = "SELECT c FROM Contraintegenauto c WHERE c.prioriteRetardCm = :prioriteRetardCm"),
    @NamedQuery(name = "Contraintegenauto.findByPrioriteRetardtTd", query = "SELECT c FROM Contraintegenauto c WHERE c.prioriteRetardtTd = :prioriteRetardtTd"),
    @NamedQuery(name = "Contraintegenauto.findByPrioriteRetardTp", query = "SELECT c FROM Contraintegenauto c WHERE c.prioriteRetardTp = :prioriteRetardTp")})
public class Contraintegenauto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_containte_gen_auto")
    private Integer idContainteGenAuto;
    @Column(name = "priorite_fifo")
    private Boolean prioriteFifo;
    @Column(name = "priorite__retard_cm")
    private Boolean prioriteRetardCm;
    @Column(name = "priorite_retardt_td")
    private Boolean prioriteRetardtTd;
    @Column(name = "priorite_retard_tp")
    private Boolean prioriteRetardTp;
    @JoinColumn(name = "id_charge_production", referencedColumnName = "id_charge_production")
    @ManyToOne(optional = false)
    private Chargeproduction idChargeProduction;
    @JoinColumn(name = "id_emploi_temps", referencedColumnName = "id_emploi_temps")
    @ManyToOne
    private Emploitemps idEmploiTemps;

    public Contraintegenauto() {
    }

    public Contraintegenauto(Integer idContainteGenAuto) {
        this.idContainteGenAuto = idContainteGenAuto;
    }

    public Integer getIdContainteGenAuto() {
        return idContainteGenAuto;
    }

    public void setIdContainteGenAuto(Integer idContainteGenAuto) {
        this.idContainteGenAuto = idContainteGenAuto;
    }

    public Boolean getPrioriteFifo() {
        return prioriteFifo;
    }

    public void setPrioriteFifo(Boolean prioriteFifo) {
        this.prioriteFifo = prioriteFifo;
    }

    public Boolean getPrioriteRetardCm() {
        return prioriteRetardCm;
    }

    public void setPrioriteRetardCm(Boolean prioriteRetardCm) {
        this.prioriteRetardCm = prioriteRetardCm;
    }

    public Boolean getPrioriteRetardtTd() {
        return prioriteRetardtTd;
    }

    public void setPrioriteRetardtTd(Boolean prioriteRetardtTd) {
        this.prioriteRetardtTd = prioriteRetardtTd;
    }

    public Boolean getPrioriteRetardTp() {
        return prioriteRetardTp;
    }

    public void setPrioriteRetardTp(Boolean prioriteRetardTp) {
        this.prioriteRetardTp = prioriteRetardTp;
    }

    public Chargeproduction getIdChargeProduction() {
        return idChargeProduction;
    }

    public void setIdChargeProduction(Chargeproduction idChargeProduction) {
        this.idChargeProduction = idChargeProduction;
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
        hash += (idContainteGenAuto != null ? idContainteGenAuto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contraintegenauto)) {
            return false;
        }
        Contraintegenauto other = (Contraintegenauto) object;
        if ((this.idContainteGenAuto == null && other.idContainteGenAuto != null) || (this.idContainteGenAuto != null && !this.idContainteGenAuto.equals(other.idContainteGenAuto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oapet.jpa.Contraintegenauto[ idContainteGenAuto=" + idContainteGenAuto + " ]";
    }
    
}
