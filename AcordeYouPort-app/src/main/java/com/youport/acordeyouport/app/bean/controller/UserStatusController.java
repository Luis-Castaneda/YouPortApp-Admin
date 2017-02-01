package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.entity.UserStatus;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "userStatusController")
@ViewScoped
public class UserStatusController extends AbstractController<UserStatus> {

    public UserStatusController() {
        // Inform the Abstract parent controller of the concrete UserStatus Entity
        super(UserStatus.class);
    }

    /**
     * Sets the "items" attribute with a collection of User entities that are
     * retrieved from UserStatus?cap_first and returns the navigation outcome.
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
