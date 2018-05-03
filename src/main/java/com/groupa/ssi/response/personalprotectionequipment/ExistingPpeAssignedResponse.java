package com.groupa.ssi.response.personalprotectionequipment;

import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpe;
import com.groupa.ssi.model.domain.personnel.Employee;

import java.util.Date;

/**
 * Created on April 30, 2018
 * @author Walker Colina
 */
public class ExistingPpeAssignedResponse {

    private Integer existingPpeAssignedId;
    private String assignedNotes;
    private Date assignedDate;
    private String returnNotes;
    private Date returnDate;
    private ExistingPpe existingPpe;
    private Employee employee;

    public Integer getExistingPpeAssignedId() {
        return existingPpeAssignedId;
    }

    public void setExistingPpeAssignedId(Integer existingPpeAssignedId) {
        this.existingPpeAssignedId = existingPpeAssignedId;
    }

    public String getAssignedNotes() {
        return assignedNotes;
    }

    public void setAssignedNotes(String assignedNotes) {
        this.assignedNotes = assignedNotes;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public String getReturnNotes() {
        return returnNotes;
    }

    public void setReturnNotes(String returnNotes) {
        this.returnNotes = returnNotes;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public ExistingPpe getExistingPpe() {
        return existingPpe;
    }

    public void setExistingPpe(ExistingPpe existingPpe) {
        this.existingPpe = existingPpe;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
