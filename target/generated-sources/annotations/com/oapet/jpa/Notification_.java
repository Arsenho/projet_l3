package com.oapet.jpa;

import com.oapet.jpa.Chargeproduction;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-17T17:41:02")
@StaticMetamodel(Notification.class)
public class Notification_ { 

    public static volatile SingularAttribute<Notification, String> pieceJointe;
    public static volatile SingularAttribute<Notification, String> typeNotification;
    public static volatile SingularAttribute<Notification, Integer> idNotification;
    public static volatile SingularAttribute<Notification, String> message;
    public static volatile SingularAttribute<Notification, Chargeproduction> idChargeProduction;

}