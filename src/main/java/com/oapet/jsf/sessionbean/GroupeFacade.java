/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oapet.jsf.sessionbean;

import com.oapet.jpa.Groupe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Arseme
 */
@Stateless
public class GroupeFacade extends AbstractFacade<Groupe> {

    @PersistenceContext(unitName = "oapetPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupeFacade() {
        super(Groupe.class);
    }
    
}
