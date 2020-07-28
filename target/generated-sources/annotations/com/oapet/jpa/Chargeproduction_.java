package com.oapet.jpa;

import com.oapet.jpa.Chargeproduction;
import com.oapet.jpa.Chargesuivi;
import com.oapet.jpa.Contraintehoraire;
import com.oapet.jpa.Cours;
import com.oapet.jpa.Emploitemps;
import com.oapet.jpa.Enseignant;
import com.oapet.jpa.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-17T17:41:02")
@StaticMetamodel(Chargeproduction.class)
public class Chargeproduction_ { 

    public static volatile ListAttribute<Chargeproduction, Enseignant> enseignantList1;
    public static volatile ListAttribute<Chargeproduction, Chargesuivi> chargesuiviList1;
    public static volatile ListAttribute<Chargeproduction, Enseignant> enseignantList;
    public static volatile SingularAttribute<Chargeproduction, Date> dateAjout;
    public static volatile SingularAttribute<Chargeproduction, Chargeproduction> idChargeProductionPeutEtreM;
    public static volatile ListAttribute<Chargeproduction, Chargesuivi> chargesuiviList;
    public static volatile SingularAttribute<Chargeproduction, Integer> idChargeProduction;
    public static volatile ListAttribute<Chargeproduction, Contraintehoraire> contraintehoraireList;
    public static volatile SingularAttribute<Chargeproduction, Date> dateModofication;
    public static volatile ListAttribute<Chargeproduction, Chargeproduction> chargeproductionList;
    public static volatile SingularAttribute<Chargeproduction, Chargeproduction> idChargeProductionAjoute;
    public static volatile ListAttribute<Chargeproduction, Emploitemps> emploitempsList;
    public static volatile ListAttribute<Chargeproduction, Cours> coursList;
    public static volatile ListAttribute<Chargeproduction, Chargeproduction> chargeproductionList1;
    public static volatile SingularAttribute<Chargeproduction, Utilisateur> email;

}