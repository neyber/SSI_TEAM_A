/*
@author: HENRYBC
*/
package com.groupa.ssi.cmd.sickness;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.sickness.Sickness;
import com.groupa.ssi.services.sickness.SicknessService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@CommandScoped
public class SicknessListCmd extends AbstractCommand {

    @Autowired
    private SicknessService service;

    private List<Sickness> sicknessList;

    @Override
    protected void run(){
        sicknessList = service.procedureFindAll();
    }

    public List<Sickness> getSicknessList() {
        return sicknessList;
    }
}
