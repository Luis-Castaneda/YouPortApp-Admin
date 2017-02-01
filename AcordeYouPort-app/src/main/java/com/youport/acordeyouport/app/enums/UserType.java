/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youport.acordeyouport.app.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Castañeda <luis.castaneda at acorde.com.ve>
 */
public enum UserType {

    Administrator("Administrator"),
    Generic("Generic");

    String type;

    private UserType(String type) {
        this.type = type;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static List<String> getListValues() {
        List<String> list = new ArrayList<>();

        for (UserType value : UserType.values()) {
            list.add(value.getType());
        }
        return list;
    }

    public static UserType getUserByType(String typeUser) {
        UserType typeA = null;
        for (UserType type : UserType.values()) {
            if (type.getType().equals(typeUser)) {
                typeA = type;
            }
        }
        return typeA;
    }

}
