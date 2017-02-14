package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.entity.TypePromotion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "typePromotionController")
@ViewScoped
public class TypePromotionController extends AbstractController<TypePromotion> {

    public TypePromotionController() {
        // Inform the Abstract parent controller of the concrete TypePromotion Entity
        super(TypePromotion.class);
    }

    /**
     * Sets the "items" attribute with a collection of Promotion entities that
     * are retrieved from TypePromotion?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Promotion page
     */
    public String navigatePromotionList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Promotion_items", this.getSelected().getPromotionList());
        }
        return "/admin/promotion/index";
    }

}
