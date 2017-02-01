package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.entity.Theme;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "themeController")
@ViewScoped
public class ThemeController extends AbstractController<Theme> {

    public ThemeController() {
        // Inform the Abstract parent controller of the concrete Theme Entity
        super(Theme.class);
    }

    /**
     * Sets the "items" attribute with a collection of Company entities that are
     * retrieved from Theme?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Company page
     */
    public String navigateCompanyList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Company_items", this.getSelected().getCompanyList());
        }
        return "/admin/company/index";
    }

}
