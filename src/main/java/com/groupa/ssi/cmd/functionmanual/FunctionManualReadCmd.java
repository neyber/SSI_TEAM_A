package com.groupa.ssi.cmd.functionmanual;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.functionmanual.FunctionManual;
import com.groupa.ssi.services.functionmanual.FunctionManualService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Marcelo Loayza
 */
@CommandScoped
public class FunctionManualReadCmd extends AbstractCommand {

    private Integer FunctionManualId;

    @Autowired
    private FunctionManualService service;

    private FunctionManual functionManual;

    @Override
    protected void run() {
        functionManual = service.procedureFindById(FunctionManualId);
    }

    public void setFunctionManualId(Integer FunctionManualId) {
        this.FunctionManualId = FunctionManualId;
    }

    public FunctionManual getFunctionManual() {
        return functionManual;
    }
}
