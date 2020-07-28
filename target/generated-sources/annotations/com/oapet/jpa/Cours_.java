package com.oapet.jpa;

import com.oapet.jpa.Chargeproduction;
import com.oapet.jpa.Enseignant;
import com.oapet.jpa.Filiere;
import com.oapet.jpa.Periode;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-17T17:41:02")
@StaticMetamodel(Cours.class)
public class Cours_ { 

    public static volatile SingularAttribute<Cours, String> instituleCours;
    public static volatile SingularAttribute<Cours, Integer> nbreHeureTp;
    public static volatile SingularAttribute<Cours, Enseignant> idEnseignant;
    public static volatile SingularAttribute<Cours, Integer> nbreHeureTd;
    public static volatile SingularAttribute<Cours, Filiere> idFiliere;
    public static volatile ListAttribute<Cours, Periode> periodeList;
    public static volatile SingularAttribute<Cours, String> codeCours;
    public static volatile SingularAttribute<Cours, Integer> nbreHeureCm;
    public static volatile SingularAttribute<Cours, Chargeproduction> idChargeProduction;

}