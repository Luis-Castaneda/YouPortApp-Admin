package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.entity.ConfigurationMaster;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "configurationMasterController")
@ViewScoped
public class ConfigurationMasterController extends AbstractController<ConfigurationMaster> {

    public ConfigurationMasterController() {
        // Inform the Abstract parent controller of the concrete ConfigurationMaster Entity
        super(ConfigurationMaster.class);
    }

}
