package com.oapet.jsf.controller;

import com.oapet.jpa.Disponibiliteenseignant;
import com.oapet.jsf.controller.util.JsfUtil;
import com.oapet.jsf.controller.util.JsfUtil.PersistAction;
import com.oapet.jsf.sessionbean.DisponibiliteenseignantFacade;

import java.io.Serializable;
import java.util.List;
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

@Named("disponibiliteenseignantController")
@SessionScoped
public class DisponibiliteenseignantController implements Serializable {

    @EJB
    private com.oapet.jsf.sessionbean.DisponibiliteenseignantFacade ejbFacade;
    private List<Disponibiliteenseignant> items = null;
    private Disponibiliteenseignant selected;

    public DisponibiliteenseignantController() {
    }

    public Disponibiliteenseignant getSelected() {
        return selected;
    }

    public void setSelected(Disponibiliteenseignant selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DisponibiliteenseignantFacade getFacade() {
        return ejbFacade;
    }

    public Disponibiliteenseignant prepareCreate() {
        selected = new Disponibiliteenseignant();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DisponibiliteenseignantCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DisponibiliteenseignantUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DisponibiliteenseignantDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Disponibiliteenseignant> getItems() {
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

    public Disponibiliteenseignant getDisponibiliteenseignant(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Disponibiliteenseignant> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Disponibiliteenseignant> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(value = "disponibiliteenseignantConverter")
    public static class DisponibiliteenseignantControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DisponibiliteenseignantController controller = (DisponibiliteenseignantController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "disponibiliteenseignantController");
            return controller.getDisponibiliteenseignant(getKey(value));
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
            if (object instanceof Disponibiliteenseignant) {
                Disponibiliteenseignant o = (Disponibiliteenseignant) object;
                return getStringKey(o.getIdDisoinibilite());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Disponibiliteenseignant.class.getName()});
                return null;
            }
        }

    }

}
