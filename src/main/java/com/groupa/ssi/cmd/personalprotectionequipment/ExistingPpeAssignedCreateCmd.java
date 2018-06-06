package com.groupa.ssi.cmd.personalprotectionequipment;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpe;
import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpeAssigned;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.request.personalprotectionequipment.ExistingPpeAssignedRequest;
import com.groupa.ssi.services.personalprotectionequipment.ExistingPpeAssignedService;
import com.groupa.ssi.services.personalprotectionequipment.ExistingPpeService;
import com.groupa.ssi.services.personnel.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on April 30, 2018
 * @author Walker Colina
 */
@CommandScoped
public class ExistingPpeAssignedCreateCmd extends AbstractCommand {

    private ExistingPpeAssignedRequest existingPpeAssignedRequest;

    @Autowired
    private ExistingPpeAssignedService existingPpeAssignedService;

    @Autowired
    private ExistingPpeService existingPpeService;

    @Autowired
    private EmployeeService employeeService;

    @Override
    protected void run() {
        ExistingPpe existingPpe = null;
        if(existingPpeAssignedRequest.getExistingPpeId() != null){
            existingPpe = existingPpeService.procedureFindById(existingPpeAssignedRequest.getExistingPpeId());
        }

        Employee employee = null;
        if(existingPpeAssignedRequest.getEmployeeId() != null){
            employee = employeeService.procedureFindById(existingPpeAssignedRequest.getEmployeeId());
        }

        ExistingPpeAssigned existingPpeAssigned = composeExistingPpeAssigned(existingPpeAssignedRequest, existingPpe, employee);
        existingPpeAssignedService.procedureCreate(existingPpeAssigned);
    }

    public void setExistingPpeAssignedRequest(ExistingPpeAssignedRequest existingPpeAssignedRequest) {
        this.existingPpeAssignedRequest = existingPpeAssignedRequest;
    }

    private ExistingPpeAssigned composeExistingPpeAssigned(ExistingPpeAssignedRequest existingPpeAssignedRequest, ExistingPpe existingPpe, Employee employee){
        ExistingPpeAssigned existingPpeAssigned = new ExistingPpeAssigned();
        existingPpeAssigned.setAssignedNotes(existingPpeAssignedRequest.getAssignedNotes());
        existingPpeAssigned.setAssignedDate(existingPpeAssignedRequest.getAssignedDate());
        existingPpeAssigned.setReturnNotes(existingPpeAssignedRequest.getReturnNotes());
        existingPpeAssigned.setReturnDate(existingPpeAssignedRequest.getReturnDate());
        existingPpeAssigned.setExistingPpe(existingPpe);
        existingPpeAssigned.setEmployee(employee);

        return existingPpeAssigned;
    }
}
