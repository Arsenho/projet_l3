/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oapet.jsfbean;

import com.oapet.jpa.Cours;
import java.util.List;
import org.joda.time.DateTime;

/**
 *
 * @author Arseme
 */
public class Cellule {
    
    private Cours listeCours;
    private String autreCours;
    private String typecours;
    
    public Cellule(){
        
    }

    public String getAutreCours() {
        return autreCours;
    }

    public void setAutreCours(String autreCours) {
        this.autreCours = autreCours;
    }

    public String getTypecours() {
        return typecours;
    }

    public void setTypecours(String typecours) {
        this.typecours = typecours;
    }
    
    
    
}
