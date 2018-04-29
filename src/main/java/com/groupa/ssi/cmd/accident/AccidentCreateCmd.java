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
public class AccidentCreateCmd extends AbstractCommand {

    private AccidentRequest accidentRequest;

    @Autowired
    private AccidentService accidentService;

    @Override
    protected void run(){
        Accident accident = composeAccident(accidentRequest);
        accidentService.save(accident);
    }

    public void setAccidentRequest(AccidentRequest accidentRequest) {
        this.accidentRequest = accidentRequest;
    }

    private Accident composeAccident(AccidentRequest accidentRequest) {
        Accident accident = new Accident();
        accident.setDescription(accidentRequest.getDescription());
        accident.setDateAccident(accidentRequest.getDateAccident());
        accident.setWhereOccurr(accidentRequest.getWhereOccurr());
        accident.setStatusRecord(accidentRequest.getStatusRecord());
        accident.setSaClassification(accidentRequest.getSaClassification());

        return accident;
    }
}
