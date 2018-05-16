/*
@author: HENRYBC
*/
package com.groupa.ssi.cmd.sickness;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.model.domain.saClassification.SaCategory;
import com.groupa.ssi.model.domain.saClassification.SaType;
import com.groupa.ssi.model.domain.sickness.Sickness;
import com.groupa.ssi.request.sickness.SicknessRequest;
import com.groupa.ssi.services.personnel.EmployeeService;
import com.groupa.ssi.services.saClassification.SaCategoryService;
import com.groupa.ssi.services.saClassification.SaTypeService;
import com.groupa.ssi.services.sickness.SicknessService;
import org.springframework.beans.factory.annotation.Autowired;

@CommandScoped
public class SicknessCreateCmd extends AbstractCommand {

    private SicknessRequest sicknessRequest;

    @Autowired
    private SicknessService service;

    @Autowired
    private SaCategoryService saCategoryService;

    @Autowired
    private SaTypeService saTypeService;

    @Autowired
    private EmployeeService employeeService;

    @Override
    protected void run(){
        SaCategory saCategory = null;
        SaType saType = null;
        Employee employee = null;
        if (null != sicknessRequest.getSaCategoryId()){
            saCategory = saCategoryService.findById(sicknessRequest.getSaCategoryId());
        }

        if (null != sicknessRequest.getSaTypeId()){
            saType = saTypeService.findById(sicknessRequest.getSaTypeId());
        }

        if (null != sicknessRequest.getEmployeeId()) {
            employee = employeeService.findById(sicknessRequest.getEmployeeId());
        }
        Sickness sickness = composeSickness(sicknessRequest, saCategory, saType,  employee);
        service.save(sickness);
    }

    public void setSicknessRequest(SicknessRequest sicknessRequest) {
        this.sicknessRequest = sicknessRequest;
    }

    private Sickness composeSickness(SicknessRequest sicknessRequest, SaCategory saCategory, SaType saType, Employee employee) {
        Sickness sickness = new Sickness();
        sickness.setDescription(sicknessRequest.getDescription());
        sickness.setDateSickness(sicknessRequest.getDateSickness());
        sickness.setWhereOccurr(sicknessRequest.getWhereOccurr());
        sickness.setStatusRecord(sicknessRequest.getStatusRecord());
        sickness.setTotalDaysOutOfWork(sicknessRequest.getTotalDaysOutOfWork());
        sickness.setTotalDaysRestrictedTransferredWork(sicknessRequest.getTotalDaysRestrictedTransferredWork());
        sickness.setSaCategory(saCategory);
        sickness.setSaType(saType);
        sickness.setEmployee(employee);

        return sickness;
    }


}
