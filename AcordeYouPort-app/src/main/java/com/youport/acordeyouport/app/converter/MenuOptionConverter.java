package com.youport.acordeyouport.app.converter;

import com.youport.acordeyouport.app.entity.MenuOption;
import com.youport.acordeyouport.app.facade.MenuOptionFacade;
import com.youport.acordeyouport.app.facade.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "menuOptionConverter")
public class MenuOptionConverter implements Converter {

    @Inject
    private MenuOptionFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    com.youport.acordeyouport.app.entity.MenuOptionPK getKey(String value) {
        com.youport.acordeyouport.app.entity.MenuOptionPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new com.youport.acordeyouport.app.entity.MenuOptionPK();
        key.setIdMenu(Integer.parseInt(values[0]));
        key.setIdView(Integer.parseInt(values[1]));
        key.setIdMenutype(Integer.parseInt(values[2]));
        return key;
    }

    String getStringKey(com.youport.acordeyouport.app.entity.MenuOptionPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdMenu());
        sb.append(SEPARATOR);
        sb.append(value.getIdView());
        sb.append(SEPARATOR);
        sb.append(value.getIdMenutype());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof MenuOption) {
            MenuOption o = (MenuOption) object;
            return getStringKey(o.getMenuOptionPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), MenuOption.class.getName()});
            return null;
        }
    }

}
