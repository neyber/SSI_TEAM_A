/*
@author: HENRYBC
*/
package com.groupa.ssi.cmd.accident;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.accident.Accident;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.model.domain.saClassification.SaCategory;
import com.groupa.ssi.model.domain.saClassification.SaType;
import com.groupa.ssi.request.accident.AccidentRequest;
import com.groupa.ssi.services.accident.AccidentService;
import com.groupa.ssi.services.personnel.EmployeeService;
import com.groupa.ssi.services.saClassification.SaCategoryService;
import com.groupa.ssi.services.saClassification.SaTypeService;
import org.springframework.beans.factory.annotation.Autowired;

@CommandScoped
public class AccidentUpdateCmd extends AbstractCommand {

    private Integer accidentId;
    private AccidentRequest accidentRequest;


    @Autowired
    private AccidentService service;

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
        if (null != accidentRequest.getSaCategoryId()){
            saCategory = saCategoryService.findById(accidentRequest.getSaCategoryId());
        }

        if (null != accidentRequest.getSaTypeId()){
            saType = saTypeService.findById(accidentRequest.getSaTypeId());
        }

        if (null != accidentRequest.getEmployeeId()) {
            employee = employeeService.findById(accidentRequest.getEmployeeId());
        }

        Accident accident = composeAccident(accidentRequest, saCategory, saType, employee);
        service.procedureUpdate(accident);
    }

    public void setAccidentId(Integer accidentId) {
        this.accidentId = accidentId;
    }

    public void setAccidentRequest(AccidentRequest accidentRequest) {
        this.accidentRequest = accidentRequest;
    }

    private Accident composeAccident(AccidentRequest accidentRequest, SaCategory saCategory, SaType saType, Employee employee) {
        Accident accident = service.findById(accidentId);
        accident.setDescription(accidentRequest.getDescription());
        accident.setDateAccident(accidentRequest.getDateAccident());
        accident.setWhereOccurr(accidentRequest.getWhereOccurr());
        accident.setStatusRecord(accidentRequest.getStatusRecord());
        accident.setTotalDaysOutOfWork(accidentRequest.getTotalDaysOutOfWork());
        accident.setTotalDaysRestrictedTransferredWork(accidentRequest.getTotalDaysRestrictedTransferredWork());
        accident.setSaCategory(saCategory);
        accident.setSaType(saType);
        accident.setEmployee(employee);

        return accident;
    }
}
