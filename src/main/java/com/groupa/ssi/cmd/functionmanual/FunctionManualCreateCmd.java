package com.groupa.ssi.cmd.functionmanual;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.functionmanual.FunctionManual;
import com.groupa.ssi.model.domain.personnel.Role;
import com.groupa.ssi.request.functionmanual.FunctionManualRequest;
import com.groupa.ssi.services.functionmanual.FunctionManualService;
import com.groupa.ssi.services.personnel.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Marcelo Loayza
 */
@CommandScoped
public class FunctionManualCreateCmd extends AbstractCommand {


    private FunctionManualRequest functionManualRequest;

    @Autowired
    private RoleService roleService;
    @Autowired
    private FunctionManualService service;

    @Override
    protected void run() {
        Role roleFunction = null;

        if(functionManualRequest.getRoleFunction() != null){
            roleFunction = roleService.findById(functionManualRequest.getRoleFunction());
        }

        FunctionManual functionManual = composeFunctionManual(functionManualRequest, roleFunction);
        service.procedureCreate(functionManual);
    }

    public void setFunctionManualRequest(FunctionManualRequest functionManualRequest) {
        this.functionManualRequest = functionManualRequest;
    }

    private FunctionManual composeFunctionManual(FunctionManualRequest functionManualRequest, Role roleFunction) {
        FunctionManual functionManual = new FunctionManual();
        functionManual.setName(functionManualRequest.getName());
        functionManual.setPosition(functionManualRequest.getPosition());
        functionManual.setHierarchicalLever(functionManualRequest.getHierarchicalLever());
        functionManual.setSuperiorBoss(functionManualRequest.getSuperiorBoss());
        functionManual.setDependentPersonal(functionManualRequest.getDependentPersonal());
        functionManual.setExternalRelation(functionManualRequest.getExternalRelation());
        functionManual.setInternalRelation(functionManualRequest.getInternalRelation());
        functionManual.setGeneralActivity(functionManualRequest.getGeneralActivity());
        functionManual.setPrincipalFunction(functionManualRequest.getPrincipalFunction());
        functionManual.setRoleFunction(roleFunction);
        return functionManual;
    }
}
