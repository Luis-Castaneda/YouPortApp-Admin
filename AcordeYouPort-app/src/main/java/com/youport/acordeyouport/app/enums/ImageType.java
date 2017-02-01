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
public enum ImageType {

    OVER(1, "OVER"),
    NORMAL(2, "NORMAL");

    private Integer idImageType;
    private String typeImage;

    private ImageType(Integer idImageType, String typeImage) {
        this.idImageType = idImageType;
        this.typeImage = typeImage;
    }

    public Integer getIdImageType() {
        return idImageType;
    }

    public void setIdImageType(Integer idImageType) {
        this.idImageType = idImageType;
    }

    public String getTypeImage() {
        return typeImage;
    }

    public void setTypeImage(String typeImage) {
        this.typeImage = typeImage;
    }

}
