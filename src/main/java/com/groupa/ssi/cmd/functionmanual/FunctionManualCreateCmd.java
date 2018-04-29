package com.groupa.ssi.cmd.functionmanual;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.functionmanual.FunctionManual;
import com.groupa.ssi.request.functionmanual.FunctionManualRequest;
import com.groupa.ssi.services.functionmanual.FunctionManualService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Marcelo Loayza
 */
@CommandScoped
public class FunctionManualCreateCmd extends AbstractCommand {

    private FunctionManualRequest functionManualRequest;

    @Autowired
    private FunctionManualService service;

    @Override
    protected void run() {
        FunctionManual functionManual = composeFunctionManual(functionManualRequest);
        service.save(functionManual);
    }

    public void setFunctionManualRequest(FunctionManualRequest functionManualRequest) {
        this.functionManualRequest = functionManualRequest;
    }

    private FunctionManual composeFunctionManual(FunctionManualRequest functionManualRequest) {
        FunctionManual functionManual = new FunctionManual();
        functionManual.setName(functionManualRequest.getName());
        functionManual.setPosition(functionManualRequest.getPosition());
        functionManual.setHierarchicalLever(functionManualRequest.getHierarchicalLever());
        functionManual.setSuperiorBoss(functionManualRequest.getSuperiorBoss());
        functionManual.setDependentPersonal(functionManualRequest.getInternalRelation());
        functionManual.setExternalRelation(functionManualRequest.getExternalRelation());
        functionManual.setActivity(functionManualRequest.getActivity());
        functionManual.setGeneralActivity(functionManualRequest.getGeneralActivity());
        functionManual.setPrincipalFunction(functionManualRequest.getPrincipalFunction());
        return functionManual;
    }
}
