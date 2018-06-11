/*
@author: HENRYBC
*/
package com.groupa.ssi.model.domain.sickness;

import com.groupa.ssi.model.domain.ModelBase;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.model.domain.saClassification.SaCategory;
import com.groupa.ssi.model.domain.saClassification.SaType;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Sickness extends ModelBase {

    @Column
    private String description;

    @Column
    private Date dateSickness;

    @Column
    private String whereOccurr;

    @Column
    private Boolean statusRecord;

    @Column
    private Integer totalDaysOutOfWork;

    @Column
    private Integer totalDaysRestrictedTransferredWork;

    @OneToOne
    @JoinColumn(name = "saCategoryId")
    private SaCategory saCategory;

    @OneToOne
    @JoinColumn(name = "saTypeId")
    private SaType saType;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateSickness() {
        return dateSickness;
    }

    public void setDateSickness(Date dateSickness) {
        this.dateSickness = dateSickness;
    }

    public String getWhereOccurr() {
        return whereOccurr;
    }

    public void setWhereOccurr(String whereOccurr) {
        this.whereOccurr = whereOccurr;
    }

    public Boolean getStatusRecord() {
        return statusRecord;
    }

    public void setStatusRecord(Boolean statusRecord) {
        this.statusRecord = statusRecord;
    }

    public Integer getTotalDaysOutOfWork() {
        return totalDaysOutOfWork;
    }

    public void setTotalDaysOutOfWork(Integer totalDaysOutOfWork) {
        this.totalDaysOutOfWork = totalDaysOutOfWork;
    }

    public Integer getTotalDaysRestrictedTransferredWork() {
        return totalDaysRestrictedTransferredWork;
    }

    public void setTotalDaysRestrictedTransferredWork(Integer totalDaysRestrictedTransferredWork) {
        this.totalDaysRestrictedTransferredWork = totalDaysRestrictedTransferredWork;
    }

    public SaCategory getSaCategory() {
        return saCategory;
    }

    public void setSaCategory(SaCategory saCategory) {
        this.saCategory = saCategory;
    }

    public SaType getSaType() {
        return saType;
    }

    public void setSaType(SaType saType) {
        this.saType = saType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
