package com.groupa.ssi.cmd.functionmanual;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.functionmanual.FunctionManual;
import com.groupa.ssi.services.functionmanual.FunctionManualService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Marcelo Loayza
 */
@CommandScoped
public class FunctionManualListCmd extends AbstractCommand {

    @Autowired
    private FunctionManualService service;

    private List<FunctionManual> functionManualList;

    @Override
    protected void run() {
        functionManualList = service.findAll();
    }

    public List<FunctionManual> getFunctionManualList() {
        return functionManualList;
    }
}
