package com.groupa.ssi.response.personalprotectionequipment;

import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpe;
import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpeAssigned;
import com.groupa.ssi.model.domain.personnel.Employee;

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
    private ExistingPpe existingPpe;
    private Employee employee;

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
        return new ExistingPpeAssignedResponseBuilder()
                .setExistingPpeAssignedId(existingPpeAssigned.getId())
                .setAssignedNotes(existingPpeAssigned.getAssignedNotes())
                .setAssignedDate(existingPpeAssigned.getAssignedDate())
                .setReturnNotes(existingPpeAssigned.getReturnNotes())
                .setReturnDate(existingPpeAssigned.getReturnDate())
                .setExistingPpe(existingPpeAssigned.getExistingPpe())
                .setEmployee(existingPpeAssigned.getEmployee());
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

    public ExistingPpeAssignedResponseBuilder setExistingPpe(ExistingPpe existingPpe) {
        this.existingPpe = existingPpe;
        return this;
    }

    public ExistingPpeAssignedResponseBuilder setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }
}
