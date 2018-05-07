package com.groupa.ssi.model.domain.workitem;

import com.groupa.ssi.model.domain.ModelBase;
import com.groupa.ssi.model.domain.personnel.Employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * This class is top represent the work item assigned to employee
 * Created on May 7, 2018
 * @author Walker Colina
 */
@Entity
public class ExistingWorkItemAssigned extends ModelBase {

    @Column
    private String assignedNotes;

    @Column
    private Date assignedDate;

    @Column
    private String returnNotes;

    @Column
    private Date returnDate;

    @ManyToOne
    private ExistingWorkItem existingWorkItem;

    @ManyToOne
    private Employee employee;

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

    public ExistingWorkItem getExistingWorkItem() {
        return existingWorkItem;
    }

    public void setExistingWorkItem(ExistingWorkItem existingWorkItem) {
        this.existingWorkItem = existingWorkItem;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
