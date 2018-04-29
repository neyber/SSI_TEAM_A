package com.groupa.ssi.cmd.functionmanual;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
//import com.groupa.ssi.model.domain.catalog.WorkItem;
//import com.groupa.ssi.request.catalog.WorkItemRequest;
//import com.groupa.ssi.services.catalog.WorkItemService;
import com.groupa.ssi.model.domain.functionmanual.FunctionManual;
import com.groupa.ssi.request.functionmanual.FunctionManualRequest;
import com.groupa.ssi.services.functionmanual.FunctionManualService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Marcelo Loayza
 */
@CommandScoped
public class FunctionManualUpdateCmd extends AbstractCommand {

    private Integer functionManualId;
    private FunctionManualRequest functionManualRequest;

    @Autowired
    private FunctionManualService service;

    @Override
    protected void run() {
        FunctionManual functionManual = composeFunctionManual(functionManualId, functionManualRequest);
        service.save(functionManual);
    }

    public void setFunctionManualId(Integer functionManualId) {
        this.functionManualId = functionManualId;
    }

    public void setWorkItemRequest(FunctionManualRequest functionManualRequest) { this.functionManualRequest = functionManualRequest; }

    private FunctionManual composeFunctionManual(Integer functionManualId, FunctionManualRequest functionManualRequest) {
        FunctionManual functionManual = service.findById(functionManualId);
        functionManual.setId(functionManualId);
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
