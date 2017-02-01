package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.entity.User;
import com.youport.acordeyouport.app.services.PasswordService;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

@Named(value = "userController")
@ViewScoped
public class UserController extends AbstractController<User> {

    @Inject
    private UserStatusController idUserStatusController;
    @Inject
    private UserTypeController idUserTypeController;

    public UserController() {
        // Inform the Abstract parent controller of the concrete User Entity
        super(User.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idUserStatusController.setSelected(null);
        idUserTypeController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the UserStatus controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdUserStatus(ActionEvent event) {
        if (this.getSelected() != null && idUserStatusController.getSelected() == null) {
            idUserStatusController.setSelected(this.getSelected().getIdUserStatus());
        }
    }

    /**
     * Sets the "selected" attribute of the UserType controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdUserType(ActionEvent event) {
        if (this.getSelected() != null && idUserTypeController.getSelected() == null) {
            idUserTypeController.setSelected(this.getSelected().getIdUserType());
        }
    }

    @Override
    public void save(ActionEvent event) {
        User user = getSelected();
        System.out.println("user.getPassword(): " + user.getPassword());
        WebApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
        PasswordService passwordService = ctx.getBean("passwordEncoder", PasswordService.class);
        user.setPassword(passwordService.encode(user.getPassword()));
        System.out.println("encode user.getPassword(): " + user.getPassword());
        super.save(event);
    }

    @Override
    public void saveNew(ActionEvent event) {
        System.out.println("saveNew override");
        User user = getSelected();
        System.out.println("user.getPasswordVal(): " + user.getPassword());
        WebApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
        PasswordService passwordService = ctx.getBean("passwordEncoder", PasswordService.class);
        user.setPassword(passwordService.encode(user.getPassword()));
        System.out.println("encode user.getPassword(): " + user.getPassword());
        super.saveNew(event);
    }
}
