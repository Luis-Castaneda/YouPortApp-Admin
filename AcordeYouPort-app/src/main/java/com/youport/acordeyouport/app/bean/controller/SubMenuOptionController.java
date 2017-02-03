package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.entity.SubMenuOption;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "subMenuOptionController")
@ViewScoped
public class SubMenuOptionController extends AbstractController<SubMenuOption> {

    public SubMenuOptionController() {
        // Inform the Abstract parent controller of the concrete SubMenuOption Entity
        super(SubMenuOption.class);
    }

}
