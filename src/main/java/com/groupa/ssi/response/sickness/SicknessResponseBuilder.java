/*
@author: HENRYBC
*/
package com.groupa.ssi.response.sickness;

import com.groupa.ssi.model.domain.sickness.Sickness;

import java.util.Date;

public class SicknessResponseBuilder {
    private String description;
    private Date dateSickness;
    private String whereOccurr;

    public SicknessResponseBuilder(){}

    public SicknessResponse build(){
        SicknessResponse sicknessResponse = new SicknessResponse();
        sicknessResponse.setDescription(description);
        sicknessResponse.setDateSickness(dateSickness);
        sicknessResponse.setWhereOccurr(whereOccurr);

        return sicknessResponse;
    }

    public SicknessResponseBuilder getInstance(Sickness sickness){
        return new SicknessResponseBuilder()
                .setDescription(sickness.getDescription())
                .setDateSickness(sickness.getDateSickness())
                .setWhereOccurr(sickness.getWhereOccurr());
    }

    public SicknessResponseBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public SicknessResponseBuilder setDateSickness(Date dateSickness) {
        this.dateSickness = dateSickness;
        return this;
    }

    public SicknessResponseBuilder setWhereOccurr(String whereOccurr) {
        this.whereOccurr = whereOccurr;
        return this;
    }
}
