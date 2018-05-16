package com.groupa.ssi.common.constant;

/*
Created on 13/5/18
@author: HENRYBC
*/
public enum EnumSaType {

    /*THIS FRAGMENT CONTAIN TYPE OF SICKNESS OR ACCIDENT*/
    INJURY ("Injury"),
    SKIN_DISORDER ("Skin disorder"),
    RESPIRATORY_CONDITION ("Respiratory condition"),
    POISONING ("Poisoning"),
    HEARING_LOSS ("Hearing loss"),
    OTHER_DISEASES ("Other diseases");

    public String code;

    private EnumSaType(String code){
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }
}
