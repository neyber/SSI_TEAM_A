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
public class SicknessCreateCmd extends AbstractCommand {

    private SicknessRequest sicknessRequest;

    @Autowired
    private SicknessService service;

    @Autowired
    private SaClassificationService saClassificationService;

    @Autowired
    private EmployeeService employeeService;

    @Override
    protected void run(){
        SaClassification sicknessClassification = null;
        Employee employee = null;
        if (null != sicknessRequest.getSaClassificationId()){
            sicknessClassification = saClassificationService.findById(sicknessRequest.getSaClassificationId());
        }

        if (null != sicknessRequest.getEmployeeId()) {
            employee = employeeService.findById(sicknessRequest.getEmployeeId());
        }
        Sickness sickness = composeSickness(sicknessRequest, sicknessClassification, employee);
        service.save(sickness);
    }

    public void setSicknessRequest(SicknessRequest sicknessRequest) {
        this.sicknessRequest = sicknessRequest;
    }

    private Sickness composeSickness(SicknessRequest sicknessRequest,SaClassification sicknessClassification, Employee employee) {
        Sickness sickness = new Sickness();
        sickness.setDescription(sicknessRequest.getDescription());
        sickness.setDateSickness(sicknessRequest.getDateSickness());
        sickness.setWhereOccurr(sicknessRequest.getWhereOccurr());
        sickness.setStatusRecord(sicknessRequest.getStatusRecord());
        sickness.setSaClassification(sicknessClassification);
        sickness.setEmployee(employee);

        return sickness;
    }


}
