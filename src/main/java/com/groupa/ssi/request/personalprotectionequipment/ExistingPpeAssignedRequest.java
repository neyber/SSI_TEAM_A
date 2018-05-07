package com.groupa.ssi.request.personalprotectionequipment;

import java.util.Date;

/**
 * Created on April 30, 2018
 * @author Walker Colina
 */
public class ExistingPpeAssignedRequest {

    private String assignedNotes;
    private Date assignedDate;
    private String returnNotes;
    private Date returnDate;
    private Integer existingPpeId;
    private Integer employeeId;

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

    public Integer getExistingPpeId() {
        return existingPpeId;
    }

    public void setExistingPpeId(Integer existingPpeId) {
        this.existingPpeId = existingPpeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
