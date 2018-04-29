/*
@author: HENRYBC
*/
package com.groupa.ssi.cmd.accident;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.accident.Accident;
import com.groupa.ssi.request.accident.AccidentRequest;
import com.groupa.ssi.services.accident.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;

@CommandScoped
public class AccidentUpdateCmd extends AbstractCommand {

    private Integer accidentId;
    private AccidentRequest accidentRequest;


    @Autowired
    private AccidentService service;

    @Override
    protected void run(){
        Accident accident = composeAccident(accidentId, accidentRequest);
        service.save(accident);
    }

    public void setAccidentId(Integer accidentId) {
        this.accidentId = accidentId;
    }

    public void setAccidentRequest(AccidentRequest accidentRequest) {
        this.accidentRequest = accidentRequest;
    }

    private Accident composeAccident(Integer accidentId, AccidentRequest accidentRequest) {

        Accident accident = service.findById(accidentId);
        accident.setDescription(accidentRequest.getDescription());
        accident.setDateAccident(accidentRequest.getDateAccident());
        accident.setWhereOccurr(accidentRequest.getWhereOccurr());
        accident.setStatusRecord(accidentRequest.getStatusRecord());
        accident.setSaClassification(accidentRequest.getSaClassification());

        return accident;
    }
}
