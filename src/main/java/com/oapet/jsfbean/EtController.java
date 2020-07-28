/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oapet.jsfbean;

import com.oapet.jpa.Contraintehoraire;
import com.oapet.jpa.Cours;
import com.oapet.jpa.Emploitemps;
import com.oapet.jpa.Filiere;
import com.oapet.jpa.Periode;
import com.oapet.jsf.controller.ContraintehoraireController;
import com.oapet.jsf.controller.CoursController;
import com.oapet.jsf.controller.EmploitempsController;
import com.oapet.jsf.controller.PeriodeController;
import com.oapet.jsf.sessionbean.ContraintehoraireFacade;
import com.oapet.jsf.sessionbean.EmploitempsFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIColumn;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Arseme
 */
@Named("etController")
@SessionScoped
public class EtController implements Serializable {

    @Inject
    private CoursController cc;
    @Inject
    private ContraintehoraireController contrainteHoraire;
    @Inject
    private PeriodeController periodeC;
    @Inject
    private  Enregistrement enreg;
    @Inject
    private  EmploitempsController emploitemps;
    
    private List<Periode> listePeriode;
    private List<String> colones;
    private Filiere filiere;
    private String typeCours;
    private DateTime periode;
    private Cours cours;
    private List<DateTime> heures;

    private List<Enregistrement> listeEnregistrement;
    private Enregistrement ligne1;

    @PostConstruct
    public void init() {
        // You can do here your initialization thing based on managed properties, if necessary.
        listeEnregistrement = new ArrayList<Enregistrement>();
        colones = new ArrayList<String>();
        
        listePeriode = getPeriodeC().getItems();
        
        System.out.println(getCc().getItems());
        
        define();
        
        colones.add("lundi");
        colones.add("mardi");
        colones.add("mercredi");
        colones.add("jeudi");
        colones.add("vendredi");
        colones.add("samedi");
    }

    public PeriodeController getPeriodeC() {
        return periodeC;
    }

    public void setPeriodeC(PeriodeController periodeC) {
        this.periodeC = periodeC;
    }

    public EmploitempsController getEmploitemps() {
        return emploitemps;
    }

    public void setEmploitemps(EmploitempsController emploitemps) {
        this.emploitemps = emploitemps;
    }
    
    
    
    public CoursController getCc() {
        return cc;
    }

    public void setCc(CoursController cc) {
        this.cc = cc;
    }

    public List<String> getColones() {
        return colones;
    }

    public void setColones(List<String> colones) {
        this.colones = colones;
    }

   
    public String getTypeCours() {
        return typeCours;
    }

    public void setTypeCours(String typeCours) {
        this.typeCours = typeCours;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

   
    public List<Periode> getListePeriode() {
        return listePeriode;
    }

    public void setListePeriode(List<Periode> listePeriode) {
        this.listePeriode = listePeriode;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public DateTime getPeriode() {
        return periode;
    }

    public void setPeriode(DateTime periode) {
        this.periode = periode;
    }

    public List<Enregistrement> getListeEnregistrement() {
        return listeEnregistrement;
    }

    public void setListeEnregistrement(List<Enregistrement> listeEnregistrement) {
        this.listeEnregistrement = listeEnregistrement;
    }

    public void setHeures(List<DateTime> heures) {

        this.heures = heures;
    }

    public Enregistrement getLigne1() {
        return ligne1;
    }

    public void setLigne1(Enregistrement ligne1) {
        this.ligne1 = ligne1;
    }

    public ContraintehoraireController getContrainteHoraire() {
        return contrainteHoraire;
    }

    public void setContrainteHoraire(ContraintehoraireController contrainteHoraire) {
        this.contrainteHoraire = contrainteHoraire;
    }

    
    
    public void define() {
        Date dateHeureDebut = this.getContrainteHoraire().getContraintehoraire(1).getHeureDebutCours();
        Date dateHeureFin = this.getContrainteHoraire().getContraintehoraire(1).getHeureFinCours();
        //Integer dureePause = this.getContrainteHoraire().getContraintehoraire(1).getDureePause();

        DateTime customDateTimeDateHeureDebut = new DateTime(dateHeureDebut);
        DateTime customDateTimeDateHeureFin = new DateTime(dateHeureFin);
        DateTime customDateTimeDureePeriode = new DateTime("2018-05-05T1:00:00");

        LocalTime heureDebut = customDateTimeDateHeureDebut.toLocalTime();
        LocalTime heureFin = customDateTimeDateHeureFin.toLocalTime();
        LocalTime dureePeriode = customDateTimeDureePeriode.toLocalTime();

        int deb = heureDebut.get(DateTimeFieldType.hourOfDay());
        int fin = heureFin.get(DateTimeFieldType.hourOfDay());
        int duree = dureePeriode.get(DateTimeFieldType.hourOfDay());

        System.out.println(deb);
        System.out.println(fin);
        System.out.println(duree);

        int inter = fin;

        for (int cpt = deb; cpt <= fin; cpt++) {
            DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm:ss");
            DateTime dateTime = formatter.parseDateTime(String.valueOf(cpt) + ":00:00");

            Enregistrement ligne = new Enregistrement();
            ligne.setPeriode(dateTime.toDate());
            
            List<Periode> listePeriodeByEdt = listePeriodeByEdt(emploitemps.getEmploitemps(1));
            List<Periode> listePeriodeByHours = listePeriodeByHours(listePeriodeByEdt,dateTime.toDate());
            
            ligne.setLundi(listePeriodeByDay(listePeriodeByHours,"lundi"));
            ligne.setMardi(listePeriodeByDay(listePeriodeByHours,"mardi"));
            ligne.setMercredi(listePeriodeByDay(listePeriodeByHours,"mercredi"));
            ligne.setJeudi(listePeriodeByDay(listePeriodeByHours,"jeudi"));
            ligne.setVendredi(listePeriodeByDay(listePeriodeByHours,"vendredi"));
            ligne.setSamedi(listePeriodeByDay(listePeriodeByHours,"samedi"));
            
            listeEnregistrement.add(ligne);
        }
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Edited", ((Periode) event.getObject()).getTypeCours());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Periode) event.getObject()).getTypeCours());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Periode newValue =(Periode) event.getNewValue();
        
        System.out.println( newValue.getCodeCours().getCodeCours());

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public List<Periode> listePeriodeByEdt(Emploitemps edt){
        List<Periode> listePeriodeByEdt = new ArrayList<Periode>();
        
        for (Periode periode : listePeriode) {
            if(periode.getIdEmploiTemps().equals(edt)){
                listePeriodeByEdt.add(periode);
            }
        }
        
        return listePeriodeByEdt;
    }
    
    public List<Periode> listePeriodeByHours(List<Periode> listePeriodeByEdt,Date heure){
        List<Periode> listePeriodeByHours = new ArrayList<Periode>();
        for (Periode periode : listePeriodeByEdt) {
            if(periode.getHeureDebut().equals(heure)){
                listePeriodeByHours.add(periode);
            }
        }
        return listePeriodeByHours;
    }
    
    public Periode listePeriodeByDay(List<Periode> listePeriodeByHours, String jour){
        Periode listePeriodeByDay = new Periode();
        for (Periode periode : listePeriodeByHours) {
            if(periode.getJour().equals(jour)){
                listePeriodeByDay = periode;
            }
        }
        return listePeriodeByDay;
    }
}
