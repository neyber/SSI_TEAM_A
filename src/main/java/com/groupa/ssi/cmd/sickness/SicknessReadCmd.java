/*
@author: HENRYBC
*/
package com.groupa.ssi.cmd.sickness;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.sickness.Sickness;
import com.groupa.ssi.services.sickness.SicknessService;
import org.springframework.beans.factory.annotation.Autowired;

@CommandScoped
public class SicknessReadCmd extends AbstractCommand {

    private Integer sicknessId;

    @Autowired
    private SicknessService service;

    private Sickness sickness;

    @Override
    protected void run(){
        sickness = service.findById(sicknessId);
    }

    public void setSicknessId(Integer sicknessId) {
        this.sicknessId = sicknessId;
    }

    public Sickness getSickness() {
        return sickness;
    }
}
