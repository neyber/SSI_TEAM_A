/*
@author: HENRYBC
*/
package com.groupa.ssi.cmd.sickness;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.catalog.SaClassification;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.model.domain.sickness.Sickness;
import com.groupa.ssi.request.sickness.SicknessRequest;
import com.groupa.ssi.services.catalog.SaClassificationService;
import com.groupa.ssi.services.personnel.EmployeeService;
import com.groupa.ssi.services.sickness.SicknessService;
import org.springframework.beans.factory.annotation.Autowired;

@CommandScoped
public class SicknessUpdateCmd extends AbstractCommand {

    private Integer sicknessId;
    private SicknessRequest sicknessRequest;

    @Autowired
    private SicknessService service;

    @Autowired
    private SaClassificationService saClassificationService;

    @Autowired
    private EmployeeService employeeService;

    @Override
    protected void run(){
        SaClassification saClassification = null;
        Employee employee = null;

        if (null != sicknessRequest.getSaClassificationId()) {
            saClassification = saClassificationService.findById(sicknessRequest.getSaClassificationId());
        }

        if (null != sicknessRequest.getEmployeeId()) {
            employee = employeeService.findById(sicknessRequest.getEmployeeId());
        }
        Sickness sickness = composeSickness(sicknessId, sicknessRequest, saClassification, employee);
        service.save(sickness);
    }

    public void setSicknessId(Integer sicknessId) {
        this.sicknessId = sicknessId;
    }

    public void setSicknessRequest(SicknessRequest sicknessRequest) {
        this.sicknessRequest = sicknessRequest;
    }

    private Sickness composeSickness(Integer sicknessId, SicknessRequest sicknessRequest, SaClassification saClassification, Employee employee) {
        Sickness sickness = service.findById(sicknessId);
        sickness.setDescription(sicknessRequest.getDescription());
        sickness.setDateSickness(sicknessRequest.getDateSickness());
        sickness.setWhereOccurr(sicknessRequest.getWhereOccurr());
        sickness.setStatusRecord(sicknessRequest.getStatusRecord());
        sickness.setSaClassification(saClassification);
        sickness.setEmployee(employee);
        return sickness;
    }

}
