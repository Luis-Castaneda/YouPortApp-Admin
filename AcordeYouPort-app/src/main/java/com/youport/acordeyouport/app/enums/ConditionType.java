/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youport.acordeyouport.app.enums;

/**
 *
 * @author Luis Castañeda <luis.castaneda at acorde.com.ve>
 */
public enum ConditionType {

    NEW(1, "NEW"),
    EDIT(2, "EDIT");

    private Integer idCondition;
    private String nameCondition;

    private ConditionType(Integer idCondition, String nameCondition) {
        this.idCondition = idCondition;
        this.nameCondition = nameCondition;
    }

    public Integer getIdCondition() {
        return idCondition;
    }

    public void setIdCondition(Integer idCondition) {
        this.idCondition = idCondition;
    }

    public String getNameCondition() {
        return nameCondition;
    }

    public void setNameCondition(String nameCondition) {
        this.nameCondition = nameCondition;
    }

}
