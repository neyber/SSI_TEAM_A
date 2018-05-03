/*
@author: HENRYBC
*/
package com.groupa.ssi.cmd.accident;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.accident.Accident;
import com.groupa.ssi.model.domain.catalog.SaClassification;
import com.groupa.ssi.request.accident.AccidentRequest;
import com.groupa.ssi.request.catalog.SaClassificationRequest;
import com.groupa.ssi.services.accident.AccidentService;
import com.groupa.ssi.services.catalog.SaClassificationService;
import org.springframework.beans.factory.annotation.Autowired;

@CommandScoped
public class AccidentCreateCmd extends AbstractCommand {

    private AccidentRequest accidentRequest;

    @Autowired
    private AccidentService accidentService;

    @Autowired
    private SaClassificationService saClassificationService;

    @Override
    protected void run(){
        SaClassification accidentClassification = null;
        if (null != accidentRequest.getSaClassificationId()){
            accidentClassification = saClassificationService.findById(accidentRequest.getSaClassificationId());
        }
        Accident accident = composeAccident(accidentRequest, accidentClassification);
        accidentService.save(accident);
    }

    public void setAccidentRequest(AccidentRequest accidentRequest) {
        this.accidentRequest = accidentRequest;
    }

    private Accident composeAccident(AccidentRequest accidentRequest, SaClassification accidentClassification) {
        Accident accident = new Accident();
        accident.setDescription(accidentRequest.getDescription());
        accident.setDateAccident(accidentRequest.getDateAccident());
        accident.setWhereOccurr(accidentRequest.getWhereOccurr());
        accident.setStatusRecord(accidentRequest.getStatusRecord());
        accident.setSaClassification(accidentClassification);

        return accident;
    }
}
