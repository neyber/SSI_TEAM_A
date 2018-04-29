/*
@author: HENRYBC
*/
package com.groupa.ssi.cmd.sickness;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.sickness.Sickness;
import com.groupa.ssi.request.sickness.SicknessRequest;
import com.groupa.ssi.services.sickness.SicknessService;
import org.springframework.beans.factory.annotation.Autowired;

@CommandScoped
public class SicknessCreateCmd extends AbstractCommand {

    private SicknessRequest sicknessRequest;

    @Autowired
    private SicknessService service;

    @Override
    protected void run(){
        Sickness sickness = composeSickness(sicknessRequest);
        service.save(sickness);
    }

    public void setSicknessRequest(SicknessRequest sicknessRequest) {
        this.sicknessRequest = sicknessRequest;
    }

    private Sickness composeSickness(SicknessRequest sicknessRequest) {
        Sickness sickness = new Sickness();
        sickness.setDescription(sicknessRequest.getDescription());
        sickness.setDateSickness(sicknessRequest.getDateSickness());
        sickness.setWhereOccurr(sicknessRequest.getWhereOccurr());
        sickness.setStatusRecord(sicknessRequest.getStatusRecord());
        sickness.setSaClassification(sicknessRequest.getSaClassification());

        return sickness;
    }


}
