package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.entity.ServicesCompany;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "servicesCompanyController")
@ViewScoped
public class ServicesCompanyController extends AbstractController<ServicesCompany> {

    @Inject
    private CompanyController idCompanyController;
    @Inject
    private ServicesController idServicesController;

    public ServicesCompanyController() {
        // Inform the Abstract parent controller of the concrete ServicesCompany Entity
        super(ServicesCompany.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idCompanyController.setSelected(null);
        idServicesController.setSelected(null);
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

    /**
     * Sets the "selected" attribute of the Services controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdServices(ActionEvent event) {
        if (this.getSelected() != null && idServicesController.getSelected() == null) {
            idServicesController.setSelected(this.getSelected().getIdServices());
        }
    }
}
