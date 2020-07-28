package com.oapet.jpa;

import com.oapet.jpa.Chargesuivi;
import com.oapet.jpa.Cours;
import com.oapet.jpa.Emploitemps;
import com.oapet.jpa.Enseignant;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-17T17:41:02")
@StaticMetamodel(Filiere.class)
public class Filiere_ { 

    public static volatile SingularAttribute<Filiere, String> niveauFiliere;
    public static volatile SingularAttribute<Filiere, String> codeFiliere;
    public static volatile SingularAttribute<Filiere, Integer> idFiliere;
    public static volatile ListAttribute<Filiere, Enseignant> enseignantList;
    public static volatile ListAttribute<Filiere, Emploitemps> emploitempsList;
    public static volatile ListAttribute<Filiere, Chargesuivi> chargesuiviList;
    public static volatile ListAttribute<Filiere, Cours> coursList;
    public static volatile SingularAttribute<Filiere, String> instituleFiliere;

}