package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.entity.TypeView;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "typeViewController")
@ViewScoped
public class TypeViewController extends AbstractController<TypeView> {

    public TypeViewController() {
        // Inform the Abstract parent controller of the concrete TypeView Entity
        super(TypeView.class);
    }

    /**
     * Sets the "items" attribute with a collection of View entities that are
     * retrieved from TypeView?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for View page
     */
    public String navigateViewList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("View_items", this.getSelected().getViewList());
        }
        return "/admin/view/index";
    }

}
