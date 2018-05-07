package com.groupa.ssi.response.personalprotectionequipment;

import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpe;
import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpeAssigned;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.response.personnel.EmployeeResponse;
import com.groupa.ssi.response.personnel.EmployeeResponseBuilder;

import java.util.Date;

/**
 * Created on April 30, 2018
 * @author Walker Colina
 */
public final class ExistingPpeAssignedResponseBuilder {

    private Integer existingPpeAssignedId;
    private String assignedNotes;
    private Date assignedDate;
    private String returnNotes;
    private Date returnDate;
    private ExistingPpeResponse existingPpe;
    private EmployeeResponse employee;

    private ExistingPpeAssignedResponseBuilder() {
    }

    public ExistingPpeAssignedResponse build() {
        ExistingPpeAssignedResponse existingPpeAssignedResponse = new ExistingPpeAssignedResponse();
        existingPpeAssignedResponse.setExistingPpeAssignedId(existingPpeAssignedId);
        existingPpeAssignedResponse.setAssignedNotes(assignedNotes);
        existingPpeAssignedResponse.setAssignedDate(assignedDate);
        existingPpeAssignedResponse.setReturnNotes(returnNotes);
        existingPpeAssignedResponse.setReturnDate(returnDate);
        existingPpeAssignedResponse.setExistingPpe(existingPpe);
        existingPpeAssignedResponse.setEmployee(employee);

        return existingPpeAssignedResponse;
    }


    public static ExistingPpeAssignedResponseBuilder getInstance(ExistingPpeAssigned existingPpeAssigned) {
        ExistingPpeAssignedResponseBuilder existingPpeAssignedResponseBuilder = new ExistingPpeAssignedResponseBuilder();
        existingPpeAssignedResponseBuilder.setExistingPpeAssignedId(existingPpeAssigned.getId());
        existingPpeAssignedResponseBuilder.setAssignedNotes(existingPpeAssigned.getAssignedNotes());
        existingPpeAssignedResponseBuilder.setAssignedDate(existingPpeAssigned.getAssignedDate());
        existingPpeAssignedResponseBuilder.setReturnNotes(existingPpeAssigned.getReturnNotes());
        existingPpeAssignedResponseBuilder.setReturnDate(existingPpeAssigned.getReturnDate());
        if(existingPpeAssigned.getExistingPpe() != null) {
            existingPpeAssignedResponseBuilder.setExistingPpe(ExistingPpeResponseBuilder.getInstance(existingPpeAssigned.getExistingPpe()).build());
        }
        if(existingPpeAssigned.getEmployee() != null) {
            existingPpeAssignedResponseBuilder.setEmployee(EmployeeResponseBuilder.getInstance(existingPpeAssigned.getEmployee()).build());
        }

        return existingPpeAssignedResponseBuilder;
    }

    public ExistingPpeAssignedResponseBuilder setExistingPpeAssignedId(Integer existingPpeAssignedId) {
        this.existingPpeAssignedId = existingPpeAssignedId;
        return this;
    }

    public ExistingPpeAssignedResponseBuilder setAssignedNotes(String assignedNotes) {
        this.assignedNotes = assignedNotes;
        return this;
    }

    public ExistingPpeAssignedResponseBuilder setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
        return this;
    }

    public ExistingPpeAssignedResponseBuilder setReturnNotes(String returnNotes) {
        this.returnNotes = returnNotes;
        return this;
    }

    public ExistingPpeAssignedResponseBuilder setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public ExistingPpeAssignedResponseBuilder setExistingPpe(ExistingPpeResponse existingPpe) {
        this.existingPpe = existingPpe;
        return this;
    }

    public ExistingPpeAssignedResponseBuilder setEmployee(EmployeeResponse employee) {
        this.employee = employee;
        return this;
    }
}
