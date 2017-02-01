package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.entity.Contact;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "contactController")
@ViewScoped
public class ContactController extends AbstractController<Contact> {

    @Inject
    private CompanyController idCompanyController;

    public ContactController() {
        // Inform the Abstract parent controller of the concrete Contact Entity
        super(Contact.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idCompanyController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Company controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCompany(ActionEvent event) {
        if (this.getSelected() != null && idCompanyController.getSelected() == null) {
            idCompanyController.setSelected(this.getSelected().getIdCompany());
        }
    }
}
