package com.oapet.jpa;

import com.oapet.jpa.Chargeproduction;
import com.oapet.jpa.Chargesuivi;
import com.oapet.jpa.Enseignant;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-17T17:41:02")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ { 

    public static volatile SingularAttribute<Utilisateur, String> password;
    public static volatile ListAttribute<Utilisateur, Enseignant> enseignantList;
    public static volatile ListAttribute<Utilisateur, Chargeproduction> chargeproductionList;
    public static volatile SingularAttribute<Utilisateur, BigInteger> telephone;
    public static volatile ListAttribute<Utilisateur, Chargesuivi> chargesuiviList;
    public static volatile SingularAttribute<Utilisateur, String> nom;
    public static volatile SingularAttribute<Utilisateur, String> prenom;
    public static volatile SingularAttribute<Utilisateur, String> email;
    public static volatile SingularAttribute<Utilisateur, String> username;

}