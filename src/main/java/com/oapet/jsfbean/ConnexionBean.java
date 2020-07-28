/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oapet.jsfbean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author Arseme
 */
@Named("connexionBean")
@SessionScoped
public class ConnexionBean implements Serializable{

    private String type = null;

    public ConnexionBean() {
    }
    
    public void setType(String type){
        this.type=type;
    }
    
    public String getType(){
        return this.type;
    }
    
    public String rediriger(){
        String destination = null;
        
        if("admin".equals(this.type)){
            destination = "/admin/index?faces-redirect=true";
        }else if("charge-production".equals(this.type)){
            destination = "/charge-production/index?faces-redirect=true";
        }else if("charge-suivi".equals(this.type)){
            destination = "/charge-suivi/index?faces-redirect=true";
        }else if("enseignant".equals(this.type)){
            destination = "/enseignant/index?faces-redirect=true";
        }
        
        return destination; // go to destination
    }
}
