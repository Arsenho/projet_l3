package com.oapet.jpa;

import com.oapet.jpa.Cours;
import com.oapet.jpa.Emploitemps;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-17T17:41:02")
@StaticMetamodel(Periode.class)
public class Periode_ { 

    public static volatile SingularAttribute<Periode, Integer> idPeriode;
    public static volatile SingularAttribute<Periode, String> jour;
    public static volatile SingularAttribute<Periode, String> typeCours;
    public static volatile SingularAttribute<Periode, Date> heureDebut;
    public static volatile SingularAttribute<Periode, Cours> codeCours;
    public static volatile SingularAttribute<Periode, Date> heureFin;
    public static volatile SingularAttribute<Periode, Emploitemps> idEmploiTemps;
    public static volatile SingularAttribute<Periode, Boolean> effectivite;

}