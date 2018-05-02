package com.groupa.ssi.model.domain.workitem;

import com.groupa.ssi.model.domain.ModelBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * This class is top represent the existing (inventory) work item
 * Created on May 1, 2018
 * @author Walker Colina
 */
@Entity
public class ExistingWorkItem extends ModelBase {

    @Column
    private String detail;

    @Column
    private Date purchaseDate;

    @Column
    private String serieNo;

    @ManyToOne
    private WorkItem workItem;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getSerieNo() {
        return serieNo;
    }

    public void setSerieNo(String serieNo) {
        this.serieNo = serieNo;
    }

    public WorkItem getWorkItem() {
        return workItem;
    }

    public void setWorkItem(WorkItem workItem) {
        this.workItem = workItem;
    }
}
