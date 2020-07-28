package com.oapet.jpa;

import com.oapet.jpa.Chargeproduction;
import com.oapet.jpa.Emploitemps;
import com.oapet.jpa.Filiere;
import com.oapet.jpa.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-17T17:41:02")
@StaticMetamodel(Chargesuivi.class)
public class Chargesuivi_ { 

    public static volatile SingularAttribute<Chargesuivi, Integer> idChargeSuivi;
    public static volatile SingularAttribute<Chargesuivi, String> nature;
    public static volatile SingularAttribute<Chargesuivi, Date> dateModification;
    public static volatile SingularAttribute<Chargesuivi, Filiere> idFiliere;
    public static volatile SingularAttribute<Chargesuivi, Date> dateAjout;
    public static volatile SingularAttribute<Chargesuivi, Chargeproduction> idChargeProductionPeutEtreM;
    public static volatile ListAttribute<Chargesuivi, Emploitemps> emploitempsList;
    public static volatile SingularAttribute<Chargesuivi, Chargeproduction> idChargeProduction;
    public static volatile SingularAttribute<Chargesuivi, Utilisateur> email;

}