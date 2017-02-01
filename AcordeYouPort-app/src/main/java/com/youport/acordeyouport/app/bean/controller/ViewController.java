package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.entity.View;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "viewController")
@ViewScoped
public class ViewController extends AbstractController<View> {

    @Inject
    private TypeViewController typeViewController;

    public ViewController() {
        // Inform the Abstract parent controller of the concrete View Entity
        super(View.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        typeViewController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TypeView controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTypeView(ActionEvent event) {
        if (this.getSelected() != null && typeViewController.getSelected() == null) {
            typeViewController.setSelected(this.getSelected().getTypeView());
        }
    }

    /**
     * Sets the "items" attribute with a collection of MenuOption entities
     * that are retrieved from View?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for MenuOption page
     */
    public String navigateMenuOptionList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MenuOption_items", this.getSelected().getMenuOptionList());
        }
        return "/admin/MenuOption/index";
    }

}
