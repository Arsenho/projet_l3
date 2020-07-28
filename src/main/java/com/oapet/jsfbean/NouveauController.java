/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oapet.jsfbean;

import com.oapet.jsf.controller.ChargeproductionController;
import com.oapet.jsf.controller.ChargesuiviController;
import com.oapet.jsf.controller.EnseignantController;
import com.oapet.jsf.controller.GroupeController;
import com.oapet.jsf.controller.UtilisateurController;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Arseme
 */

@Named("nouveauController")
@SessionScoped
public class NouveauController implements Serializable{
    
    private UtilisateurController user;
    private GroupeController group;
    private ChargesuiviController chargesuivi;
    private ChargeproductionController chargeproduction;
    private EnseignantController enseignant;
    private String fonction;
    
    public NouveauController(){
        this.user = new UtilisateurController();
        this.group = new GroupeController();
        this.chargeproduction = new ChargeproductionController();
        this.chargesuivi = new ChargesuiviController();
        this.enseignant = new EnseignantController();
    }
    
    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public UtilisateurController getUser() {
        this.user = new UtilisateurController();
        return user;
    }

    public void setUser(UtilisateurController user) {
        
        this.user = user;
    }

    public GroupeController getGroup() {
        return group;
    }

    public void setGroup(GroupeController group) {
        this.group = group;
    }

    public ChargesuiviController getChargesuivi() {
        return chargesuivi;
    }

    public void setChargesuivi(ChargesuiviController chargesuivi) {
        this.chargesuivi = chargesuivi;
    }

    public ChargeproductionController getChargeproduction() {
        return chargeproduction;
    }

    public void setChargeproduction(ChargeproductionController chargeproduction) {
        this.chargeproduction = chargeproduction;
    }

    public EnseignantController getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(EnseignantController enseignant) {
        this.enseignant = enseignant;
    }
    
    
    public void inscrire(){
        
    }
    
    public void initiliserDateInscription(){
        
    }
}
