package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.entity.SubMenuOptions;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "subMenuOptionController")
@ViewScoped
public class SubMenuOptionController extends AbstractController<SubMenuOptions> {

    public SubMenuOptionController() {
        // Inform the Abstract parent controller of the concrete SubMenuOptions Entity
        super(SubMenuOptions.class);
    }

}
