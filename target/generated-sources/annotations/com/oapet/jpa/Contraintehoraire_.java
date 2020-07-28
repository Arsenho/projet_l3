package com.oapet.jpa;

import com.oapet.jpa.Chargeproduction;
import com.oapet.jpa.Emploitemps;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-17T17:41:02")
@StaticMetamodel(Contraintehoraire.class)
public class Contraintehoraire_ { 

    public static volatile SingularAttribute<Contraintehoraire, Date> heureDebutPause;
    public static volatile SingularAttribute<Contraintehoraire, Integer> idContrainteHoraire;
    public static volatile SingularAttribute<Contraintehoraire, Date> heureDebutCours;
    public static volatile SingularAttribute<Contraintehoraire, Integer> dureePause;
    public static volatile SingularAttribute<Contraintehoraire, Integer> dureePeriode;
    public static volatile ListAttribute<Contraintehoraire, Emploitemps> emploitempsList;
    public static volatile SingularAttribute<Contraintehoraire, Chargeproduction> idChargeProduction;
    public static volatile SingularAttribute<Contraintehoraire, Date> heureFinCours;

}