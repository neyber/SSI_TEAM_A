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
import com.groupa.ssi.request.catalog.SaClassificationRequest;
import com.groupa.ssi.services.accident.AccidentService;
import com.groupa.ssi.services.catalog.SaClassificationService;
import com.groupa.ssi.services.personnel.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

@CommandScoped
public class AccidentCreateCmd extends AbstractCommand {

    private AccidentRequest accidentRequest;

    @Autowired
    private AccidentService accidentService;

    @Autowired
    private SaClassificationService saClassificationService;

    @Autowired
    private EmployeeService employeeService;

    @Override
    protected void run(){
        SaClassification accidentClassification = null;
        Employee employee = null;
        if (null != accidentRequest.getSaClassificationId()){
            accidentClassification = saClassificationService.findById(accidentRequest.getSaClassificationId());
        }

        if (null != accidentRequest.getEmployeeId()) {
            employee = employeeService.findById(accidentRequest.getEmployeeId());
        }

        Accident accident = composeAccident(accidentRequest, accidentClassification, employee);
        accidentService.save(accident);
    }

    public void setAccidentRequest(AccidentRequest accidentRequest) {
        this.accidentRequest = accidentRequest;
    }

    private Accident composeAccident(AccidentRequest accidentRequest, SaClassification accidentClassification, Employee employee) {
        Accident accident = new Accident();
        accident.setDescription(accidentRequest.getDescription());
        accident.setDateAccident(accidentRequest.getDateAccident());
        accident.setWhereOccurr(accidentRequest.getWhereOccurr());
        accident.setStatusRecord(accidentRequest.getStatusRecord());
        accident.setSaClassification(accidentClassification);
        accident.setEmployee(employee);

        return accident;
    }
}
