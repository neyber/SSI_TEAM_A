package com.groupa.ssi.common.constant;

/*
Created on 13/5/18
@author: HENRYBC
*/
public enum EnumSaCategory {

    /*THIS FRAGMENT CONTAIN VALUES FOR CATEGORY VALUES OF SA CLASSIFICATION*/
    DEATH ("Death"),
    DAYS_OUT_OF_WORK ("Days out of work"),
    RESTRICTED_TRANSFERRED_WORK ("Testricted / Transferred work"),
    REMAINED_AT_WORK ("Remained at work"),
    OTHER_RECORDABLE_CASES ("Other recordable cases");

    public String code;

    private EnumSaCategory(String code){
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }
}
