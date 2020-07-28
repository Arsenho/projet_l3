package com.oapet.jpa;

import com.oapet.jpa.Cours;
import com.oapet.jpa.Emploitemps;
import com.oapet.jpa.Enseignant;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-17T17:41:02")
@StaticMetamodel(Disponibiliteenseignant.class)
public class Disponibiliteenseignant_ { 

    public static volatile SingularAttribute<Disponibiliteenseignant, Date> jour;
    public static volatile SingularAttribute<Disponibiliteenseignant, Enseignant> idEnseignant;
    public static volatile SingularAttribute<Disponibiliteenseignant, Date> heureDebut;
    public static volatile SingularAttribute<Disponibiliteenseignant, Integer> idDisoinibilite;
    public static volatile SingularAttribute<Disponibiliteenseignant, Cours> codeCours;
    public static volatile SingularAttribute<Disponibiliteenseignant, Date> heureFin;
    public static volatile SingularAttribute<Disponibiliteenseignant, Emploitemps> idEmploiTemps;

}