package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.entity.SectionMenuCompany;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;

@Named(value = "sectionMenuCompanyController")
@ViewScoped
public class SectionMenuCompanyController extends AbstractController<SectionMenuCompany> {

    public SectionMenuCompanyController() {
        // Inform the Abstract parent controller of the concrete SectionMenuCompany Entity
        super(SectionMenuCompany.class);
    }

    /**
     * Sets the "items" attribute with a collection of SectionCompany entities
     * that are retrieved from SectionMenuCompany?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for SectionCompany page
     */
    public String navigateSectionCompanyList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SectionCompany_items", this.getSelected().getSectionCompanyList());
        }
        return "/admin/sectionCompany/index";
    }

}
