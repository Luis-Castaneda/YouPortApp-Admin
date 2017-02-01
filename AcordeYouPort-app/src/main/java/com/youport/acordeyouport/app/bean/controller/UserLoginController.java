/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.facade.UserFacade;
import com.youport.acordeyouport.app.entity.User;
import com.youport.acordeyouport.app.enums.UserType;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

/**
 *
 * @author Luis Castañeda <luis.castaneda at acorde.com.ve>
 */
@Named(value = "userLoginController")
@ViewScoped
public class UserLoginController extends AbstractController<User> {

    private AuthenticationManager authenticationManager;

    @EJB
    private UserFacade userFacade;

    private User user;

    private String username;

    private String password;

    private final FacesContext facesContext = FacesContext.getCurrentInstance();
    private final Locale locale = facesContext.getViewRoot().getLocale();
    protected ResourceBundle bundle = ResourceBundle.getBundle("/YouPortBundle", locale);

    public UserLoginController() {
        // Inform the Abstract parent controller of the concrete Agent Entity
        super(User.class);
        WebApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
        authenticationManager = ctx.getBean("authenticationManager", AuthenticationManager.class);

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserLogged() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName(); //get logged in username
    }

    public String logout() {
        System.out.println("logout");
        return "/login/login.xhtml";
    }

    public String login() {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        String ret = "fail";

        try {
            if (username != null && password != null) {
                loggedIn = true;
                Authentication request = new UsernamePasswordAuthenticationToken(username, password);
                Authentication result = authenticationManager.authenticate(request);
                SecurityContextHolder.getContext().setAuthentication(result);
                if (result.isAuthenticated()) {
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
                    HashMap param = new HashMap();
                    param.put("idUser", username);
                    user = userFacade.listUniqueNamedQuery(User.class, "User.findByIdUser", param);
                    if (user != null) {
                        if (getUserManagedBean() == null) {
                            setUserManagedBean(new UserManagedBean());
                        }
                        getUserManagedBean().setUserId(user.getIdUser());
                        getUserManagedBean().setName(user.getName());
                        getUserManagedBean().setEmail(user.getEmail());
                        getUserManagedBean().setLast_name(user.getSurname());
                        getUserManagedBean().setType(user.getIdUserType().getType());
                    }
                    if (result.getAuthorities() != null) {
                        String role = ((GrantedAuthority) result.getAuthorities().toArray()[0]).getAuthority();

                        switch (UserType.valueOf(role)) {
                            case Administrator:
                                ret = "admin";
                                break;
                            case Generic:
                                ret = "generic";
                                break;
                            default:
                        }
                    }
                } else {
                    loggedIn = false;
                    message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
                }
            } else {
                loggedIn = false;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
            }
        } catch (BadCredentialsException ex) {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
        return ret;
    }

    /**
     * @return the authenticationManager
     */
    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    /**
     * @param authenticationManager the authenticationManager to set
     */
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

}
