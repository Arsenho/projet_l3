/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oapet.jsfbean;

import com.oapet.jpa.Periode;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import org.joda.time.DateTime;

/**
 *
 * @author Arseme
 */

@SessionScoped
public class Enregistrement implements Serializable {
    
    private Date periode;
    private Periode lundi;
    private Periode mardi;
    private Periode mercredi;
    private Periode jeudi;
    private Periode vendredi;
    private Periode samedi;
    
    public Enregistrement(){
        
    }

    public Date getPeriode() {
        return periode;
    }

    public void setPeriode(Date periode) {
        this.periode = periode;
    }

    public Periode getLundi() {
        return lundi;
    }

    public void setLundi(Periode lundi) {
        this.lundi = lundi;
    }

    public Periode getMardi() {
        return mardi;
    }

    public void setMardi(Periode mardi) {
        this.mardi = mardi;
    }

    public Periode getMercredi() {
        return mercredi;
    }

    public void setMercredi(Periode mercredi) {
        this.mercredi = mercredi;
    }

    public Periode getJeudi() {
        return jeudi;
    }

    public void setJeudi(Periode jeudi) {
        this.jeudi = jeudi;
    }

    public Periode getVendredi() {
        return vendredi;
    }

    public void setVendredi(Periode vendredi) {
        this.vendredi = vendredi;
    }

    public Periode getSamedi() {
        return samedi;
    }

    public void setSamedi(Periode samedi) {
        this.samedi = samedi;
    }

    
    
}
