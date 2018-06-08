/*
@author: HENRYBC
*/
package com.groupa.ssi.cmd.accident;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.accident.Accident;
import com.groupa.ssi.services.accident.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@CommandScoped
public class AccidentListCmd extends AbstractCommand {

    @Autowired
    private AccidentService service;

    private List<Accident> accidentList;

    @Override
    protected void run(){
        accidentList = service.procedureFindAll();
    }

    public List<Accident> getAccidentList(){
        return accidentList;
    }
}
