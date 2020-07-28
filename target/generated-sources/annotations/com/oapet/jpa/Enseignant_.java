package com.oapet.jpa;

import com.oapet.jpa.Chargeproduction;
import com.oapet.jpa.Cours;
import com.oapet.jpa.Filiere;
import com.oapet.jpa.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-17T17:41:02")
@StaticMetamodel(Enseignant.class)
public class Enseignant_ { 

    public static volatile SingularAttribute<Enseignant, Chargeproduction> idChargeProductionModifier;
    public static volatile SingularAttribute<Enseignant, Integer> idEnseignant;
    public static volatile SingularAttribute<Enseignant, Date> dateModification;
    public static volatile SingularAttribute<Enseignant, Date> dateAjout;
    public static volatile ListAttribute<Enseignant, Cours> coursList;
    public static volatile ListAttribute<Enseignant, Filiere> filiereList;
    public static volatile SingularAttribute<Enseignant, Chargeproduction> idChargeProduction;
    public static volatile SingularAttribute<Enseignant, Utilisateur> email;

}