package com.oapet.jsf.controller;

import com.oapet.jpa.Emploitemps;
import com.oapet.jpa.Periode;
import com.oapet.jsf.controller.util.JsfUtil;
import com.oapet.jsf.controller.util.JsfUtil.PersistAction;
import com.oapet.jsf.sessionbean.EmploitempsFacade;
import com.oapet.jsfbean.Enregistrement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@Named("emploitempsController")
@SessionScoped
public class EmploitempsController implements Serializable {

    @Inject
    PeriodeController periode;
    @Inject
    private ContraintehoraireController contrainteHoraire;

    @EJB
    private com.oapet.jsf.sessionbean.EmploitempsFacade ejbFacade;
    private List<Emploitemps> items = null;
    private Emploitemps selected;

    public EmploitempsController() {
    }

    public PeriodeController getPeriode() {
        return periode;
    }

    public void setPeriode(PeriodeController periode) {
        this.periode = periode;
    }

    public Emploitemps getSelected() {
        return selected;
    }

    public ContraintehoraireController getContrainteHoraire() {
        return contrainteHoraire;
    }

    public void setContrainteHoraire(ContraintehoraireController contrainteHoraire) {
        this.contrainteHoraire = contrainteHoraire;
    }
    
    
    
    public void setSelected(Emploitemps selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EmploitempsFacade getFacade() {
        return ejbFacade;
    }

    public Emploitemps prepareCreate() {
        selected = new Emploitemps();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EmploitempsCreated"));
        //genererPeriodes();
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EmploitempsUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EmploitempsDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Emploitemps> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Emploitemps getEmploitemps(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Emploitemps> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Emploitemps> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(value = "emploitempsConverter")
    public static class EmploitempsControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EmploitempsController controller = (EmploitempsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "emploitempsController");
            return controller.getEmploitemps(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Emploitemps) {
                Emploitemps o = (Emploitemps) object;
                return getStringKey(o.getIdEmploiTemps());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Emploitemps.class.getName()});
                return null;
            }
        }

    }

    public void genererPeriodes() {
        Emploitemps edt = new Emploitemps();
        if(this.selected != null){
            this.create();
        }
        
        edt = this.getEmploitemps(1);
        
        List<DateTime> listej = new ArrayList<DateTime>();
        List<String> listejs = new ArrayList<String>();
        List<DateTime> listeHoraire = new ArrayList<DateTime>();
        listeHoraire = hours();

        Date dateDebut = edt.getDateDebut();
        Date dateFin = edt.getDateFin();
     
        DateTime dd = new DateTime(dateDebut);
        DateTime df = new DateTime(dateFin);

        int vddj = dd.get(DateTimeFieldType.dayOfMonth());
        int vdfj = df.get(DateTimeFieldType.dayOfMonth());

        int vddm = dd.get(DateTimeFieldType.monthOfYear());
        int vdfm = df.get(DateTimeFieldType.monthOfYear());

        int vddy = dd.get(DateTimeFieldType.year());
        int vdfy = df.get(DateTimeFieldType.year());

        if ((vddj < vdfj && vddm <= vdfm) || (vddj > vdfj && vddm < vdfm)) {
            for (int cpt = vddj; cpt <= vdfj; cpt++) {
                DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy");
                DateTime tmp = formatter.parseDateTime(String.valueOf(cpt) + "-" + String.valueOf(vddm) + "-" + String.valueOf(vddy));
                
                DateTime.Property pp = tmp.dayOfWeek();
                
                listej.add(tmp);
                listejs.add(pp.getAsText(Locale.FRENCH));
                
            }
        }
        
        for (int i = 0; i < listej.size(); i++) {
            for (int j = 0; j < listeHoraire.size(); j++) {
                Periode p = new Periode();
                p.setIdEmploiTemps(edt);
                p.setHeureDebut(listeHoraire.get(j).toDate());
                p.setHeureFin(listeHoraire.get(j).toDate());
                p.setJour(listejs.get(i));
                
                this.getPeriode().setSelected(p);
                this.getPeriode().create();
            }
        }
        

    }
    
    public List<DateTime> hours() {
        List<DateTime> horaires = new ArrayList<DateTime>();
        
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


        for (int cpt = deb; cpt <= fin; cpt++) {
            DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm:ss");
            DateTime dateTime = formatter.parseDateTime(String.valueOf(cpt) + ":00:00");

            horaires.add(dateTime);

        }
         return horaires;
    }
    
}
 