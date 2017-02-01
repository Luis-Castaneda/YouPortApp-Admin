/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youport.acordeyouport.app.enums;

/**
 *
 * @author luis
 */
public enum OperationType {

    CREATE("create"),
    EDIT("edit"),
    DELETE("delete");

    private String operationName;

    private OperationType(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public static OperationType getOperationByName(String nameOperation) {
        OperationType name = null;
        for (OperationType type : OperationType.values()) {
            if (type.getOperationName().equals(nameOperation)) {
                name = type;
            }
        }
        return name;
    }

}
