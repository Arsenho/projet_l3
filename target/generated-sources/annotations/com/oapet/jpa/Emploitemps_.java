package com.oapet.jpa;

import com.oapet.jpa.Chargeproduction;
import com.oapet.jpa.Chargesuivi;
import com.oapet.jpa.Contraintehoraire;
import com.oapet.jpa.Filiere;
import com.oapet.jpa.Periode;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-17T17:41:02")
@StaticMetamodel(Emploitemps.class)
public class Emploitemps_ { 

    public static volatile SingularAttribute<Emploitemps, Chargesuivi> idChargeSuivi;
    public static volatile SingularAttribute<Emploitemps, Contraintehoraire> idContrainteHoraire;
    public static volatile SingularAttribute<Emploitemps, Date> dateCreation;
    public static volatile SingularAttribute<Emploitemps, Date> dateDebut;
    public static volatile SingularAttribute<Emploitemps, Filiere> idFiliere;
    public static volatile ListAttribute<Emploitemps, Periode> periodeList;
    public static volatile SingularAttribute<Emploitemps, Date> dateFin;
    public static volatile SingularAttribute<Emploitemps, Integer> idEmploiTemps;
    public static volatile SingularAttribute<Emploitemps, Date> dateValidation;
    public static volatile SingularAttribute<Emploitemps, Chargeproduction> idChargeProduction;

}