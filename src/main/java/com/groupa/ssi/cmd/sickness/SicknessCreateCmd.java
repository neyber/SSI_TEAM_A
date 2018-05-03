/*
@author: HENRYBC
*/
package com.groupa.ssi.cmd.sickness;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.catalog.SaClassification;
import com.groupa.ssi.model.domain.sickness.Sickness;
import com.groupa.ssi.request.sickness.SicknessRequest;
import com.groupa.ssi.services.catalog.SaClassificationService;
import com.groupa.ssi.services.sickness.SicknessService;
import org.springframework.beans.factory.annotation.Autowired;

@CommandScoped
public class SicknessCreateCmd extends AbstractCommand {

    private SicknessRequest sicknessRequest;

    @Autowired
    private SicknessService service;

    @Autowired
    private SaClassificationService saClassificationService;

    @Override
    protected void run(){
        SaClassification sicknessClassification = null;
        if (null != sicknessRequest.getSaClassificationId()){
            sicknessClassification = saClassificationService.findById(sicknessRequest.getSaClassificationId());
        }
        Sickness sickness = composeSickness(sicknessRequest, sicknessClassification);
        service.save(sickness);
    }

    public void setSicknessRequest(SicknessRequest sicknessRequest) {
        this.sicknessRequest = sicknessRequest;
    }

    private Sickness composeSickness(SicknessRequest sicknessRequest,SaClassification sicknessClassification) {
        Sickness sickness = new Sickness();
        sickness.setDescription(sicknessRequest.getDescription());
        sickness.setDateSickness(sicknessRequest.getDateSickness());
        sickness.setWhereOccurr(sicknessRequest.getWhereOccurr());
        sickness.setStatusRecord(sicknessRequest.getStatusRecord());
        sickness.setSaClassification(sicknessClassification);

        return sickness;
    }


}
