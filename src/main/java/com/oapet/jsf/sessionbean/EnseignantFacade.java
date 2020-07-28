/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oapet.jsf.sessionbean;

import com.oapet.jpa.Enseignant;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Arseme
 */
@Stateless
public class EnseignantFacade extends AbstractFacade<Enseignant> {

    @PersistenceContext(unitName = "oapetPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnseignantFacade() {
        super(Enseignant.class);
    }
    
}
