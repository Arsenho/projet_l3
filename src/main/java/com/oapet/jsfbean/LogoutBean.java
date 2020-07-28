/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oapet.jsfbean;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Arseme Vadele
 */

@Named(value="logoutBean")
@RequestScoped
public class LogoutBean {
    public static Logger log = Logger.getLogger(LogoutBean.class.getName());
    
    public String logout(){
        String destination = "/index?faces-redirect=true";
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        
        try{
            request.logout();
        }catch(ServletException ex){
            log.log(Level.SEVERE, "Failled to logout user",ex);
            destination = "/loginerror?faces-redirect=true";
        }
        return destination; // go to destination
    }
}
