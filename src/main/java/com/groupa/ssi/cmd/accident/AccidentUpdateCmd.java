/*
@author: HENRYBC
*/
package com.groupa.ssi.cmd.accident;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.accident.Accident;
import com.groupa.ssi.model.domain.catalog.SaClassification;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.request.accident.AccidentRequest;
import com.groupa.ssi.services.accident.AccidentService;
import com.groupa.ssi.services.catalog.SaClassificationService;
import com.groupa.ssi.services.personnel.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

@CommandScoped
public class AccidentUpdateCmd extends AbstractCommand {

    private Integer accidentId;
    private AccidentRequest accidentRequest;


    @Autowired
    private AccidentService service;

    @Autowired
    private SaClassificationService saClassificationService;

    @Autowired
    private EmployeeService employeeService;

    @Override
    protected void run(){
        SaClassification saClassification = null;
        Employee employee = null;

        if (null != accidentRequest.getSaClassificationId()) {
            saClassification = saClassificationService.findById(accidentRequest.getSaClassificationId());
        }

        if (null != accidentRequest.getEmployeeId()) {
            employee = employeeService.findById(accidentRequest.getEmployeeId());
        }

        Accident accident = composeAccident(accidentId, accidentRequest, saClassification, employee);
        service.save(accident);
    }

    public void setAccidentId(Integer accidentId) {
        this.accidentId = accidentId;
    }

    public void setAccidentRequest(AccidentRequest accidentRequest) {
        this.accidentRequest = accidentRequest;
    }

    private Accident composeAccident(Integer accidentId, AccidentRequest accidentRequest, SaClassification saClassification, Employee employee) {

        Accident accident = service.findById(accidentId);
        accident.setDescription(accidentRequest.getDescription());
        accident.setDateAccident(accidentRequest.getDateAccident());
        accident.setWhereOccurr(accidentRequest.getWhereOccurr());
        accident.setStatusRecord(accidentRequest.getStatusRecord());
        accident.setSaClassification(saClassification);
        accident.setEmployee(employee);

        return accident;
    }
}
