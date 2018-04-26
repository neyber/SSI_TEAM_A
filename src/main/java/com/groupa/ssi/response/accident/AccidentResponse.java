/*
@author: HENRYBC
*/
package com.groupa.ssi.response.accident;

import java.util.Date;

public class AccidentResponse {

    private String description;
    private Date dateAccident;
    private String whereOccurr;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateAccident() {
        return dateAccident;
    }

    public void setDateAccident(Date dateAccident) {
        this.dateAccident = dateAccident;
    }

    public String getWhereOccurr() {
        return whereOccurr;
    }

    public void setWhereOccurr(String whereOccurr) {
        this.whereOccurr = whereOccurr;
    }
}
