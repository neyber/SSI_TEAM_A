/*
@author: HENRYBC
*/
package com.groupa.ssi.request.sickness;

import java.util.Date;

public class SicknessRequest {
    private String description;
    private Date dateSickness;
    private String whereOccurr;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateSickness() {
        return dateSickness;
    }

    public void setDateSickness(Date dateSickness) {
        this.dateSickness = dateSickness;
    }

    public String getWhereOccurr() {
        return whereOccurr;
    }

    public void setWhereOccurr(String whereOccurr) {
        this.whereOccurr = whereOccurr;
    }
}
