package com.oapet.jpa;

import com.oapet.jpa.Cours;
import com.oapet.jpa.Filiere;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-17T17:41:02")
@StaticMetamodel(Programmecours.class)
public class Programmecours_ { 

    public static volatile SingularAttribute<Programmecours, Filiere> idFiliere;
    public static volatile SingularAttribute<Programmecours, Integer> idProgrammeCours;
    public static volatile SingularAttribute<Programmecours, Cours> codeCours;

}