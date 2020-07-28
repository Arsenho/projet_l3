-- -----------------------------------------------------------------------------
--             Génération d'une base de données pour
--                           PostgreSQL
--                        (4/7/2019 19:26:10)
-- -----------------------------------------------------------------------------
--      Nom de la base : oapet
--      Projet : 
--      Auteur : WinDesign
--      Date de dernière modification : 4/7/2019 19:23:27
-- -----------------------------------------------------------------------------

drop database oapet;
-- -----------------------------------------------------------------------------
--       CREATION DE LA BASE 
-- -----------------------------------------------------------------------------

CREATE DATABASE oapet;

-- -----------------------------------------------------------------------------
--       TABLE : NOTIFICATION
-- -----------------------------------------------------------------------------

CREATE TABLE NOTIFICATION
   (
    ID_NOTIFICATION serial NOT NULL  ,
    ID_CHARGE_PRODUCTION int4 NOT NULL  ,
    TYPE_NOTIFICATION varchar(128) NOT NULL  ,
    MESSAGE varchar(128) NULL  ,
    PIECE_JOINTE varchar(128) NULL  
,   CONSTRAINT PK_NOTIFICATION PRIMARY KEY (ID_NOTIFICATION)
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE NOTIFICATION
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_NOTIFICATION_CHARGEPRODUC
     ON NOTIFICATION (ID_CHARGE_PRODUCTION)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : CONTRAINTEHORAIRE
-- -----------------------------------------------------------------------------

CREATE TABLE CONTRAINTEHORAIRE
   (
    ID_CONTRAINTE_HORAIRE serial NOT NULL  ,
    ID_CHARGE_PRODUCTION int4 NOT NULL  ,
    HEURE_DEBUT_COURS time(4) NOT NULL  ,
    HEURE_FIN_COURS time(4) NOT NULL  ,
    DUREE_PERIODE int8 NULL  ,
    HEURE_DEBUT_PAUSE int8 NULL  ,
    DUREE_PAUSE int8 NULL  
,   CONSTRAINT PK_CONTRAINTEHORAIRE PRIMARY KEY (ID_CONTRAINTE_HORAIRE)
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE CONTRAINTEHORAIRE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_CONTRAINTEHORAIRE_CHARGEP
     ON CONTRAINTEHORAIRE (ID_CHARGE_PRODUCTION)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : UTILISATEUR
-- -----------------------------------------------------------------------------

CREATE TABLE UTILISATEUR
   (
    ID_UTILISATEUR serial NULL  ,
    NOM varchar(128) NOT NULL  ,
    PRENOM varchar(128) NOT NULL  ,
    TELEPHONE int8 NULL  ,
    EMAIL varchar(128) NOT NULL  ,
    USERNAME varchar(128) NULL  ,
    PASSWORD varchar(128) NULL  
,   CONSTRAINT PK_UTILISATEUR PRIMARY KEY (EMAIL)
   );

-- -----------------------------------------------------------------------------
--       TABLE : CHARGEPRODUCTION
-- -----------------------------------------------------------------------------

CREATE TABLE CHARGEPRODUCTION
   (
    ID_CHARGE_PRODUCTION serial NOT NULL  ,
    ID_CHARGE_PRODUCTION_PEUT_ETRE_M int4 NOT NULL  ,
    ID_CHARGE_PRODUCTION_AJOUTE int4 NOT NULL  ,
    EMAIL varchar(128) NOT NULL  ,
    DATE_AJOUT timestamp(12) NULL  ,
    DATE_MODOFICATION timestamp(12) NULL  
,   CONSTRAINT PK_CHARGEPRODUCTION PRIMARY KEY (ID_CHARGE_PRODUCTION)
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE CHARGEPRODUCTION
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_CHARGEPRODUCTION_CHARGEPR
     ON CHARGEPRODUCTION (ID_CHARGE_PRODUCTION_PEUT_ETRE_M)
    ;

CREATE  INDEX I_FK_CHARGEPRODUCTION_CHARGEP1
     ON CHARGEPRODUCTION (ID_CHARGE_PRODUCTION_AJOUTE)
    ;

CREATE  INDEX I_FK_CHARGEPRODUCTION_UTILISAT
     ON CHARGEPRODUCTION (EMAIL)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : GROUPE
-- -----------------------------------------------------------------------------

CREATE TABLE GROUPE
   (
    ID_GROUPE serial NULL  ,
    NOM_GROUPE varchar(128) NOT NULL  
,   CONSTRAINT PK_GROUPE PRIMARY KEY (NOM_GROUPE)
   );

-- -----------------------------------------------------------------------------
--       TABLE : PERIODE
-- -----------------------------------------------------------------------------

CREATE TABLE PERIODE
   (
    ID_PERIODE serial NOT NULL  ,
    CODE_COURS char(32) NOT NULL  ,
    ID_EMPLOI_TEMPS int8 NOT NULL  ,
    HEURE_DEBUT time(4) NOT NULL  ,
    HEURE_FIN time(4) NOT NULL  ,
    TYPE_COURS varchar(128) NOT NULL  ,
    EFFECTIVITE bool(1) NULL  
,   CONSTRAINT PK_PERIODE PRIMARY KEY (ID_PERIODE)
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE PERIODE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_PERIODE_COURS
     ON PERIODE (CODE_COURS)
    ;

CREATE  INDEX I_FK_PERIODE_EMPLOITEMPS
     ON PERIODE (ID_EMPLOI_TEMPS)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : PROGRAMMECOURS
-- -----------------------------------------------------------------------------

CREATE TABLE PROGRAMMECOURS
   (
    ID_PROGRAMME_COURS serial NOT NULL  ,
    CODE_COURS char(32) NOT NULL  ,
    ID_FILIERE int8 NOT NULL  
,   CONSTRAINT PK_PROGRAMMECOURS PRIMARY KEY (ID_PROGRAMME_COURS)
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE PROGRAMMECOURS
-- -----------------------------------------------------------------------------

CREATE UNIQUE INDEX I_FK_PROGRAMMECOURS_COURS
     ON PROGRAMMECOURS (CODE_COURS)
    ;

CREATE UNIQUE INDEX I_FK_PROGRAMMECOURS_FILIERE
     ON PROGRAMMECOURS (ID_FILIERE)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : DISPONIBILITEENSEIGNANT
-- -----------------------------------------------------------------------------

CREATE TABLE DISPONIBILITEENSEIGNANT
   (
    ID_DISOINIBILITE serial NOT NULL  ,
    ID_ENSEIGNANT int8 NOT NULL  ,
    CODE_COURS char(32) NOT NULL  ,
    ID_EMPLOI_TEMPS int8 NOT NULL  ,
    JOUR date(8) NOT NULL  ,
    HEURE_DEBUT time(4) NOT NULL  ,
    HEURE_FIN time(4) NOT NULL  
,   CONSTRAINT PK_DISPONIBILITEENSEIGNANT PRIMARY KEY (ID_DISOINIBILITE)
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE DISPONIBILITEENSEIGNANT
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_DISPONIBILITEENSEIGNANT_E
     ON DISPONIBILITEENSEIGNANT (ID_ENSEIGNANT)
    ;

CREATE  INDEX I_FK_DISPONIBILITEENSEIGNANT_C
     ON DISPONIBILITEENSEIGNANT (CODE_COURS)
    ;

CREATE  INDEX I_FK_DISPONIBILITEENSEIGNANT_1
     ON DISPONIBILITEENSEIGNANT (ID_EMPLOI_TEMPS)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : EMPLOITEMPS
-- -----------------------------------------------------------------------------

CREATE TABLE EMPLOITEMPS
   (
    ID_EMPLOI_TEMPS serial NOT NULL  ,
    ID_CONTRAINTE_HORAIRE int8 NOT NULL  ,
    ID_CHARGE_SUIVI int8 NOT NULL  ,
    ID_CHARGE_PRODUCTION int4 NOT NULL  ,
    DATE_DEBUT date(8) NOT NULL  ,
    DATE_FIN date(8) NOT NULL  ,
    DATE_CREATION timestamp(12) NULL  ,
    DATE_VALIDATION timestamp(12) NULL  
,   CONSTRAINT PK_EMPLOITEMPS PRIMARY KEY (ID_EMPLOI_TEMPS)
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE EMPLOITEMPS
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_EMPLOITEMPS_CONTRAINTEHOR
     ON EMPLOITEMPS (ID_CONTRAINTE_HORAIRE)
    ;

CREATE  INDEX I_FK_EMPLOITEMPS_CHARGESUIVI
     ON EMPLOITEMPS (ID_CHARGE_SUIVI)
    ;

CREATE  INDEX I_FK_EMPLOITEMPS_CHARGEPRODUCT
     ON EMPLOITEMPS (ID_CHARGE_PRODUCTION)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : CONTRAINTEGENAUTO
-- -----------------------------------------------------------------------------

CREATE TABLE CONTRAINTEGENAUTO
   (
    ID_CONTAINTE_GEN_AUTO serial NOT NULL  ,
    ID_EMPLOI_TEMPS int8 NULL  ,
    ID_CHARGE_PRODUCTION int4 NOT NULL  ,
    PRIORITE_FIFO bool(1) NULL  ,
    PRIORITE__RETARD_CM bool(1) NULL  ,
    PRIORITE_RETARDT_D bool(1) NULL  ,
    PRIORITE_RETARD_TP bool(1) NULL  
,   CONSTRAINT PK_CONTRAINTEGENAUTO PRIMARY KEY (ID_CONTAINTE_GEN_AUTO)
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE CONTRAINTEGENAUTO
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_CONTRAINTEGENAUTO_EMPLOIT
     ON CONTRAINTEGENAUTO (ID_EMPLOI_TEMPS)
    ;

CREATE  INDEX I_FK_CONTRAINTEGENAUTO_CHARGEP
     ON CONTRAINTEGENAUTO (ID_CHARGE_PRODUCTION)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : CHARGESUIVI
-- -----------------------------------------------------------------------------

CREATE TABLE CHARGESUIVI
   (
    ID_CHARGE_SUIVI serial NOT NULL  ,
    ID_CHARGE_PRODUCTION int4 NOT NULL  ,
    ID_FILIERE int8 NOT NULL  ,
    ID_CHARGE_PRODUCTION_PEUT_ETRE_M int4 NOT NULL  ,
    EMAIL varchar(128) NOT NULL  ,
    NATURE varchar(128) NULL  ,
    DATE_AJOUT timestamp(12) NOT NULL  ,
    DATE_MODIFICATION timestamp(12) NOT NULL  
,   CONSTRAINT PK_CHARGESUIVI PRIMARY KEY (ID_CHARGE_SUIVI)
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE CHARGESUIVI
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_CHARGESUIVI_CHARGEPRODUCT
     ON CHARGESUIVI (ID_CHARGE_PRODUCTION)
    ;

CREATE  INDEX I_FK_CHARGESUIVI_FILIERE
     ON CHARGESUIVI (ID_FILIERE)
    ;

CREATE  INDEX I_FK_CHARGESUIVI_CHARGEPRODUC1
     ON CHARGESUIVI (ID_CHARGE_PRODUCTION_PEUT_ETRE_M)
    ;

CREATE  INDEX I_FK_CHARGESUIVI_UTILISATEUR
     ON CHARGESUIVI (EMAIL)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : FILIERE
-- -----------------------------------------------------------------------------

CREATE TABLE FILIERE
   (
    ID_FILIERE serial NOT NULL  ,
    CODE_FILIERE char(32) NULL  ,
    INSTITULE_FILIERE varchar(128) NOT NULL  ,
    NIVEAU_FILIERE char(32) NOT NULL  
,   CONSTRAINT PK_FILIERE PRIMARY KEY (ID_FILIERE)
   );

-- -----------------------------------------------------------------------------
--       TABLE : ENSEIGNANT
-- -----------------------------------------------------------------------------

CREATE TABLE ENSEIGNANT
   (
    ID_ENSEIGNANT serial NOT NULL  ,
    ID_CHARGE_PRODUCTION int4 NOT NULL  ,
    ID_CHARGE_PRODUCTION_MODIFIER int4 NOT NULL  ,
    EMAIL varchar(128) NOT NULL  ,
    DATE_AJOUT timestamp(12) NULL  ,
    DATE_MODIFICATION timestamp(12) NULL  
,   CONSTRAINT PK_ENSEIGNANT PRIMARY KEY (ID_ENSEIGNANT)
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE ENSEIGNANT
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_ENSEIGNANT_CHARGEPRODUCTI
     ON ENSEIGNANT (ID_CHARGE_PRODUCTION)
    ;

CREATE  INDEX I_FK_ENSEIGNANT_CHARGEPRODUCT1
     ON ENSEIGNANT (ID_CHARGE_PRODUCTION_MODIFIER)
    ;

CREATE  INDEX I_FK_ENSEIGNANT_UTILISATEUR
     ON ENSEIGNANT (EMAIL)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : COURS
-- -----------------------------------------------------------------------------

CREATE TABLE COURS
   (
    CODE_COURS char(32) NOT NULL  ,
    ID_ENSEIGNANT int8 NOT NULL  ,
    ID_FILIERE int8 NOT NULL  ,
    ID_CHARGE_PRODUCTION int4 NOT NULL  ,
    INSTITULE_COURS varchar(128) NOT NULL  ,
    NBRE_HEURE_CM int2 NOT NULL  ,
    NBRE_HEURE_TD int2 NOT NULL  ,
    NBRE_HEURE_TP int2 NOT NULL  
,   CONSTRAINT PK_COURS PRIMARY KEY (CODE_COURS)
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE COURS
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_COURS_ENSEIGNANT
     ON COURS (ID_ENSEIGNANT)
    ;

CREATE  INDEX I_FK_COURS_FILIERE
     ON COURS (ID_FILIERE)
    ;

CREATE  INDEX I_FK_COURS_CHARGEPRODUCTION
     ON COURS (ID_CHARGE_PRODUCTION)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : USERS_APPARTENIR_GROUP
-- -----------------------------------------------------------------------------

CREATE TABLE USERS_APPARTENIR_GROUP
   (
    EMAIL varchar(128) NOT NULL  ,
    NOM_GROUPE varchar(128) NOT NULL  
,   CONSTRAINT PK_USERS_APPARTENIR_GROUP PRIMARY KEY (EMAIL, NOM_GROUPE)
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE USERS_APPARTENIR_GROUP
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_USERS_APPARTENIR_GROUP_UT
     ON USERS_APPARTENIR_GROUP (EMAIL)
    ;

CREATE  INDEX I_FK_USERS_APPARTENIR_GROUP_GR
     ON USERS_APPARTENIR_GROUP (NOM_GROUPE)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : ENSEIGNANT_APPARTENIR_FILIERE
-- -----------------------------------------------------------------------------

CREATE TABLE ENSEIGNANT_APPARTENIR_FILIERE
   (
    ID_FILIERE int8 NOT NULL  ,
    ID_ENSEIGNANT int8 NOT NULL  
,   CONSTRAINT PK_ENSEIGNANT_APPARTENIR_FILIERE PRIMARY KEY (ID_FILIERE, ID_ENSEIGNANT)
   );

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE ENSEIGNANT_APPARTENIR_FILIERE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_ENSEIGNANT_APPARTENIR_FIL
     ON ENSEIGNANT_APPARTENIR_FILIERE (ID_FILIERE)
    ;

CREATE  INDEX I_FK_ENSEIGNANT_APPARTENIR_FI1
     ON ENSEIGNANT_APPARTENIR_FILIERE (ID_ENSEIGNANT)
    ;


-- -----------------------------------------------------------------------------
--       CREATION DES REFERENCES DE TABLE
-- -----------------------------------------------------------------------------


ALTER TABLE NOTIFICATION ADD 
     CONSTRAINT FK_NOTIFICATION_CHARGEPRODUCTION
          FOREIGN KEY (ID_CHARGE_PRODUCTION)
               REFERENCES CHARGEPRODUCTION (ID_CHARGE_PRODUCTION);

ALTER TABLE CONTRAINTEHORAIRE ADD 
     CONSTRAINT FK_CONTRAINTEHORAIRE_CHARGEPRODU
          FOREIGN KEY (ID_CHARGE_PRODUCTION)
               REFERENCES CHARGEPRODUCTION (ID_CHARGE_PRODUCTION);

ALTER TABLE CHARGEPRODUCTION ADD 
     CONSTRAINT FK_CHARGEPRODUCTION_CHARGEPRODUC
          FOREIGN KEY (ID_CHARGE_PRODUCTION_PEUT_ETRE_M)
               REFERENCES CHARGEPRODUCTION (ID_CHARGE_PRODUCTION);

ALTER TABLE CHARGEPRODUCTION ADD 
     CONSTRAINT FK_CHARGEPRODUCTION_CHARGEPRODU1
          FOREIGN KEY (ID_CHARGE_PRODUCTION_AJOUTE)
               REFERENCES CHARGEPRODUCTION (ID_CHARGE_PRODUCTION);

ALTER TABLE CHARGEPRODUCTION ADD 
     CONSTRAINT FK_CHARGEPRODUCTION_UTILISATEUR
          FOREIGN KEY (EMAIL)
               REFERENCES UTILISATEUR (EMAIL);

ALTER TABLE PERIODE ADD 
     CONSTRAINT FK_PERIODE_COURS
          FOREIGN KEY (CODE_COURS)
               REFERENCES COURS (CODE_COURS);

ALTER TABLE PERIODE ADD 
     CONSTRAINT FK_PERIODE_EMPLOITEMPS
          FOREIGN KEY (ID_EMPLOI_TEMPS)
               REFERENCES EMPLOITEMPS (ID_EMPLOI_TEMPS);

ALTER TABLE PROGRAMMECOURS ADD 
     CONSTRAINT FK_PROGRAMMECOURS_COURS
          FOREIGN KEY (CODE_COURS)
               REFERENCES COURS (CODE_COURS);

ALTER TABLE PROGRAMMECOURS ADD 
     CONSTRAINT FK_PROGRAMMECOURS_FILIERE
          FOREIGN KEY (ID_FILIERE)
               REFERENCES FILIERE (ID_FILIERE);

ALTER TABLE DISPONIBILITEENSEIGNANT ADD 
     CONSTRAINT FK_DISPONIBILITEENSEIGNANT_ENSEI
          FOREIGN KEY (ID_ENSEIGNANT)
               REFERENCES ENSEIGNANT (ID_ENSEIGNANT);

ALTER TABLE DISPONIBILITEENSEIGNANT ADD 
     CONSTRAINT FK_DISPONIBILITEENSEIGNANT_COURS
          FOREIGN KEY (CODE_COURS)
               REFERENCES COURS (CODE_COURS);

ALTER TABLE DISPONIBILITEENSEIGNANT ADD 
     CONSTRAINT FK_DISPONIBILITEENSEIGNANT_EMPLO
          FOREIGN KEY (ID_EMPLOI_TEMPS)
               REFERENCES EMPLOITEMPS (ID_EMPLOI_TEMPS);

ALTER TABLE EMPLOITEMPS ADD 
     CONSTRAINT FK_EMPLOITEMPS_CONTRAINTEHORAIRE
          FOREIGN KEY (ID_CONTRAINTE_HORAIRE)
               REFERENCES CONTRAINTEHORAIRE (ID_CONTRAINTE_HORAIRE);

ALTER TABLE EMPLOITEMPS ADD 
     CONSTRAINT FK_EMPLOITEMPS_CHARGESUIVI
          FOREIGN KEY (ID_CHARGE_SUIVI)
               REFERENCES CHARGESUIVI (ID_CHARGE_SUIVI);

ALTER TABLE EMPLOITEMPS ADD 
     CONSTRAINT FK_EMPLOITEMPS_CHARGEPRODUCTION
          FOREIGN KEY (ID_CHARGE_PRODUCTION)
               REFERENCES CHARGEPRODUCTION (ID_CHARGE_PRODUCTION);

ALTER TABLE CONTRAINTEGENAUTO ADD 
     CONSTRAINT FK_CONTRAINTEGENAUTO_EMPLOITEMPS
          FOREIGN KEY (ID_EMPLOI_TEMPS)
               REFERENCES EMPLOITEMPS (ID_EMPLOI_TEMPS);

ALTER TABLE CONTRAINTEGENAUTO ADD 
     CONSTRAINT FK_CONTRAINTEGENAUTO_CHARGEPRODU
          FOREIGN KEY (ID_CHARGE_PRODUCTION)
               REFERENCES CHARGEPRODUCTION (ID_CHARGE_PRODUCTION);

ALTER TABLE CHARGESUIVI ADD 
     CONSTRAINT FK_CHARGESUIVI_CHARGEPRODUCTION
          FOREIGN KEY (ID_CHARGE_PRODUCTION)
               REFERENCES CHARGEPRODUCTION (ID_CHARGE_PRODUCTION);

ALTER TABLE CHARGESUIVI ADD 
     CONSTRAINT FK_CHARGESUIVI_FILIERE
          FOREIGN KEY (ID_FILIERE)
               REFERENCES FILIERE (ID_FILIERE);

ALTER TABLE CHARGESUIVI ADD 
     CONSTRAINT FK_CHARGESUIVI_CHARGEPRODUCTION1
          FOREIGN KEY (ID_CHARGE_PRODUCTION_PEUT_ETRE_M)
               REFERENCES CHARGEPRODUCTION (ID_CHARGE_PRODUCTION);

ALTER TABLE CHARGESUIVI ADD 
     CONSTRAINT FK_CHARGESUIVI_UTILISATEUR
          FOREIGN KEY (EMAIL)
               REFERENCES UTILISATEUR (EMAIL);

ALTER TABLE ENSEIGNANT ADD 
     CONSTRAINT FK_ENSEIGNANT_CHARGEPRODUCTION
          FOREIGN KEY (ID_CHARGE_PRODUCTION)
               REFERENCES CHARGEPRODUCTION (ID_CHARGE_PRODUCTION);

ALTER TABLE ENSEIGNANT ADD 
     CONSTRAINT FK_ENSEIGNANT_CHARGEPRODUCTION1
          FOREIGN KEY (ID_CHARGE_PRODUCTION_MODIFIER)
               REFERENCES CHARGEPRODUCTION (ID_CHARGE_PRODUCTION);

ALTER TABLE ENSEIGNANT ADD 
     CONSTRAINT FK_ENSEIGNANT_UTILISATEUR
          FOREIGN KEY (EMAIL)
               REFERENCES UTILISATEUR (EMAIL);

ALTER TABLE COURS ADD 
     CONSTRAINT FK_COURS_ENSEIGNANT
          FOREIGN KEY (ID_ENSEIGNANT)
               REFERENCES ENSEIGNANT (ID_ENSEIGNANT);

ALTER TABLE COURS ADD 
     CONSTRAINT FK_COURS_FILIERE
          FOREIGN KEY (ID_FILIERE)
               REFERENCES FILIERE (ID_FILIERE);

ALTER TABLE COURS ADD 
     CONSTRAINT FK_COURS_CHARGEPRODUCTION
          FOREIGN KEY (ID_CHARGE_PRODUCTION)
               REFERENCES CHARGEPRODUCTION (ID_CHARGE_PRODUCTION);

ALTER TABLE USERS_APPARTENIR_GROUP ADD 
     CONSTRAINT FK_USERS_APPARTENIR_GROUP_UTILIS
          FOREIGN KEY (EMAIL)
               REFERENCES UTILISATEUR (EMAIL);

ALTER TABLE USERS_APPARTENIR_GROUP ADD 
     CONSTRAINT FK_USERS_APPARTENIR_GROUP_GROUPE
          FOREIGN KEY (NOM_GROUPE)
               REFERENCES GROUPE (NOM_GROUPE);

ALTER TABLE ENSEIGNANT_APPARTENIR_FILIERE ADD 
     CONSTRAINT FK_ENSEIGNANT_APPARTENIR_FILIERE
          FOREIGN KEY (ID_FILIERE)
               REFERENCES FILIERE (ID_FILIERE);

ALTER TABLE ENSEIGNANT_APPARTENIR_FILIERE ADD 
     CONSTRAINT FK_ENSEIGNANT_APPARTENIR_FILIER1
          FOREIGN KEY (ID_ENSEIGNANT)
               REFERENCES ENSEIGNANT (ID_ENSEIGNANT);


-- -----------------------------------------------------------------------------
--                FIN DE GENERATION
-- -----------------------------------------------------------------------------