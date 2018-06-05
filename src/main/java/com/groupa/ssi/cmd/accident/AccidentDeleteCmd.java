/*
@author: HENRYBC
*/
package com.groupa.ssi.cmd.accident;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.services.accident.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;

@CommandScoped
public class AccidentDeleteCmd extends AbstractCommand {

    private Integer accidentId;

    @Autowired
    private AccidentService service;

    @Override
    protected void run(){
        service.procedureDeleteById(accidentId);
    }

    public void setAccidentId(Integer accidentId){
        this.accidentId = accidentId;
    }
}
