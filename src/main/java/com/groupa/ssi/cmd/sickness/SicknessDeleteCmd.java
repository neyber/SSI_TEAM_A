/*
@author: HENRYBC
*/
package com.groupa.ssi.cmd.sickness;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.services.sickness.SicknessService;
import org.springframework.beans.factory.annotation.Autowired;

@CommandScoped
public class SicknessDeleteCmd extends AbstractCommand {

    private Integer sicknessId;

    @Autowired
    private SicknessService service;

    @Override
    protected void run(){
        service.procedureDeleteById(sicknessId);
    }

    public void setSicknessId(Integer sicknessId) {
        this.sicknessId = sicknessId;
    }
}
