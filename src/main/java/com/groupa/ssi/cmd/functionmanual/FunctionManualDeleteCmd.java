package com.groupa.ssi.cmd.functionmanual;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.services.functionmanual.FunctionManualService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Marcelo Loayza
 */
@CommandScoped
public class FunctionManualDeleteCmd extends AbstractCommand {

    private Integer FunctionManulId;

    @Autowired
    private FunctionManualService service;

    @Override
    protected void run() {
        service.deleteById(FunctionManulId);
    }

    public void setFunctionManulIdId(Integer FunctionManulId) {
        this.FunctionManulId = FunctionManulId;
    }
}
