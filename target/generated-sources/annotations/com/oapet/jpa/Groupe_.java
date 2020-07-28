package com.oapet.jpa;

import com.oapet.jpa.Utilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-17T17:41:02")
@StaticMetamodel(Groupe.class)
public class Groupe_ { 

    public static volatile SingularAttribute<Groupe, String> nomGroupe;
    public static volatile SingularAttribute<Groupe, Integer> idGroupe;
    public static volatile ListAttribute<Groupe, Utilisateur> utilisateurList;

}