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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Arseme
 */
@Entity
@Table(name = "notification")
@NamedQueries({
    @NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n"),
    @NamedQuery(name = "Notification.findByIdNotification", query = "SELECT n FROM Notification n WHERE n.idNotification = :idNotification"),
    @NamedQuery(name = "Notification.findByTypeNotification", query = "SELECT n FROM Notification n WHERE n.typeNotification = :typeNotification"),
    @NamedQuery(name = "Notification.findByMessage", query = "SELECT n FROM Notification n WHERE n.message = :message"),
    @NamedQuery(name = "Notification.findByPieceJointe", query = "SELECT n FROM Notification n WHERE n.pieceJointe = :pieceJointe")})
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_notification")
    private Integer idNotification;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "type_notification")
    private String typeNotification;
    @Size(max = 255)
    @Column(name = "message")
    private String message;
    @Size(max = 128)
    @Column(name = "piece_jointe")
    private String pieceJointe;
    @JoinColumn(name = "id_charge_production", referencedColumnName = "id_charge_production")
    @ManyToOne(optional = false)
    private Chargeproduction idChargeProduction;

    public Notification() {
    }

    public Notification(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public Notification(Integer idNotification, String typeNotification) {
        this.idNotification = idNotification;
        this.typeNotification = typeNotification;
    }

    public Integer getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public String getTypeNotification() {
        return typeNotification;
    }

    public void setTypeNotification(String typeNotification) {
        this.typeNotification = typeNotification;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPieceJointe() {
        return pieceJointe;
    }

    public void setPieceJointe(String pieceJointe) {
        this.pieceJointe = pieceJointe;
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
        hash += (idNotification != null ? idNotification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.idNotification == null && other.idNotification != null) || (this.idNotification != null && !this.idNotification.equals(other.idNotification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oapet.jpa.Notification[ idNotification=" + idNotification + " ]";
    }
    
}
