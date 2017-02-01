package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.entity.MenuType;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "menuTypeController")
@ViewScoped
public class MenuTypeController extends AbstractController<MenuType> {

    public MenuTypeController() {
        // Inform the Abstract parent controller of the concrete MenuType Entity
        super(MenuType.class);
    }

    /**
     * Sets the "items" attribute with a collection of MenuOption entities that
     * are retrieved from MenuType?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for MenuOption page
     */
    public String navigateMenuOptionList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MenuOption_items", this.getSelected().getMenuOptionList());
        }
        return "/admin/menuOption/index";
    }

}
