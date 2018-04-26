package com.groupa.ssi.model.domain.personalprotectionequipment;

import com.groupa.ssi.model.domain.ModelBase;
import com.groupa.ssi.model.domain.personnel.Employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * This class is top represent the existing (inventory) personal protection equipment (Ppe) assigned to employee
 * Created on April 26, 2018
 * @author Walker Colina
 */
@Entity
public class ExistingPpeAssigned extends ModelBase {

    @Column
    private String assignedNotes;

    @Column
    private Date assignedDate;

    @Column
    private String returnNotes;

    @Column
    private Date returnDate;

    @ManyToOne
    private ExistingPpe existingPpe;

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
