package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.entity.UserType;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;

@Named(value = "userTypeController")
@ViewScoped
public class UserTypeController extends AbstractController<UserType> {

    public UserTypeController() {
        // Inform the Abstract parent controller of the concrete UserType Entity
        super(UserType.class);
    }

    /**
     * Sets the "items" attribute with a collection of User entities that are
     * retrieved from UserType?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for User page
     */
    public String navigateUserList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("User_items", this.getSelected().getUserList());
        }
        return "/admin/user/index";
    }

}
