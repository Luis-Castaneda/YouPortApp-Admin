/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youport.acordeyouport.app.bean.session;

import com.youport.acordeyouport.app.entity.ConfigurationMaster;
import com.youport.acordeyouport.app.facade.ConfigurationMasterFacade;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Luis Castañeda <luis.castaneda at acorde.com.ve>
 */
@SessionScoped
public class ConfigurationMasterParameter implements Serializable {

    private HashMap<String, String> parameters;

    @EJB
    private ConfigurationMasterFacade facade;

    private List<ConfigurationMaster> parameterList;

    public static final String CONF_ALLOW_TYPES_FILE_UPLOAD = "CONF_ALLOW_TYPES_FILE_UPLOAD";
    public static final String CONF_SIZE_LIMIT_FILE_UPLOAD = "CONF_SIZE_LIMIT_FILE_UPLOAD";
    public static final String UPLOAD_DIRECTORY_IMAGE_RELATIVE = "UPLOAD_DIRECTORY_IMAGE_RELATIVE";
    public static final String UPLOAD_DIRECTORY_IMAGE_ABSOLUTE= "UPLOAD_DIRECTORY_IMAGE_ABSOLUTE";

    @PostConstruct
    public void init() {
        parameters = new HashMap<>();

        parameterList = facade.findAll();

        if (parameterList != null && !parameterList.isEmpty()) {
            for (ConfigurationMaster conf : parameterList) {
                parameters.put(conf.getNameParameter(), conf.getValueParameter());
            }
        }
    }

    public String getParameter(String parameter) {
        return parameters.get(parameter);
    }

}
