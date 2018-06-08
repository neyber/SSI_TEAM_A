/*
@author: HENRYBC
*/
package com.groupa.ssi.cmd.accident;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.accident.Accident;
import com.groupa.ssi.services.accident.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;

@CommandScoped
public class AccidentReadCmd extends AbstractCommand {

    private Integer accidentId;

    @Autowired
    private AccidentService service;

    private Accident accident;

    @Override
    protected void run(){
        accident = service.procedureFindById(accidentId);
    }

    public void setAccidentId(Integer accidentId) {
        this.accidentId = accidentId;
    }

    public Accident getAccident() {
        return accident;
    }
}
